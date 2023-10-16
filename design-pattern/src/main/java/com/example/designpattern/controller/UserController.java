package com.example.designpattern.controller;

import com.example.designpattern.adapter.Login3rdAdapter;
import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Resource
    private Login3rdAdapter login3rdAdapter;

    @PostMapping("/login")
    public String login(String account, String password) {
        return userService.login(account, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserInfo userInfo) {
        return userService.register(userInfo);
    }

    // 通过gitee登录
    @GetMapping("/gitee")
    public String gitee(String code, String state) {
        return login3rdAdapter.loginByGitee(code, state);
    }
}
