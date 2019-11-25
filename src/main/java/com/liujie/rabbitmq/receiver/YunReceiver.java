package com.liujie.rabbitmq.receiver;


import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class YunReceiver {
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfigDev.YUN_QUEUE1)
    public void receiveDirect1(String string) {
        System.out.println("【YunReceiver1监听到消息】" + string);
    }

    @RabbitListener(queues = RabbitConfigDev.YUN_QUEUE2)
    public void receiveDirect2(String string) {
        System.out.println("【YunReceiver2监听到消息】" + string);
    }


}
