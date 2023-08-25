package com.example.elasticsearch.web;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/8/22 22:59
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/save")
    public String save(@RequestParam String id) {
        Object o = userRepository.save(new User(id, "name", "emial", 111));
        return o.toString();
    }

    @GetMapping("/find")
    public User find(@RequestParam String id) {
        return userRepository.findById(id).orElse(new User());
    }
}
