package com.example.designpattern.bridge.abst;

import com.example.designpattern.bridge.function.RegisterLoginFuncInterface;
import com.example.designpattern.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/16 22:47
 */

public class RegisterLoginComponent extends AbstactRegisterLoginComponent {
    // 通过构造函数，传入桥梁接口的具体类型
    public RegisterLoginComponent(RegisterLoginFuncInterface registerLoginFuncInterface) {
        super(registerLoginFuncInterface);
    }

    @Override
    protected String login(String username, String password) {
        // 调用桥梁接口的具体实现
        return registerLoginFuncInterface.login(username, password);
    }

    @Override
    protected String register(UserInfo userInfo) {
        return null;
    }

    @Override
    protected boolean checkUserExist(String userName) {
        return false;
    }

    @Override
    protected String login3rd(HttpServletRequest request) {
        return null;
    }
}
