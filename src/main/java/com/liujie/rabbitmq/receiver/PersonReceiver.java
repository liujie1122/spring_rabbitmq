package com.liujie.rabbitmq.receiver;


import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class PersonReceiver {

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfigDev.PERSON_QUEUE1)
    public void receiveTopic1(String string) {
        System.out.println("【PersonReceiver1监听到消息】" + string);
    }

    @RabbitListener(queues = RabbitConfigDev.PERSON_QUEUE2)
    public void receiveTopic2(String string) {
        System.out.println("【PersonReceiver2监听到消息】" + string);
    }


}
