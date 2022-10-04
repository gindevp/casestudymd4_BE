package com.example.vn_social_network.model.app_users;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"roles", "authorities"})
public class AppUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String avatarUrl;
    @ManyToOne
    private AppRoles appRoles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfo_id", referencedColumnName = "id")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "likes_id")
    private Likes likes;

    @ManyToOne
    @JoinColumn(name ="userRela_id" )
    private UserRela userRela;

    @OneToMany(targetEntity = Comments.class)
    private List<Comments> comments;


}
