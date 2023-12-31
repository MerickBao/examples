package com.example.designpattern.adapter;

import com.alibaba.fastjson.JSONObject;
import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.service.UserService;
import com.example.designpattern.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

/**
 * @desc: 继承自UserService，实现Login3rdTarget接口，实现第三方登陆的适配
 * @author: merickbao
 * @since: 2023/10/15 18:31
 */
@Component
public class Login3rdAdapter extends UserService implements Login3rdTarget {

    @Value("${gitee.state}")
    private String giteeState;

    @Value("${gitee.token.url}")
    private String giteeTokenUrl;

    @Value("${gitee.user.url}")
    private String giteeUserUrl;

    @Value("${gitee.username.prefix}")
    private String giteeUserPrefix;

    @Override
    public String loginByGitee(String code, String state) {
        // 进行state判断，state的值是前端和后端商定好的，前端将state传给Gitee平台，Gitee平台回传给回掉地址，后端进行判断
        // 如果state不一致，说明不是从本网站发起的请求，直接返回错误
        if (!giteeState.equals(state)) {
            throw new UnsupportedOperationException("Invalid state");
        }
        // 请求Gitee平台，获取token，并携带code
        String tokenUrl = giteeTokenUrl.concat(code);
        JSONObject tokenResponse = HttpClientUtils.execute(tokenUrl, HttpMethod.POST);
        String token = String.valueOf(tokenResponse.get("access_token"));
        // 请求Gitee平台，获取用户信息，并携带token
        String userUrl = giteeUserUrl.concat(token);
        JSONObject userResponse = HttpClientUtils.execute(userUrl, HttpMethod.POST);
        // 获取用户信息，userName添加前缀GITEE@，密码保持与userName一致
        String userName = giteeUserPrefix.concat(String.valueOf(userResponse.get("name")));
        String password = userName;
        // 复用UserService的注册和登录方法
        return autoRegister3rdAndLogin(userName, password);
    }

    private String autoRegister3rdAndLogin(String userName, String password) {
        // 检查用户是否存在
        if (super.checkUserExists(userName)) {
            // 用户存在，直接登录
            return super.login(userName, password);
        }
        // 用户不存在，注册用户
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setUserPassword(password);
        super.register(userInfo);
        return super.login(userName, password);
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
