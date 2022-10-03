package com.example.vn_social_network.model.app_users;

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
    private boolean isActive;
    private String studyAt;
    private String workingAt;
    private String favorites;
    private String otherInfo;
    private Date dateOfBirth;
    private Date createdAt;
    @OneToOne
    private AppUsers appUsers;
}
