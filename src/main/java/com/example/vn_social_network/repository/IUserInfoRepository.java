package com.example.vn_social_network.repository;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.model.app_users.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserInfoRepository extends PagingAndSortingRepository<UserInfo, Long> {
    Iterable<UserInfo> findAllByAppUsers(AppUsers appUsers);
}
