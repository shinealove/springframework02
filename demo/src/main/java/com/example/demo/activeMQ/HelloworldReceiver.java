package com.example.demo.activeMQ;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.TextMessage;

public class HelloworldReceiver {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-activeMQ.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");
		TextMessage msg = (TextMessage) jmsTemplate.receive(destination);
		System.out.println("received msg is: " + msg.getText());
	}
}
