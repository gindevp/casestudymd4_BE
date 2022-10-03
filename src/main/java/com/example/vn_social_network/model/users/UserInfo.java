package com.example.vn_social_network.model.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean is_active;
    private String study_at;
    private String working_at;
    private String favorites;
    private String other_info;
    private Date date_of_birth;
    private Date created_at;
    @OneToOne
    private Users users;
}
