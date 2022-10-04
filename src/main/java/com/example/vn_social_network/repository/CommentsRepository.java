package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
}
