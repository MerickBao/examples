package com.example.rocketmq.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author: merickbao
 * @desc:
 * @since: 2023/8/19 18:43
 */
@Component
@RocketMQMessageListener(consumerGroup = "test-consumer-group", topic = "TopicTest", selectorExpression = "tag-bbh")
public class MqConsumerListener implements RocketMQListener<Object> {

    @Override
    public void onMessage(Object o) {
        System.out.println(o.toString());
    }
}
