package com.example.designpattern.bridge.abst;

import com.example.designpattern.bridge.function.RegisterLoginFuncInterface;
import com.example.designpattern.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/16 22:42
 */

public abstract class AbstactRegisterLoginComponent {

    // 桥接模式的核心，将抽象部分与实现部分分离，使它们都可以独立的变化
    protected RegisterLoginFuncInterface registerLoginFuncInterface;

    public AbstactRegisterLoginComponent(RegisterLoginFuncInterface registerLoginFuncInterface) {
        // 校验参数类型
        validate(registerLoginFuncInterface);
        this.registerLoginFuncInterface = registerLoginFuncInterface;
    }

    // 校验参数为RegisterLoginFuncInterface类型，final修饰，不可被重写
    protected final void validate(RegisterLoginFuncInterface funcInterface) {
        if (!(funcInterface instanceof RegisterLoginFuncInterface)) {
            throw new UnsupportedOperationException("参数类型错误");
        }
    }

    protected abstract String login(String username, String password);

    protected abstract String register(UserInfo userInfo);

    protected abstract boolean checkUserExist(String userName);

    protected abstract String login3rd(HttpServletRequest request);
}
