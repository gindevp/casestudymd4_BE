package com.example.vn_social_network.model.app_users;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import com.example.vn_social_network.model.action.Posts;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"roles", "authorities"})

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class AppUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String avatarUrl;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRoles> appRoles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private UserInfo userInfo;

    @OneToMany(targetEntity = Likes.class)
    @JsonIgnore
//    @JsonBackReference
    private List<Likes> likes;

    @ManyToOne
    @JoinColumn()
//    @JsonBackReference
    private UserRela userRela;

    @OneToMany(targetEntity = Comments.class)
//    @JsonManagedReference
    @JsonIgnore
    private List<Comments> comments;

    @OneToMany(targetEntity = Posts.class)
    @JsonIgnore
//    @JsonManagedReference
    private List<Posts> posts;


}
