package com.example.mysql.controller;

import com.example.mysql.aop.DemoAnnotation;
import com.example.mysql.model.entity.UserEntity;
import com.example.mysql.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/13 18:03
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/ping")
    public String ping() {
        log.info("ping");
        return "pong";
    }

    @DemoAnnotation("test")
    @GetMapping("/users")
    public List<UserEntity> findAllUsers() {
        userService.clear();
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = UserEntity.builder().name("abc").age(18).email("abc@gmail.com").build();
            userService.addUser(userEntity);
        }
        return userService.findAllUsers();
    }
}
