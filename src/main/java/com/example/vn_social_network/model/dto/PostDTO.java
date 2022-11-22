package com.example.vn_social_network.model.dto;

import com.example.vn_social_network.model.action.AccessModifier;
import com.example.vn_social_network.model.app_users.AppUsers;

import java.time.LocalDateTime;

public class PostDTO {

    private Long id;
    private String content;
    private String img;
    private LocalDateTime postTime;
    private AccessModifier accessModifier;
    private AppUsers appUsers;
    private int countComment;

    public PostDTO() {
    }

    public PostDTO(Long id,
                   String content,
                   String img,
                   LocalDateTime postTime,
                   AccessModifier accessModifier,
                   AppUsers appUsers,
                   int countCommemnt) {
        this.id = id;
        this.content = content;
        this.img = img;
        this.postTime = postTime;
        this.accessModifier = accessModifier;
        this.appUsers = appUsers;
        this.countComment = countCommemnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }

    public int getCountComment() {
        return countComment;
    }

    public void setCountComment(int countComment) {
        this.countComment = countComment;
    }
}
