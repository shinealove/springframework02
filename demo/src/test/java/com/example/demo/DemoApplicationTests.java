package com.example.demo;

import com.example.demo.aop.TestBean;
import com.example.demo.aop.jdkProxy.MyInvocationHandler;
import com.example.demo.aop.jdkProxy.UserService;
import com.example.demo.aop.jdkProxy.UserServiceImpl;
import com.example.demo.beanFactory.StringToPhoneNumberConverter;
import com.example.demo.customtag.User;
import com.example.demo.eventListener.TestEvent;
import com.example.demo.myTestBean.MyTestBean;
import com.example.demo.rmi.HelloRMIService;
import com.example.demo.userManager.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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
	public void testUserManager(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("userManagerTest.xml");
		UserManager userManager = (UserManager) bf.getBean("userManager");
		System.out.println(userManager);
	}

	@Test
	public void testBeanFactory(){
		ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest02.xml"));
		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("bfpp");
		bfpp.postProcessBeanFactory(bf);
		System.out.println(bf.getBean("simpleBean"));
	}
	@Test
	public void testMessageResource(){
		String[] configs = {"messageSourceTest.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		Object[] params = {"John", new GregorianCalendar().getTime()};
		String str1 = ctx.getMessage("test", params, Locale.US);
		String str2 = ctx.getMessage("test", params, Locale.CHINA);
		System.out.println(str1);
		System.out.println(str2);

		TestEvent event = new TestEvent("hello", "msg");
		ctx.publishEvent(event);
	}

	@Test
	public void testStringToPhoneNumberConvert(){
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new StringToPhoneNumberConverter());
	}

	@Test
	public void testAspect(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("aspectTest.xml");
		TestBean bean = (TestBean) bf.getBean("test");
		bean.test();
	}

	@Test
	public void testJDKProxy(){
		UserService userService = new UserServiceImpl();

		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);

		UserService proxy = (UserService) invocationHandler.getProxy();

		proxy.add();
	}

	@Test
	public void testSpringJDBC(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("jdbcTest.xml");
		com.example.demo.jdbcConnect.UserService userService = (com.example.demo.jdbcConnect.UserService ) bf.getBean("userService");
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

	@Test
	public void testRMIServer(){
		ApplicationContext bf = new ClassPathXmlApplicationContext("RMIServer.xml");
	}
	@Test
	public void testRMIClient(){
		testRMIServer();
		ApplicationContext bf = new ClassPathXmlApplicationContext("RMIClient.xml");
		HelloRMIService hms = bf.getBean("myClient", HelloRMIService.class);
		System.out.println(hms.getAdd(1, 2));
	}
}
