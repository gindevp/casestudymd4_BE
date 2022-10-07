package com.example.vn_social_network.controller.app_user;


import com.example.vn_social_network.model.app_users.UserRela;
import com.example.vn_social_network.service.app_users.IUserRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userRela")
public class UserRelaController {
    @Autowired
    IUserRelaService userRelaService;

    @GetMapping
    public ResponseEntity<Iterable<UserRela>> userRelaFinAll(){
        List<UserRela> userRela = (List<UserRela>) userRelaService.findAll();
        if(userRela.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userRela,HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<UserRela> saveUserRela(@PathVariable UserRela userRela){
        return new ResponseEntity<>(userRelaService.save(userRela),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserRela> deleteUserRela(@PathVariable Long id){
        Optional<UserRela>userRelaOptional=userRelaService.findById(id);
        if(!userRelaOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRelaService.remove(id);
        return new ResponseEntity<>(userRelaOptional.get(),HttpStatus.NO_CONTENT);
    }

}
