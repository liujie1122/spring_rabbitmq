package com.liujie.rabbitmq;

import com.liujie.rabbitmq.send.*;
import org.junit.After;
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

	@After
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


	@Autowired
	private PersonSender personSender;
	@Autowired
	private MessageSender messageSender;
	@Autowired
	private YunSender yunSender;

	/**
	 * Fanout测试
	 * @throws Exception
	 */
	@Test
	public void testFanoutPersonSender() throws Exception {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Fanout.Delete";
		personSender.sendDelete(msg);
		msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Fanout.Insert";
		personSender.sendInsert(msg);
		Thread.sleep(3000);
	}





	/**
	 * TOPIC测试
	 * @throws Exception
	 */
	@Test
	public void testTopicMessageSender() throws Exception {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Topic:delete";
		messageSender.sendDelete(msg);
		msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Topic:insert";
		messageSender.sendInsert(msg);
		msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为Topic:update";
		messageSender.sendUpdate(msg);
		Thread.sleep(3000);
	}

	/**
	 * DIRECT测试
	 * @throws Exception
	 */
	@Test
	public void testDirectYunSender() throws Exception {
		String msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为direct.delete";
		yunSender.sendDelete(msg);
		msg = "我在尝试用Spring整合RabbitMq发送消息,消息类型为direct.insert";
		yunSender.sendInsert(msg);

		Thread.sleep(3000);
	}



}
