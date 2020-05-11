package com.example.demo;

import com.example.demo.usersystem.domain.User;
import com.example.demo.usersystem.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        this.userService.create(new User());
    }

}
