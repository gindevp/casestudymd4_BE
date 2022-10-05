package com.example.vn_social_network.model.app_users;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class UserRela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = AppUsers.class)
    @JsonManagedReference
    private List<AppUsers> follower;


    @OneToMany(targetEntity = AppUsers.class)
    @JsonManagedReference
    private List<AppUsers> following;


}
