package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.app_users.AppUsers;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUsers, Long> {
}
