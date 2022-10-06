package com.example.vn_social_network.service.app_users;

import com.example.vn_social_network.model.app_users.UserRela;
import com.example.vn_social_network.repository.IUserRelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRelaService  implements IUserRelaService{
    @Autowired
    IUserRelaRepository userRelaRepository;

    @Override
    public Iterable<UserRela> findAll() {
        return userRelaRepository.findAll();
    }

    @Override
    public Optional<UserRela> findById(Long id) {
        return userRelaRepository.findById(id);
    }

    @Override
    public UserRela save(UserRela userRela) {
        return userRelaRepository.save(userRela);
    }

    @Override
    public void remove(Long id) {
        userRelaRepository.deleteById(id);
    }
}
