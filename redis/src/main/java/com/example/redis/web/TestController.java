package com.example.redis.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/20 22:57
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/save")
    public Object save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return "success";
    }


}
