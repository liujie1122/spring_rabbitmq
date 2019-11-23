package com.liujie.task;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerThreadPool implements Runnable {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run() {
//        rabbitTemplate.

    }
}
