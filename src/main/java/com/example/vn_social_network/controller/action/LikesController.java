package com.example.vn_social_network.controller.action;


import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.service.action.like.ILikesService;
import com.example.vn_social_network.service.action.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Likes")
@CrossOrigin("*")
public class LikesController {
    @Autowired
    ILikesService likesService;



    @GetMapping
    public ResponseEntity<Iterable<Likes>> finAllLikes(){
        List<Likes> likes = (List<Likes>)likesService.findAll();
        if (likes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(likes,HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Likes>saveLikes(@PathVariable Likes likes){
        return new ResponseEntity<>(likesService.save(likes),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Likes> deleteLikes(@PathVariable Long id){
        Optional<Likes>likesOptional=likesService.findById(id);
        if (!likesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        likesService.remove(id);
        return new ResponseEntity<>(likesOptional.get(),HttpStatus.OK);
    }
}
