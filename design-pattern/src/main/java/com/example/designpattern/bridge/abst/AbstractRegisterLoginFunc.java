package com.example.designpattern.bridge.abst;

import com.example.designpattern.bridge.function.RegisterLoginFuncInterface;
import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.repo.UserRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/17 22:37
 */

public abstract class AbstractRegisterLoginFunc implements RegisterLoginFuncInterface {

    // 新增方法仅供子类使用
    protected String commomLogin(String account, String password, UserRepository userRepository) {
        UserInfo userInfo = userRepository.findByUserName(account);
        if (userInfo == null) {
            return "用户不存在";
        }
        return "登陆成功";
    }

    protected String commomRegister(UserInfo userInfo, UserRepository userRepository) {
        if (commomCheckUserExist(userInfo.getUserName(), userRepository)) {
            throw new RuntimeException("用户已存在");
        }
        userInfo.setCreateDate(new java.util.Date());
        userRepository.save(userInfo);
        return "注册成功";
    }

    protected boolean commomCheckUserExist(String userName, UserRepository userRepository) {
        UserInfo userInfo = userRepository.findByUserName(userName);
        if (userInfo == null) {
            return false;
        }
        return true;
    }

    public String login(String account, String password) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    public String register(UserInfo userInfo) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    public boolean checkUserExist(String userName) {
        throw new UnsupportedOperationException("不支持的操作");
    }

    public String login3rd(HttpServletRequest request) {
        throw new UnsupportedOperationException("不支持的操作");
    }
}
