package com.example.vn_social_network;

import com.example.vn_social_network.repository.IPostsRepository;
import com.example.vn_social_network.service.action.post.IPostService;
import com.example.vn_social_network.service.action.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VnSocialNetworkApplication {
    public static void main(String[] args) {
        SpringApplication.run(VnSocialNetworkApplication.class, args);


    }

}
