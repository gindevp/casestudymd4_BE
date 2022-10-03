package com.example.vn_social_network.model.users;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String user_name;
    private String password;
    private String full_name;
    private String email;
    private String avatar_url;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInfo_id", referencedColumnName = "id")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "likes_id")
    private Likes likes;

    @ManyToOne
    @JoinColumn(name ="userRela_id" )
    private UserRela userRela;

    @ManyToOne
    @JoinColumn(name = "comments")
    private Comments comments;


}
