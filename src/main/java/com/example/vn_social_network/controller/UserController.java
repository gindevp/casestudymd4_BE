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
    @GetMapping
    public ResponseEntity<Iterable<AppUsers>> showList(){
        return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<AppUsers> addUser(@RequestBody Optional<AppUsers> users){
        if(users.isPresent()){
            return new ResponseEntity<>(userService.save(users.get()), HttpStatus.CREATED);
        }
        return null;
    }
}
