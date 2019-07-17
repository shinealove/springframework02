package com.example.demo;

import com.example.demo.customtag.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCustomtag(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("testCustomTag.xml");
		User user = (User) bf.getBean("testbean");
		System.out.println(user.getUsername() + ", " + user.getEmail());
	}
}
