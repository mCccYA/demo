package com.mcc.g3n.demo.app.task;

import com.mcc.g3n.demo.infrastructrue.mq.ProducerDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskDemo {

    @Autowired
    private ProducerDemo producerDemo;

    @Scheduled(cron = "0/5 * * * * ?")
    public void demoExecutor() {
        producerDemo.sendDemo();
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void demoExecuto1r() {
        System.out.println(1);
    }
}
