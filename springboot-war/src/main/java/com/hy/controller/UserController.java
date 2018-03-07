package com.hy.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hy.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    public  User register() {
        User user = new User();
        user.setName("hello");
        user.setSex("female");
        user.setBirthday(new Date());
        return user;
    }
}