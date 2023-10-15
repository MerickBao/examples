package com.example.designpattern.adapter;

import com.example.designpattern.service.UserService;

/**
 * @desc: 继承自UserService，实现Login3rdTarget接口，实现第三方登陆的适配
 * @author: merickbao
 * @since: 2023/10/15 18:31
 */

public class Login3rdAdapter extends UserService implements Login3rdTarget {
    @Override
    public String loginByDitee(String code, String state) {
        return null;
    }

    @Override
    public String loginByWechat(String... params) {
        return null;
    }

    @Override
    public String loginByQQ(String... params) {
        return null;
    }
}
