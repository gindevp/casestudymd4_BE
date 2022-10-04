package com.example.vn_social_network.model.action;


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
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @OneToMany(targetEntity = Img.class)
    private List<String> img;
    private int likeCount;
    private LocalDateTime postTime;

    @ManyToOne
    @JoinColumn(name = "access_modifier_id")
    private AccessModifier accessModifier;

    @OneToMany(targetEntity = Likes.class)
    private List<Likes> likes;

    @OneToMany(targetEntity = Comments.class)
    private List<Comments> comments;

    public Posts() {
    }

    public Posts(Long id,
                 String content,
                 List<String> img,
                 int likeCount,
                 LocalDateTime postTime,
                 AccessModifier accessModifier,
                 List<Likes> likes,
                 List<Comments> comments) {
        this.id = id;
        this.content = content;
        this.img = img;
        this.likeCount = likeCount;
        this.postTime = postTime;
        this.accessModifier = accessModifier;
        this.likes = likes;
        this.comments = comments;
    }
}
