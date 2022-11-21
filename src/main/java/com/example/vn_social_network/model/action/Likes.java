package com.example.vn_social_network.model.action;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Likes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
//    @JsonManagedReference
    private AppUsers appUsers;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn()
    private Posts posts;

    private Boolean status;
}
