package com.example.vn_social_network.controller.action;

import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.model.action.PostsForm;
import com.example.vn_social_network.service.action.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostRestController {
    @Value("C:\\Users\\Acer\\OneDrive\\Desktop\\CG\\Project\\Md4\\img\\")
    private String fileUpload;

    @Autowired
    private IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<Posts>> findAllPosts(@RequestParam Optional<String> search, Pageable pageable) {
        Page<Posts> posts = postService.findAll(pageable);
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (search.isPresent()) {
            return new ResponseEntity<>(postService.findAllByContent(search.get(), pageable), HttpStatus.OK);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Posts> findPostById(@PathVariable Long id) {
        Optional<Posts> posts = postService.findById(id);
        if (!posts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(posts.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Posts> savePost(@RequestBody PostsForm postsForm) {

        List<MultipartFile> multipartFiles = postsForm.getImg();
        List<String> listFileName= new ArrayList<>();
        for (int i = 0; i < multipartFiles.size(); i++) {
            String fileName = multipartFiles.get(i).getOriginalFilename();
            try {
                FileCopyUtils.copy(postsForm.getImg().get(i).getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            listFileName.add(fileName);
        }
        LocalDateTime postTime = LocalDateTime.now();
        Posts posts = new Posts(
                postsForm.getId(),
                postsForm.getContent(),
                listFileName,
                postsForm.getLikeCount(),
                postTime,
                postsForm.getAccessModifier(),
                postsForm.getLikes(),
                postsForm.getComments(),
                postsForm.getUsers()
        );
        postService.save(posts);

        return new ResponseEntity<>(HttpStatus.CREATED);
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
        return new ResponseEntity<>(postsOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/home")
    public ModelAndView getAllPosts() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("posts", postService.findAll());
        return modelAndView;
    }


}
