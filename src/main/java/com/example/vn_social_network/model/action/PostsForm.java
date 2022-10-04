package com.example.vn_social_network.model.action;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PostsForm {

    private Long id;
    private String content;
    private List<MultipartFile> img;
    private int likeCount;
    private LocalDateTime postTime;
    private AccessModifier accessModifier;
    private List<Likes> likes;
    private List<Comments> comments;
}
