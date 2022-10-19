package com.example.vn_social_network.service.app_users;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.model.app_users.UserInfo;
import com.example.vn_social_network.service.IGeneralService;

public interface IUserInfoService extends IGeneralService<UserInfo> {
    Iterable<UserInfo> findAllByAppUsers(AppUsers appUsers);
}
