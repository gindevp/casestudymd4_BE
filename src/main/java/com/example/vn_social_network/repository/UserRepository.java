package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.app_users.AppUsers;


import com.example.vn_social_network.model.app_users.AppUsers;
import org.apache.catalina.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUsers, Long> {
    @Query("select (count(a) > 0) from AppUsers a where a.userName = ?1")
    Boolean existsByUserName(String name);
    AppUsers findByUserName(String username);
}
