package com.example.vn_social_network.model.app_users;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import com.example.vn_social_network.model.action.Posts;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
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
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRoles> appRoles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id", referencedColumnName = "id")
    @JsonManagedReference
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

    @OneToMany(targetEntity = Friends.class)
    private List<Friends>friends;

    @OneToMany(targetEntity = Posts.class)
    @JsonIgnore
//    @JsonManagedReference
    private List<Posts> posts;


    public AppUsers() {
    }

    public AppUsers(Long id,
                    String userName,
                    String password,
                    String fullName,
                    String email,
                    String avatarUrl,
                    Set<AppRoles> appRoles,
                    UserInfo userInfo,
                    List<Likes> likes,
                    UserRela userRela,
                    List<Comments> comments,
                    List<Friends> friends,
                    List<Posts> posts) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.appRoles = appRoles;
        this.userInfo = userInfo;
        this.likes = likes;
        this.userRela = userRela;
        this.comments = comments;
        this.friends = friends;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Set<AppRoles> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(Set<AppRoles> appRoles) {
        this.appRoles = appRoles;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public UserRela getUserRela() {
        return userRela;
    }

    public void setUserRela(UserRela userRela) {
        this.userRela = userRela;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }
}
