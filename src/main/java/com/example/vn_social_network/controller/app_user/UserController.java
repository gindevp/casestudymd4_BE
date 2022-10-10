package com.example.vn_social_network.controller.app_user;

import com.example.vn_social_network.model.app_users.AppRoles;
import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.service.app_users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/profile/{username}")
    public ResponseEntity<AppUsers> findUserByName(@PathVariable String username){
        return new ResponseEntity<>(userService.findByUserName(username),HttpStatus.OK);
    }


//  http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<Iterable<AppUsers>> showList(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<AppUsers> customerList= (List<AppUsers>) userService.findAll();
        if(customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }
// http://localhost:8080/api/users/register
    @PostMapping("/register")
    public ResponseEntity<AppUsers> addUser(@RequestBody Optional<AppUsers> users){
        Set<AppRoles> roles= new HashSet<>();
        AppRoles appRoles= new AppRoles();
        appRoles.setId(1L);
        roles.add(appRoles);
        users.get().setAppRoles(roles);
        if(users.isPresent()){
            if(!userService.existsByUserName(users.get().getUserName())){
                return new ResponseEntity<>(userService.save(users.get()), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
    // http://localhost:8080/api/users/edit/{id}
    @PutMapping("/edit/{id}")
    public ResponseEntity<AppUsers> editUser(@RequestBody AppUsers users, @PathVariable Long id){
        Optional<AppUsers> appUsersOptional= userService.findById(id);
        if(!appUsersOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        users.setId(appUsersOptional.get().getId());
        return new ResponseEntity<>(userService.save(users),HttpStatus.OK);
    }
    // http://localhost:8080/api/users/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AppUsers> deleteUser(@PathVariable Long id) {
        Optional<AppUsers> appUsersOptional = userService.findById(id);
        if(!appUsersOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(id);
            return new ResponseEntity<>(appUsersOptional.get(),HttpStatus.OK);
    }
    //http://localhost:8080/api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<AppUsers> showUser(@PathVariable Long id){
        Optional<AppUsers> appUsersOptional= userService.findById(id);
        if(!appUsersOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(appUsersOptional.get(),HttpStatus.OK);
    }
}
