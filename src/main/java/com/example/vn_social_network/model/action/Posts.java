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
@RequiredArgsConstructor
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String img;
    private int likeCount;
    private LocalDateTime postTime;

    @ManyToOne
    @JoinColumn(name = "access_modifier_id")
    private AccessModifier accessModifier;

    @OneToMany(targetEntity = Likes.class)
    private List<Likes> likes;

    @OneToMany(targetEntity = Comments.class)
    private List<Comments> comments;
}
