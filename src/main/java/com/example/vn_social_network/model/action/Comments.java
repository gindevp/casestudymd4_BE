package com.example.vn_social_network.model.action;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonBackReference
    private AppUsers users;

    @ManyToOne
    @JoinColumn(name = "posts_id")
    @JsonBackReference
    private Posts posts;

    private String cmtContent;

    public Comments() {
    }

    public Comments(Long id, AppUsers users, Posts posts, String cmtContent) {
        this.id = id;
        this.users = users;
        this.posts = posts;
        this.cmtContent = cmtContent;
    }
}
