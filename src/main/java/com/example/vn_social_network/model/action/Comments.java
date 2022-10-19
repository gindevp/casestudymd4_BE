package com.example.vn_social_network.model.action;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn()
//    @JsonBackReference
//    @JsonIgnore
    private AppUsers appUsers;

    @ManyToOne()
    @JoinColumn(name = "posts_id")
//    @JsonIgnore
    @JsonBackReference
    private Posts posts;

    private String cmtContent;

    public Comments() {
    }

    public Comments(Long id, AppUsers appUsers, Posts posts, String cmtContent) {
        this.id = id;
        this.appUsers = appUsers;
        this.posts = posts;
        this.cmtContent = cmtContent;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }
}
