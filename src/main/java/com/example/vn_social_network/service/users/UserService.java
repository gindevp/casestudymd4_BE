package com.example.vn_social_network.service.users;

import com.example.vn_social_network.model.app_users.AppUsers;
import com.example.vn_social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public Iterable<AppUsers> findAll() {
        return userRepository.findAll() ;
    }

    @Override
    public Optional<AppUsers> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public AppUsers save(AppUsers users) {
        return userRepository.save(users);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Boolean existsByUserName(String name) {
        return userRepository.existsByUserName(name);
    }
    public AppUsers findByUserName(String username){
        AppUsers appUser = userRepository.findByUserName(username);
        return appUser;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUsers  appUsers= userRepository.findByUserName(username);
        return new User(appUsers.getUserName(), appUsers.getPassword(), appUsers.getAppRoles());
    }
}
