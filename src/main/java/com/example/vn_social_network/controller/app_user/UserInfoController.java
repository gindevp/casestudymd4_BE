package com.example.vn_social_network.controller.app_user;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.model.app_users.UserInfo;
import com.example.vn_social_network.service.action.comments.ICommentsService;
import com.example.vn_social_network.service.action.post.IPostService;
import com.example.vn_social_network.service.app_users.IUserInfoService;
import com.example.vn_social_network.service.app_users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/profile")
@CrossOrigin("*")
public class UserInfoController {
    @Autowired
    IUserInfoService userInfoService;

    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<UserInfo>> finAllComments(){
        Iterable<UserInfo>userInfos=userInfoService.findAll() ;
        return new ResponseEntity<>(userInfos, HttpStatus.OK);
    }
    @GetMapping("/appuser/{id}")
    private ResponseEntity<Iterable<UserInfo>> findUserInfoByAppUser(@PathVariable Long id){
        Optional<AppUsers> appUsers = userService.findById(id);
        Iterable<UserInfo> userInfos = userInfoService.findAllByAppUsers(appUsers.get());
        return new ResponseEntity<>(userInfos,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> findById(@PathVariable Long id){
        Optional<UserInfo> userInfoOptional = userInfoService.findById(id);
        if(!userInfoOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userInfoOptional.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo){
        return new ResponseEntity<>(userInfoService.save(userInfo),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateUserInfo (@PathVariable Long id,@RequestBody UserInfo userInfo){
        Optional<UserInfo> userInfoOptional = userInfoService.findById(id);
        if(!userInfoOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userInfo.setId(userInfoOptional.get().getId());
        return new ResponseEntity<>(userInfoService.save(userInfo),HttpStatus.OK);
    }

    //    @DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<UserInfo> deleteUserInfo (@PathVariable Long id){
        Optional<UserInfo> userInfo = userInfoService.findById(id);
        if (!userInfo.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userInfoService.remove(id);
        return new ResponseEntity<>(userInfo.get(),HttpStatus.NO_CONTENT);
    }
}
