package com.example.designpattern.bridge.function;

import com.example.designpattern.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/16 22:28
 */

public interface RegisterLoginFuncInterface {

    public String login(String account, String password);

    public String register(UserInfo userInfo);

    public boolean checkUserExist(String userName);

    // 第三方登陆接口
    public String login3rd(HttpServletRequest request);
}
