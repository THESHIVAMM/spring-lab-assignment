package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hello() {
		System.out.println("Hello ctr");
	}
	

	@Override
	public void init() throws ServletException {
		System.out.println("init method");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("doget of servlet hello");
	}
	@Override
	public void destroy() {
		System.out.println("destroy method");
	}

}
