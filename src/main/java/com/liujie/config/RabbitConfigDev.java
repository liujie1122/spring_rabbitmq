package com.liujie.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  在这里，我们初始化了交换器（exchange）与队列（queue）之间的绑定管理，
 *  同时在系统启动时，会自动的生成对应的交换器和队列保存到RabbitMq消息服务中间件中
 *  （当然，如果RabbitMq中已经存在了对应的交换机和队列，则不会重新创建）
 */
@Configuration
public class RabbitConfigDev {
    /**
     * 声明交换机和队列的名称，一次声明，对此调用
     */
    //topic
    public static final String MESSAGE_QUEUE1 = "message.queue1";
    public static final String MESSAGE_QUEUE2 = "message.queue2";
    public static final String MESSAGE_QUEUE3 = "message.queue3";
    public static final String MESSAGE_EXCHANGE = "message.exchange";

    //fanout
    public static final String PERSON_QUEUE1 = "person.queue1";
    public static final String PERSON_QUEUE2 = "person.queue2";
    public static final String PERSON_EXCHANGE = "person.exchange";

    //redirect模式
    public static final String YUN_QUEUE1 = "yun.queue1";
    public static final String YUN_EXCHANGE = "yun.exchange";
    public static final String YUN_QUEUE2 ="yun.queue2" ;
    /**
     * 生成对应的交换机和队列对象
     */
    /**
     * Topic模式
     *
     * @return
     */
    @Bean
    public Queue messageQueue1() {
        return new Queue(MESSAGE_QUEUE1);
    }

    @Bean
    public Queue messageQueue2() {
        return new Queue(MESSAGE_QUEUE2);
    }

    @Bean
    public Queue messageQueue3() {
        return new Queue(MESSAGE_QUEUE3);
    }

    /**
     * direct类型的Exchange路由规则是完全匹配binding key与routing key，但这种严格的匹配方式在很多情况下不能满足实际业务需求。topic类型的Exchange在匹配规则上进行了扩展，它与direct类型的Exchage相似，也是将消息路由到binding key与routing key相匹配的Queue中，但这里的匹配规则有些不同，它约定：

     routing key为一个句点号“. ”分隔的字符串（我们将被句点号“. ”分隔开的每一段独立的字符串称为一个单词），如“stock.usd.nyse”、“nyse.vmw”、“quick.orange.rabbit”
     binding key与routing key一样也是句点号“. ”分隔的字符串
     binding key中可以存在两种特殊字符“*”与“#”，用于做模糊匹配，其中“*”用于匹配一个单词，“#”用于匹配多个单词（可以是零个）】
     * @return
     */

    @Bean
    public TopicExchange messageExchange() {
        return new TopicExchange(MESSAGE_EXCHANGE);
    }

    /**
     * 绑定交换机与队列之间的关系
     * @return
     */
    @Bean
    public Binding messageBinding1() {
        return BindingBuilder.bind(messageQueue1()).to(messageExchange()).with("message.insert");
    }

    @Bean
    public Binding messageBinding2() {
        return BindingBuilder.bind(messageQueue2()).to(messageExchange()).with("message.delete");
    }

    @Bean
    public Binding messageBinding3() {
        return BindingBuilder.bind(messageQueue3()).to(messageExchange()).with("message.#");
    }


    /**
     * Fanout模式
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，
     * 绑定了这个交换机的所有队列都收到这个消息。
     * @return
     */
    @Bean
    public Queue personQueue1() {
        return new Queue(PERSON_QUEUE1);
    }

    @Bean
    public Queue personQueue2() {
        return new Queue(PERSON_QUEUE2);
    }
    /**
     * fanout类型的Exchange路由规则非常简单，
     * 它会把所有发送到该Exchange的消息路由转发到所有与它绑定的Queue中。
     */
    @Bean
    public FanoutExchange personExchange() {
        return new FanoutExchange(PERSON_EXCHANGE);
    }

    @Bean
    public Binding personBinding1() {
        return BindingBuilder.bind(personQueue1()).to(personExchange());
    }

    @Bean
    public Binding personBinding2() {
        return BindingBuilder.bind(personQueue2()).to(personExchange());
    }

    /**
     * direct模式
     * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致，
     * 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
     *
     * direct类型的Exchange路由规则也很简单，
     * 它会把消息路由到那些binding key与routing key完全匹配的Queue中。
     * @return
     */
    @Bean
    public Queue yunQueue1() {
        return new Queue(YUN_QUEUE1);
    }

    @Bean
    public Queue yunQueue2() {
        return new Queue(YUN_QUEUE2);
    }

    @Bean
    public DirectExchange yunExchange() {
        return new DirectExchange(YUN_EXCHANGE);
    }

    @Bean
    public Binding yunBinding1() {
        return BindingBuilder.bind(yunQueue1()).to(yunExchange()).with("yun.delete");
    }

    @Bean
    public Binding yunBinding2() {
        return BindingBuilder.bind(yunQueue2()).to(yunExchange()).with("yun.insert");
    }

}
