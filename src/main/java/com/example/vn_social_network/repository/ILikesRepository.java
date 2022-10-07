package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.model.action.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikesRepository extends JpaRepository<Likes,Long> {
    @Query(nativeQuery = true,value = "update likes SET status= 0 where id=?1;")
    void disableByStatus(Long id);
}
