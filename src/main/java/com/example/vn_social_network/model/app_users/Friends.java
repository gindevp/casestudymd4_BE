package com.example.vn_social_network.model.app_users;

import javax.persistence.*;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AppUsers appUsers;

    public Friends() {
    }

    public Friends(Long id, AppUsers appUsers) {
        this.id = id;
        this.appUsers = appUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }
}
