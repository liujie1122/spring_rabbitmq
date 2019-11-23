package com.liujie.rabbitmq.receiver;


import com.liujie.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE1)
    public void receiveDirect1(String string) {
        System.out.println("【receiveDirect1监听到消息】" + string);
    }

    @RabbitListener(queues = RabbitConfig.DIRECT_QUEUE2)
    public void receiveDirect2(String string) {
        System.out.println("【receiveDirect2监听到消息】" + string);
    }


}
