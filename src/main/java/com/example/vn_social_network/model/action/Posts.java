package com.example.vn_social_network.model.action;


import com.example.vn_social_network.model.app_users.AppUsers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
//@RequiredArgsConstructor

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Posts implements Comparable<Posts>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
//    @OneToOne(targetEntity = Img.class)
//    @JsonManagedReference
    private String img;
//    private int likeCount;
    private LocalDateTime postTime;

    @ManyToOne
    @JoinColumn()
//    @JsonBackReference
    private AccessModifier accessModifier;

    @OneToMany(targetEntity = Likes.class)
//    @JsonManagedReference
    private List<Likes> likes;

    @OneToMany(targetEntity = Comments.class)
    @JsonBackReference
    private List<Comments> comments;

    @ManyToOne()
    @JoinColumn()
//    @JsonBackReference
    private AppUsers appUsers;

    public Posts() {
    }

    public Posts(Long id,
                 String content,
                 String img,
                 LocalDateTime postTime,
                 AccessModifier accessModifier,
                 List<Likes> likes,
                 List<Comments> comments,
                 AppUsers appUsers)
    {
        this.id = id;
        this.content = content;
        this.img = img;
        this.postTime = postTime;
        this.accessModifier = accessModifier;
        this.likes = likes;
        this.comments = comments;
        this.appUsers = appUsers;
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

    @Override
    public int compareTo(Posts o) {
        return getPostTime().compareTo(o.getPostTime());
    }
}
