package com.example.vn_social_network.model.app_users;

import com.example.vn_social_network.model.action.Comments;
import com.example.vn_social_network.model.action.Likes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

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
    @JoinColumn(name = "userInfo_id", referencedColumnName = "id")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "likes_id")
    @JsonBackReference
    private Likes likes;

    @ManyToOne
    @JoinColumn(name ="userRela_id" )
    @JsonBackReference
    private UserRela userRela;

    @OneToMany(targetEntity = Comments.class)
    @JsonManagedReference
    private List<Comments> comments;
}
