package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.action.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikesRepository extends JpaRepository<Likes,Long> {
//    @Modifying
    @Query(nativeQuery = true,value = "update likes SET status= 0 where id=:id;")
    void disableByStatus(Long id);
}
