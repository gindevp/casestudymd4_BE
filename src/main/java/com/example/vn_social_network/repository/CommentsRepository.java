package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
}
