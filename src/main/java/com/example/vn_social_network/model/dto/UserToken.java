package com.example.vn_social_network.model.dto;

import com.example.vn_social_network.model.app_users.AppRoles;

import java.util.Set;

public class UserToken {
    private long id;
    private String username;
    private String token;
    private Set<AppRoles> roles;

    public UserToken(long id, String username, String token, Set<AppRoles> roles) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.roles = roles;
    }

    public UserToken() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<AppRoles> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRoles> roles) {
        this.roles = roles;
    }
}
