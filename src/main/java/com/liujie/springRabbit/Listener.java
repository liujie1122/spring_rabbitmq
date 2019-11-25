package com.liujie.springRabbit;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

//    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
//            value = @Queue(value = "spring.test.queue",durable = "true"),//声明队列名称，并且指定了序列化
//            exchange = @Exchange(//声明交换机类型和名称
//                    value = "spring.test.exchange",
//                    type = ExchangeTypes.TOPIC
//            ),
//            key = {"#.#"}))//监听的路由：全部都监听
//    public void listen1(String msg){
//        System.out.println("listen1:"+msg);
//    }
//
//
//    @RabbitListener(bindings = @QueueBinding(    //@QueueBinding:队列的绑定关系
//            value = @Queue(value = "spring.test.queue",durable = "true"),//声明队列名称，并且指定了序列化
//            exchange = @Exchange(//声明交换机类型和名称
//                    value = "spring.test.exchange",
//                    type = ExchangeTypes.FANOUT
//            ),
//            key = {"spring_test"}))//监听的路由：全部都监听
//    public void listen2(String msg){
//        System.out.println("listen2:"+msg);
//    }
//
//
//    @RabbitListener(queues = "spring_test3")//监听的路由：全部都监听
//    public void listen3(String msg){
//        System.out.println("listen3:"+msg);
//    }
//
//    @RabbitListener(queues = "simple_queue")//监听的路由：全部都监听
//    public void listen4(String msg){
////        int i = 10/0;0
//        System.out.println("我是消费者listen4，接收到了消息内容是:"+msg);
//    }
}
