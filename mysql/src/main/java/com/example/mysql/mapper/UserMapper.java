package com.example.mysql.mapper;

import com.example.mysql.model.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author merickbao
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2023-08-13 18:53:35
* @Entity com.example.mysql.model.entity.UserEntity
*/
public interface UserMapper extends BaseMapper<UserEntity> {

    List<UserEntity> findAll();

    void addUser(UserEntity userEntity);

    void deleteAll();
}




