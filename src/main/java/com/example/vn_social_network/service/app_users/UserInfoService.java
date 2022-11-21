package com.example.vn_social_network.service.app_users;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.model.app_users.UserInfo;
import com.example.vn_social_network.repository.IUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements IUserInfoService{

    @Autowired
    private IUserInfoRepository userInfoRepository;
    @Override
    public Iterable<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userInfoRepository.findById(id);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    @Override
    public void remove(Long id) {
        userInfoRepository.deleteById(id);
    }

    @Override
    public Iterable<UserInfo> findAllByAppUsers(AppUsers appUsers) {
        return userInfoRepository.findAllByAppUsers(appUsers);
    }
}
