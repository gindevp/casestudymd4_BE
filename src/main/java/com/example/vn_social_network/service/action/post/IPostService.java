package com.example.vn_social_network.service.action.post;

import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService extends IGeneralService<Posts> {
        Page<Posts> findAll(Pageable pageable);
        Page<Posts> findAllByContent(String content, Pageable pageable);
}
