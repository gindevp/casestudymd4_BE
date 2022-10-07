package com.example.vn_social_network.service.action.like;

import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.repository.ILikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LikesService implements ILikesService {

    @Autowired
    ILikesRepository likesRepository;
    @Override
    public Iterable findAll() {
        return likesRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return likesRepository.findById(id);
    }

    @Override
    public Likes save(Likes likes) {
        return likesRepository.save(likes);
    }

    @Override
    public void remove(Long id) {
        likesRepository.disableByStatus(id);
    }

}
