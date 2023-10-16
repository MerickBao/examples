package com.example.designpattern.adapter;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/15 18:29
 */

public interface Login3rdTarget {

    // 通过gitee登录
    public String loginByGitee(String code, String state);

    // 通过微信登录
    public String loginByWechat(String ... params);

    // 通过QQ登录
    public String loginByQQ(String ... params);
}
