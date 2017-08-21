package com.stm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.stm.data.entity.Group;
import com.stm.data.entity.User;
import com.stm.service.GroupServiceImpl;
import com.stm.service.UserServiceImpl;
/*
 * test 1 2
 */
@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
       
        
    }

}
