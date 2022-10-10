package com.example.vn_social_network.service.action.post;

import com.example.vn_social_network.model.action.Posts;
import com.example.vn_social_network.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService extends IGeneralService<Posts> {
        Page<Posts> findAll(Pageable pageable);
        public List<Posts> findAllByTimeDESC();
        Page<Posts> findAllByContent(String content, Pageable pageable);
}
