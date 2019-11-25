package com.liujie.rabbitmq.receiver;

import com.alibaba.fastjson.JSON;
import com.liujie.config.RabbitConfig;
import com.liujie.config.RabbitConfigDev;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageReceiver {
    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitConfigDev.MESSAGE_QUEUE1)
    public void receiveTopic1(List<Integer> list) {
        System.out.println("【MessageReceiver1监听到消息】" + JSON.toJSONString(list));
    }

    @RabbitListener(queues = RabbitConfigDev.MESSAGE_QUEUE2)
    public void receiveTopic2(List<Integer> list) {
        System.out.println("【MessageReceiver2监听到消息】" + JSON.toJSONString(list));
    }

    @RabbitListener(queues = RabbitConfigDev.MESSAGE_QUEUE3)
    public void receiveTopic3(List<Integer> list) {
        System.out.println("【MessageReceiver3监听到消息】" + JSON.toJSONString(list));
    }


}
