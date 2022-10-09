package com.example.vn_social_network.controller.action;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.service.action.comments.ICommentsService;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.service.action.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin("*")
public class CommentsController {
    @Autowired
    ICommentsService commentsService;

    @Autowired
    IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Comments>> finAllComments(){
        List<Comments>comments=(List<Comments>) commentsService.findAll();
        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(comments,HttpStatus.OK);
    }
    @GetMapping("/post/{id}")
    private ResponseEntity<Iterable<Comments>> findCommentToPost(@PathVariable Long id){
        Optional<Posts> posts = postService.findById(id);
        Iterable<Comments> comments = commentsService.findAllByPosts(posts.get());
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comments> finCommentsid(@PathVariable Long id){
        Optional<Comments> commentsOptional = commentsService.findById(id);
        if(!commentsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentsOptional.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comments> saveComments(@RequestBody Comments comments){
        return new ResponseEntity<>(commentsService.save(comments),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComments (@PathVariable Long id,@RequestBody Comments comments){
        Optional<Comments> commentsOptional = commentsService.findById(id);
        if(!commentsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        comments.setId(commentsOptional.get().getId());
        return new ResponseEntity<>(commentsService.save(comments),HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<Comments> deleteComments (@PathVariable Long id){
        Optional<Comments> commentsOptional = commentsService.findById(id);
        if (!commentsOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentsService.remove(id);
        return new ResponseEntity<>(commentsOptional.get(),HttpStatus.NO_CONTENT);
    }
}
