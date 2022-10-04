package com.example.vn_social_network.service.action;

import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.repository.IPostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostsRepository postsRepository;

    @Override
    public Iterable<Posts> findAll() {
        return postsRepository.findAll();
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }

    @Override
    public Posts save(Posts posts) {
        return postsRepository.save(posts);
    }

    @Override
    public void remove(Long id) {
        postsRepository.deleteById(id);
    }

    @Override
    public Page<Posts> findAll(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    @Override
    public Page<Posts> findAllByContent(String content, Pageable pageable) {
        return postsRepository.findAllByContent(content, pageable);
    }
}
