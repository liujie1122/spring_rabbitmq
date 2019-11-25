package com.liujie.rabbitmq.receiver;

import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfigDev.MESSAGE_QUEUE1)
    public void receiveTopic1(String string) {
        System.out.println("【MessageReceiver1监听到消息】" + string);
    }

    @RabbitListener(queues = RabbitConfigDev.MESSAGE_QUEUE2)
    public void receiveTopic2(String string) {
        System.out.println("【MessageReceiver2监听到消息】" + string);
    }

    @RabbitListener(queues = RabbitConfigDev.MESSAGE_QUEUE3)
    public void receiveTopic3(String string) {
        System.out.println("【MessageReceiver3监听到消息】" + string);
    }


}
