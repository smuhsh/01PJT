package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class GetPurchaseAction extends Action{

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {

		int tranNo= Integer.parseInt(request.getParameter("tranNo"));
		
		//String menu= request.getParameter("menu");//2022-03-31 shhwang
		
		
		PurchaseService service = new PurchaseServiceImpl();
		PurchaseVO vo=service.findPurchase(tranNo);
		
		request.setAttribute("vo", vo);

		return "forward:/purchase/getPurchaseView.jsp";//2022-04-14 shhwang
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