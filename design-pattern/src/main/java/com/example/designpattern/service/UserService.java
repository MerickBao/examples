package com.example.designpattern.service;

import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/14 21:49
 */
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    // 登录
    public String login(String account, String password) {
        UserInfo userInfo = userRepository.findByUserNameAndUserPassword(account, password);
        if (userInfo == null) {
            return "account or password is wrong";
        }
        return "login success";
    }

    // 注册
    public String register(UserInfo userInfo) {
        if (checkUserExists(userInfo.getUserName())) {
            throw new RuntimeException("user already exists");
        }
        userInfo.setCreateDate(new java.util.Date());
        try {
            // 保存用户信息
            userRepository.save(userInfo);
            return "register success";
        } catch (Exception e) {
            throw new RuntimeException("register failed");
        }
    }

    // 检查用户是否存在
    private boolean checkUserExists(String userName) {
        return userRepository.findByUserName(userName) != null;
    }
}
