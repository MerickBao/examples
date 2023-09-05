package com.example.mysql.service;

import com.example.mysql.model.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author merickbao
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2023-08-13 18:53:35
*/
public interface UserService extends IService<UserEntity> {

    List<UserEntity> findAllUsers();

    void addUser(UserEntity userEntity);

    void clear();
}
