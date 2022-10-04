package com.example.vn_social_network.controller;

<<<<<<< HEAD
=======

>>>>>>> hien
import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;
//    @GetMapping()
//    public ModelAndView getUser(){
//        return new ModelAndView("user");
//    }


//  http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<Iterable<AppUsers>> showList(){
        List<AppUsers> customerList= (List<AppUsers>) userService.findAll();
        if(customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }
// http://localhost:8080/api/users/register
    @PostMapping("/register")
    public ResponseEntity<AppUsers> addUser(@RequestBody Optional<AppUsers> users){
        if(!users.isPresent()){
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.save(users.get()), HttpStatus.CREATED);
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
