package com.liujie.rabbitmq.send;


import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class YunSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendDelete(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.YUN_EXCHANGE, "yun.delete", string);
    }

    public void sendInsert(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.YUN_EXCHANGE, "yun.insert", string);
    }


}