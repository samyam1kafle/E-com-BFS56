package com.samyam.e_com.service;

import com.samyam.e_com.entity.User;
import com.samyam.e_com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : e-com
 * @CreatedDate : 02/10/2024, Wednesday
 **/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager manager;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    public User register(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public String verifyUser(User user) {
        Authentication authentication =
                manager
                        .authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUserName());
        }
        return "failure";
    }
}
