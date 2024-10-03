package com.samyam.e_com.repository;

import com.samyam.e_com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : e-com
 * @CreatedDate : 02/10/2024, Wednesday
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
