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
@Getter
@Setter
//@RequiredArgsConstructor

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @OneToMany(targetEntity = Img.class)
//    @JsonManagedReference
    private List<String> img;
    private int likeCount;
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

    @ManyToOne
    @JoinColumn()
//    @JsonBackReference
    private AppUsers appUsers;

    public Posts() {
    }

    public Posts(Long id,
                 String content,
                 List<String> img,
                 int likeCount,
                 LocalDateTime postTime,
                 AccessModifier accessModifier,
                 List<Likes> likes,
                 List<Comments> comments,
                 AppUsers appUsers)
    {
        this.id = id;
        this.content = content;
        this.img = img;
        this.likeCount = likeCount;
        this.postTime = postTime;
        this.accessModifier = accessModifier;
        this.likes = likes;
        this.comments = comments;
        this.appUsers = appUsers;
    }
}
