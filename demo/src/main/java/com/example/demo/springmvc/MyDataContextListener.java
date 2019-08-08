package com.example.demo.springmvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyDataContextListener implements ServletContextListener {

	private ServletContext context = null;

	public MyDataContextListener(){

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.context = sce.getServletContext();
		context.setAttribute("myData", "this is myData");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		this.context = null;
	}
}
