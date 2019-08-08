package com.example.demo.springmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleLogic(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleLogic(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("this is init method");
	}

	private void handleLogic(HttpServletRequest request, HttpServletResponse response){
		System.out.println("handle myLogic");
		ServletContext sc = getServletContext();

		RequestDispatcher rd = null;

		rd = sc.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e){
			e.printStackTrace();
		}
	}
}
