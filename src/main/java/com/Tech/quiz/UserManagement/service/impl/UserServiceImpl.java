package com.Tech.quiz.UserManagement.service.impl;


import com.Tech.quiz.UserManagement.repository.UserRepository;
import com.Tech.quiz.UserManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String userName) {
                return userRepository.findByEmail(userName).orElseThrow(()->new UsernameNotFoundException("User Not Found"));
            }
        };
    }
}
