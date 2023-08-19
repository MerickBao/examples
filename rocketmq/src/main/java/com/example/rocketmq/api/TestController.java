package com.example.rocketmq.api;

import com.example.rocketmq.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/19 16:43
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send-msg")
    public String sendMessage() {
        User user = new User();
        user.setName("123");
        user.setEmail("abc@gmail.com");
        rocketMQTemplate.convertAndSend("TopicTest:tag-bbh", user);
        rocketMQTemplate.syncSendDelayTimeSeconds("TopicTest:tag-bbh", user, 30);
        return "send success";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
