package com.example.vn_social_network.model.app_users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private boolean isActive;
    private String studyAt;
    private String workingAt;
    private String favorites;
    private String otherInfo;
    private LocalDate dateOfBirth;
    private LocalDate createdAt;
    private String address;
    @OneToOne(mappedBy = "userInfo")
    @JsonBackReference
    private AppUsers appUsers;


    public UserInfo() {
    }

    public UserInfo(Long id,
                    boolean isActive,
                    String studyAt,
                    String workingAt,
                    String favorites,
                    String otherInfo,
                    LocalDate dateOfBirth,
                    LocalDate createdAt,
                    String address,
                    AppUsers appUsers) {
        this.id = id;
        this.isActive = isActive;
        this.studyAt = studyAt;
        this.workingAt = workingAt;
        this.favorites = favorites;
        this.otherInfo = otherInfo;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.address = address;
        this.appUsers = appUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getStudyAt() {
        return studyAt;
    }

    public void setStudyAt(String studyAt) {
        this.studyAt = studyAt;
    }

    public String getWorkingAt() {
        return workingAt;
    }

    public void setWorkingAt(String workingAt) {
        this.workingAt = workingAt;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AppUsers getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(AppUsers appUsers) {
        this.appUsers = appUsers;
    }
}
