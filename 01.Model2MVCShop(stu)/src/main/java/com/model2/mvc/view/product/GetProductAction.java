package com.model2.mvc.view.product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class GetProductAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {

		int prodNo= Integer.parseInt(request.getParameter("prodNo"));
		
		String menu= request.getParameter("menu");//2022-03-31 shhwang
		
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo=service.findProduct(prodNo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("menu", menu);

		//return "forward:/product/getProduct.jsp";
		//return "forward:/product/updateProduct.jsp";//2022-03-30 shhwnag
		//return "forward:/product/readProduct.jsp";//2022-03-30 shhwang
		//return "forward:/product/readProduct.jsp";//2022-03-31 shhwang
		
		/*
		if(menu.equals("search")){
			return "forward:/product/getProduct.jsp";//2022-03-31 shhwang
		}else if(menu.equals("manage") && vo == service.getProduct(prodName)) {			
			   //return "forward:/product/updateProduct.jsp";
			   return "redirect:/updateProductView.do?prodName="+prodName;
		}else {
			return "forward:/product/getProduct.jsp";//2022-03-31 shhwang
		}*/	 
		//return "forward:/product/getProduct.jsp";//2022-03-31 shhwang
		
		
		response.addCookie(new Cookie("history"+prodNo, prodNo+""));
		
		return "forward:/product/readProduct.jsp";//2022-04-02 shhwang
		
		//2022-04-14 shhwang
//		if(menu.equals("manage")) {
//			return "forward:/updateProductView.do?prodNo="+prodNo+"&menu=manage";
//		} 
//		else if (menu.equals("search")) {
//			return "forward:/product/readProduct.jsp";
//		}
//		else {
//			return "error";
//		}
		
//		if(menu.equals("search")){
//			return "forward:/product/getProduct.jsp";
//		}else if(menu.equals("manage") && vo == service.findProduct(prodNo)) {
//			   return "forward:/product/readProduct.jsp";
//		}else {
//			return "forward:/product/readProduct.jsp";//2022-03-31 shhwang
//		}
		
//		if(menu.equals("search")){
//			return "forward:/product/getProduct.jsp";
//		}else if(menu.equals("manage") && vo == service.findProduct(prodNo)) {
//			return "forward:/product/readProduct.jsp";
//		}
//		else {
//			return "error";
//		}
		
	}
}