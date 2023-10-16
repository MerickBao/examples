package com.example.designpattern.bridge.function;

import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.repo.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/16 22:34
 */
@Component
public class RegisterLoginByDefault implements RegisterLoginFuncInterface {

    @Resource
    private UserRepository userRepository;

    // 重构login方法
    @Override
    public String login(String account, String password) {
        UserInfo userInfo = userRepository.findByUserName(account);
        if (userInfo == null) {
            return "用户不存在";
        }
        return "登陆成功";
    }

    @Override
    public String register(UserInfo userInfo) {
        if (checkUserExist(userInfo.getUserName())) {
            throw new RuntimeException("用户已存在");
        }
        userInfo.setCreateDate(new Date());
        userRepository.save(userInfo);
        return "注册成功";
    }

    @Override
    public boolean checkUserExist(String userName) {
        UserInfo userInfo = userRepository.findByUserName(userName);
        if (userInfo == null) {
            return false;
        }
        return true;
    }

    // 不需要实现
    @Override
    public String login3rd(HttpServletRequest request) {
        return null;
    }
}
