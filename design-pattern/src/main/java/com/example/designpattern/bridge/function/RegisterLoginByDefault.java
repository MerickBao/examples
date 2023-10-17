package com.example.designpattern.bridge.function;

import com.example.designpattern.bridge.abst.AbstractRegisterLoginFunc;
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
public class RegisterLoginByDefault extends AbstractRegisterLoginFunc implements RegisterLoginFuncInterface {

    @Resource
    private UserRepository userRepository;

    // 重构login方法
    @Override
    public String login(String account, String password) {
        return super.commomLogin(account, password, userRepository);
    }

    @Override
    public String register(UserInfo userInfo) {
        return super.commomRegister(userInfo, userRepository);
    }

    @Override
    public boolean checkUserExist(String userName) {
        return super.commomCheckUserExist(userName, userRepository);
    }

}
