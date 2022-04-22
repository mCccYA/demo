package com.mcc.g3n.demo.infrastructrue.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;


@Component
@Slf4j
public class ProducerDemo {

    @Value("${spring.mq.p.topic}")
    private String topic;

    @Autowired
    private DefaultMQProducer producer;

    public void sendDemo() {
        String body = "demo-" + LocalDateTime.now();
        Message message = new Message(topic, "demo",body.getBytes(StandardCharsets.UTF_8));
        try {
            SendResult sendResult = producer.send(message);
            log.info("message-{}：sendStatus： {}-messageId：{}", body, sendResult.getSendStatus(), sendResult.getMsgId());
        }  catch (Exception e) {
            log.error("message: {} failed", body, e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
