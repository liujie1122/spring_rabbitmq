package com.liujie.rabbitmq;

import com.liujie.rabbitmq.send.DirectSender;
import com.liujie.rabbitmq.send.FanoutSender;
import com.liujie.rabbitmq.send.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestClass;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RabbitmqApplicationTests {

	@Test
	void contextLoads() {
	}

	@AfterTestClass
	public void afterTest() throws InterruptedException {
		System.out.println("Thread.sleep(10000);");
		Thread.sleep(10000);
	}



	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void test1() throws InterruptedException {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Topic：#.#";
		List<String> list = new ArrayList();
		list.add(msg);
		this.amqpTemplate.convertAndSend("spring.test.exchange","a.b",list);
		Thread.sleep(10000);
	}

	@Test
	public void test2() throws InterruptedException {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Fanout";
		List<String> list = new ArrayList();
		list.add(msg);
		this.amqpTemplate.convertAndSend("spring.test.exchange","spring_test",list);
		Thread.sleep(10000);
	}

	@Test
	public void test3() throws InterruptedException {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Fanout";
		List<String> list = new ArrayList();
		list.add(msg);
		this.amqpTemplate.convertAndSend("spring_test3",list);
		Thread.sleep(10000);
	}

	@Test
	public void test4() throws InterruptedException {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为simple";
		List<String> list = new ArrayList();
		list.add(msg);
		this.amqpTemplate.convertAndSend("simple_queue",list);
		Thread.sleep(10000);
	}


	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
	private TopicSender topicSender;
	@Autowired
	private DirectSender directSender;

	/**
	 * Fanout测试
	 * @throws Exception
	 */
	@Test
	public void testFanout() throws Exception {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Fanout";
		fanoutSender.send(msg);
	}





	/**
	 * TOPIC测试
	 * @throws Exception
	 */
	@Test
	public void testTopic() throws Exception {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Topic";
		topicSender.send(msg);
	}

	/**
	 * DIRECT测试
	 * @throws Exception
	 */
	@Test
	public void testDirect() throws Exception {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为direct";
		directSender.send(msg);
	}

}
