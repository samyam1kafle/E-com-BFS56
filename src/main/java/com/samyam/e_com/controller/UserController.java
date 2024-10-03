package com.samyam.e_com.controller;

import com.samyam.e_com.entity.User;
import com.samyam.e_com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : e-com
 * @CreatedDate : 02/10/2024, Wednesday
 **/
@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.verifyUser(user);
    }
}
