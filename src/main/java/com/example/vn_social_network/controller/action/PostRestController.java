package com.example.vn_social_network.controller.action;

import com.example.vn_social_network.model.action.AccessModifier;
import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.model.dto.PostDTO;
import com.example.vn_social_network.service.action.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostRestController {
    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;


    @Autowired
    private IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Posts>> findAllPosts(@RequestParam Optional<String> search, Pageable pageable) {
//        Page<Posts> posts = postService.findAll(pageable);
        List<Posts> postsList = postService.findAllByTimeDESC();
        if (postsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (search.isPresent()) {
            return new ResponseEntity<>(postService.findAllByContent(search.get(), pageable), HttpStatus.OK);
        }

        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<Iterable<PostDTO>>findAllPostsAndComments(Pageable pageable){
//        List<Posts> posts = postService.findAllByTimeDESC();
//        List<PostDTO> postDTOS = new ArrayList<>();
//        for(int i=0; i<posts.size(); i++){
//            Long id= posts.get(i).getId();
//            String content= posts.get(i).getContent();
//            String img =posts.get(i).getImg();
//            LocalDateTime postTime=posts.get(i).getPostTime();
//            AccessModifier accessModifier=posts.get(i).getAccessModifier();
//            List<Likes> likes= posts.get(i).getLikes();
//            List<Comments> comments= posts.get(i).getComments();
//            AppUsers appUsers= posts.get(i).getAppUsers();
//            Long id1 = posts.get(i).getId();
//            Optional<Posts> posts1 = postService.findById(id1);
//            List<Comments> commentsList = postService.findALlCommentsByPost(posts1.get());
//            int commentCount= commentsList.size();
//            PostDTO postDTO = new PostDTO(id,content,img,postTime,accessModifier,likes,comments,appUsers,commentCount);
//            postDTOS.add(postDTO);
//        }
//        return new ResponseEntity<>(postDTOS,HttpStatus.OK);
//    }

//    @GetMapping("/commentsCount")
//    public ResponseEntity<String> commentsCount(){
//        return new ResponseEntity<>(postService.commentsCount(),HttpStatus.OK);
//    }




    @GetMapping("/{id}")
    public ResponseEntity<Posts> findPostById(@PathVariable Long id) {
        Optional<Posts> posts = postService.findById(id);
        if (!posts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts.get(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Posts> savePost(@RequestBody Posts posts) {
        return new ResponseEntity<>(  postService.save(posts),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable Long id, @RequestBody Posts posts) {
        Optional<Posts> postOptional = postService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        posts.setId(postOptional.get().getId());
        return new ResponseEntity<>(postService.save(posts), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Posts> deletePost(@PathVariable Long id) {
        Optional<Posts> postsOptional = postService.findById(id);
        if (!postsOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/home")
//    public ModelAndView getAllPosts() {
//        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("posts", postService.findAll());
//        return modelAndView;
//    }


}
