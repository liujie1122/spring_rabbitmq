package com.liujie.rabbitmq.send;

import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 第一个参数：TopicExchange名字
    // 第二个参数：Route-Key
    // 第三个参数：要发送的内容
    public void sendDelete(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.MESSAGE_EXCHANGE, "message.delete", string);
    }

    public void sendInsert(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.MESSAGE_EXCHANGE, "message.insert", string);
    }

    public void sendUpdate(String string) {
        this.rabbitTemplate.convertAndSend(RabbitConfigDev.MESSAGE_EXCHANGE, "message.update", string);
    }
}