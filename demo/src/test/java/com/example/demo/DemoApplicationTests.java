package com.example.demo;

import com.example.demo.circleDependence.BeanFactoryAwareTest;
import com.example.demo.customtag.User;
import com.example.demo.jdbcConnect.UserService;
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

import java.util.List;

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
	@Test
	public void testCircleByConstructor(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("circleDependenceTest.xml");
	}
	@Test
	public void testBeanFactoryAware(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanFactoryAwareTest.xml");
		BeanFactoryAwareTest test = (BeanFactoryAwareTest) ctx.getBean("beanFactoryAwareTest");
		test.testAware();
	}

	@Test
	public void testSpringJDBC(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("jdbcTest.xml");
		UserService userService = (UserService) bf.getBean("userService");
		com.example.demo.jdbcConnect.User user = new com.example.demo.jdbcConnect.User();
		user.setName("张三");
		user.setAge(20);
		user.setSex("男");
		userService.save(user);

		List<com.example.demo.jdbcConnect.User> person1 = userService.getUsers();
		System.out.println("++++++++++++++++++++++得到所有User");
		for(com.example.demo.jdbcConnect.User person2: person1){
			System.out.println(person2.getId() + "  " + person2.getName() + "  " + person2.getAge() + "  " + person2.getSex());
		}
	}
}
