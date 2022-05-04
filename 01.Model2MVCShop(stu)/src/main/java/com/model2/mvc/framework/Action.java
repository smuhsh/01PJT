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
	public ServletContext getServletContext() { //Action에 ServletContext 를 has a 관계로 만들었다.
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


	//execute 의 return type이 String 인건 Navigation 하려고, Business Logic 에 집중하려고.
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception ; 
}