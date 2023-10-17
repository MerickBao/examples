package com.example.designpattern.service;

import com.example.designpattern.bridge.abst.AbstactRegisterLoginComponent;
import com.example.designpattern.bridge.abst.RegisterLoginComponent;
import com.example.designpattern.bridge.function.RegisterLoginByDefault;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/17 23:07
 */
@Service
public class UserBridgeService {

    public String login(String account, String password) {
        // 通过桥梁接口调用具体实现
        AbstactRegisterLoginComponent registerLoginComponent = new RegisterLoginComponent(new RegisterLoginByDefault());
        return registerLoginComponent.login(account, password);
    }
}
