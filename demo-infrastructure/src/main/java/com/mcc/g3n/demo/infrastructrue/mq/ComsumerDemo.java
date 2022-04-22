package com.mcc.g3n.demo.infrastructrue.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "demo-topic", consumerGroup = "mcc-cGroup")
public class ComsumerDemo implements RocketMQListener<String> {

    @Override
    public void onMessage(String message ) {
        System.out.println(message);
    }
}
