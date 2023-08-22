package com.example.elasticsearch.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/8/22 22:59
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
