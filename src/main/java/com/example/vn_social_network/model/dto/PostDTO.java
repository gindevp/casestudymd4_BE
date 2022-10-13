package com.example.vn_social_network.model.dto;

import com.example.vn_social_network.model.action.AccessModifier;
import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.model.app_users.AppUsers;

import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
    private Long id;
    private String content;
    private String img;
    private LocalDateTime postTime;
    private AccessModifier accessModifier;
    private List<Likes> likes;
    private List<Comments> comments;
    private AppUsers appUsers;
    private int commentCount;

    public PostDTO() {
    }

    public PostDTO(Long id,
                   String content,
                   String img,
                   LocalDateTime postTime,
                   AccessModifier accessModifier,
                   List<Likes> likes,
                   List<Comments> comments,
                   AppUsers appUsers,
                   int commentCount) {
        this.id = id;
        this.content = content;
        this.img = img;
        this.postTime = postTime;
        this.accessModifier = accessModifier;
        this.likes = likes;
        this.comments = comments;
        this.appUsers = appUsers;
        this.commentCount = commentCount;
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

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
