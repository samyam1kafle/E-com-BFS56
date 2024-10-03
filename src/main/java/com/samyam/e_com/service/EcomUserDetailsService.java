package com.samyam.e_com.service;

import com.samyam.e_com.entity.EcomUserDetails;
import com.samyam.e_com.entity.User;
import com.samyam.e_com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : e-com
 * @CreatedDate : 02/10/2024, Wednesday
 **/
@Service
public class EcomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null) {
            System.out.printf("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }
        return new EcomUserDetails(user);
    }
}
