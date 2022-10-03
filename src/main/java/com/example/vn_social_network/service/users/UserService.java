package com.example.vn_social_network.service.users;

import com.example.vn_social_network.model.users.Users;
import com.example.vn_social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll() ;
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void remove(Long id) {
        userRepository.findById(id);
    }
}
