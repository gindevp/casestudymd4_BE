package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentsRepository extends PagingAndSortingRepository<Comments,Long> {
//   @Query(nativeQuery = true, value = "select * from comments where posts_id=?1")
//    Iterable<Comments> findAllByPostsId(Long posts_id);

    @Query(nativeQuery = true, value = "select * from comments order by id DESC ;")
    List<Comments> findALlByTimeDESC(Posts posts);
    Iterable<Comments> findAllByPosts(Posts posts);
}
