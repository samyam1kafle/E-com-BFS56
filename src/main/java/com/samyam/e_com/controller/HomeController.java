package com.samyam.e_com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : e-com
 * @CreatedDate : 02/10/2024, Wednesday
 **/
@RestController
public class HomeController {

    @GetMapping("/")
    public String welcomeMessage(){
        return "API-V1 ... Ecommerce";
    }
}
