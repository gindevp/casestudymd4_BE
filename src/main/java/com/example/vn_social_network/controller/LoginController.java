package com.example.vn_social_network.controller;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.model.dto.UserToken;
import com.example.vn_social_network.service.app_users.JwtService;
import com.example.vn_social_network.service.app_users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserService appUserService;


    @GetMapping("/a")
    public ResponseEntity<AppUsers> appUsersResponseEntity(){
        AppUsers appUsers = new AppUsers();
        appUsers.setUserName("d");
        appUsers.setPassword("d");
        System.out.println("A");
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<UserToken> login(@RequestBody AppUsers appUser){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUserName(), appUser.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            AppUsers appUser1 = appUserService.findByUserName(appUser.getUserName());
            return new  ResponseEntity(new UserToken(appUser1.getId(),appUser1.getUserName(),token,appUser1.getAppRoles()), HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }

    }

//    @PostMapping("/register")
//    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role();
//        role.setId(2);
//        roles.add(role);
//        appUser.setRoles(roles);
//        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
//    }
}
