package com.example.designpattern.controller;

import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/14 21:49
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(String account, String password) {
        return userService.login(account, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }
}
