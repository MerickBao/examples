package com.example.learnpigeon.config;

import com.example.learnpigeon.bean.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/6 19:13
 */
@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean1() {
        return new MyBean();
    }

    @Bean
    public MyBean myBean2() {
        return new MyBean();
    }
}
