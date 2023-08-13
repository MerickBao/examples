package com.example.mysql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mysql.model.entity.UserEntity;
import com.example.mysql.service.UserService;
import com.example.mysql.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author merickbao
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2023-08-13 18:53:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAllUsers() {
        return userMapper.findAll();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userMapper.addUser(userEntity);
    }
}




