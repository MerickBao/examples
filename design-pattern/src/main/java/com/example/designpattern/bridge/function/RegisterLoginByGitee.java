package com.example.designpattern.bridge.function;

import com.alibaba.fastjson.JSONObject;
import com.example.designpattern.pojo.UserInfo;
import com.example.designpattern.repo.UserRepository;
import com.example.designpattern.service.UserService;
import com.example.designpattern.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/16 22:35
 */
@Component
public class RegisterLoginByGitee extends UserService implements RegisterLoginFuncInterface {

    @Value("${gitee.state}")
    private String giteeState;

    @Value("${gitee.token.url}")
    private String giteeTokenUrl;

    @Value("${gitee.user.url}")
    private String giteeUserUrl;

    @Value("${gitee.username.prefix}")
    private String giteeUserPrefix;

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserService userService;

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

    @Override
    public String login3rd(HttpServletRequest request) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");
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

}
