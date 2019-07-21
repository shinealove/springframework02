package com.example.demo;

import com.example.demo.customtag.User;
import com.example.demo.myTestBean.MyTestBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSimpleLoad(){
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");

	}

	@Test
	public void testCustomtag(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("testCustomTag.xml");
		User user = (User) bf.getBean("testbean");
		System.out.println(user.getUsername() + ", " + user.getEmail());
	}
}
