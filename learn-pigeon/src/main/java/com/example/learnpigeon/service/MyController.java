package com.example.learnpigeon.service;

import com.example.learnpigeon.bean.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/6 19:16
 */
@RestController
public class MyController {

    @Autowired
    @Qualifier("myBean1")
    private MyBean myBean;

    @GetMapping("/hello")
    public String hello() {
        Number number = 1;  // autoboxing
        myBean.say("merickbao");
        test(1, "2", 3L, 4.0, 9);
        return "hello";
    }

    public <A, B, C, D> A test(A a, B b, C c, D d, int f) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
        System.out.println(d.getClass().getName());
        return a;
    }
}
