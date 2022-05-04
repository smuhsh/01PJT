package com.model2.mvc.framework;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Action {
	
	//Field
	private ServletContext servletContext;
	
	//Constructor
	public Action(){
	}
	
	//Method
	public ServletContext getServletContext() { //Action�� ServletContext �� has a ����� �������.
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	//2022-03-24 shhwang
	@Override
	public String toString() {
		return "Action [servletContext=" + servletContext + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	//execute �� return type�� String �ΰ� Navigation �Ϸ���, Business Logic �� �����Ϸ���.
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception ; 
}