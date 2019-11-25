package com.liujie.rabbitmq.send;


import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDelete(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.PERSON_EXCHANGE, "person.delete", string);
    }

    public void sendInsert(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.PERSON_EXCHANGE, "person.insert", string);
    }
}