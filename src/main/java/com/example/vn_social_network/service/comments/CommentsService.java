package com.example.vn_social_network.service.comments;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentsService implements ICommentsService{
    @Autowired
    CommentsRepository commentsRepository;
    @Override
    public Iterable findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return commentsRepository.findById(id);
    }

    @Override
    public Comments save(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public void remove(Long id) {
        commentsRepository.findById(id);
    }

    @Override
    public Iterable<Comments> findAllByPosts(Posts posts) {
        return commentsRepository.findAllByPosts(posts);
    }
}