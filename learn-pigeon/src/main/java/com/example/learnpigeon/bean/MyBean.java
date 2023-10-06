package com.example.learnpigeon.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/6 19:12
 */

@Slf4j
public class MyBean {

    public void say(String name) {
        log.info("hello " + name);
    }
}
