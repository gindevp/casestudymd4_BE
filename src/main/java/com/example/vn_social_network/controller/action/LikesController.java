package com.example.vn_social_network.controller.action;


import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.service.action.like.ILikesService;
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
    @PostMapping
    public ResponseEntity<Likes>saveLikes(@RequestBody Likes likes){
        return new ResponseEntity<>(likesService.save(likes),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Likes> enableLikes(@PathVariable Long id){
        Optional<Likes>likesOptional=likesService.findById(id);
        if (!likesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        likesOptional.get().setStatus(true);
        return new ResponseEntity<>(likesOptional.get(),HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Likes> deleteLikes(@PathVariable Long id){
//        Optional<Likes>likesOptional=likesService.findById(id);
//        if (!likesOptional.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        likesService.remove(id);
//        return new ResponseEntity<>(likesOptional.get(),HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<Likes> disableLikes(@PathVariable Long id){
        Optional<Likes>likesOptional=likesService.findById(id);
        if (!likesOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        likesOptional.get().setStatus(false);
        return new ResponseEntity<>(likesOptional.get(),HttpStatus.OK);
    }
}
