package com.liujie.task;

import com.liujie.rabbitmq.send.MessageSender;
import com.liujie.rabbitmq.send.PersonSender;
import com.liujie.rabbitmq.send.YunSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProducerThreadPool implements Runnable {
    @Autowired
    private MessageSender messageSender;
    @Autowired
    private YunSender yunSender;
    @Autowired
    private PersonSender personSender;
    int i=0;
    List<Integer> list = new ArrayList();
    @Override
    public void run() {
//        rabbitTemplate.
        while(true){
            i++;
            list.add(i);
            if (i%3==1){
                messageSender.sendDelete(list);
                messageSender.sendInsert(list);
                messageSender.sendUpdate(list);
            }else if (i%3==2){
                personSender.sendInsert("personSender:sendInsert");
                personSender.sendDelete("personSender:sendDelete");
            }else {
                yunSender.sendDelete("yunSender:sendDelete");
                yunSender.sendInsert("yunSender:sendInsert");
            }
        }

    }
}
