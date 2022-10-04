package com.example.vn_social_network.model.action;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class AccessModifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(targetEntity = Posts.class)
    @JsonManagedReference
    private List<Posts> posts;

    public AccessModifier() {
    }

    public AccessModifier(Long id, String name, List<Posts> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }
}
