package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostsRepository extends PagingAndSortingRepository<Posts,Long> {
    Page<Posts> findAllByContent(String content, Pageable pageable);
}
