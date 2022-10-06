package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface CommentsRepository extends JpaRepository<Comments,Long> {
//   @Query(nativeQuery = true, value = "select * from comments where posts_id=?1")
//    Iterable<Comments> findAllByPostsId(Long posts_id);


    Iterable<Comments> findAllByPosts(Posts posts);
}
