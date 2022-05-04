package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.dao.UserDAO;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class AddPurchaseAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {						
//		PurchaseVO purchaseVO=new PurchaseVO();
//		
//		UserService userService=new UserServiceImpl();
//		UserVO buyer=userService.getUser(request.getParameter("buyerId"));
//
//		ProductService productService=new ProductServiceImpl();
//		ProductVO purchaseProd=productService.findProduct(Integer.parseInt(request.getParameter("prodNo")));
//		
//		System.out.println(purchaseProd);
//		System.out.println(buyer);
//		
//		purchaseVO.setPurchaseProd(purchaseProd);
//		purchaseVO.setBuyer(buyer);
//		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
//		purchaseVO.setReceiverName(request.getParameter("receiverName"));
//		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
//		purchaseVO.setDlvyAddr(request.getParameter("receiverAddr"));
//		purchaseVO.setDlvyRequest(request.getParameter("receiverRequest"));
//		purchaseVO.setDlvyDate(request.getParameter("receiverDate"));
//		purchaseVO.setTranCode("001");
//		System.out.println(purchaseVO);
//		
//		PurchaseService service=new PurchaseServiceImpl();
//		service.addPurchase(purchaseVO);
//		
//		request.setAttribute("purchaseVO", purchaseVO);
//		
//		//2022-04-13 shhwang
//		return "forward:/purchase/addPurchase.jsp";
//		
//		//return "forward:/product/addProductView.jsp";
//		//2022-03-30 shhwang
//		//return "forward:/product/updateProduct.jsp";
		
				
		System.out.println(new ProductDAO().findProduct(Integer.parseInt(request.getParameter("prodNo"))));
		
		PurchaseVO purchaseVO = new PurchaseVO();
		
		purchaseVO.setPurchaseProd(new ProductDAO().findProduct(Integer.parseInt(request.getParameter("prodNo"))));
		purchaseVO.setBuyer(new UserDAO().findUser(request.getParameter("buyerId")));
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDlvyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDlvyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setDlvyDate(request.getParameter("receiverDate"));
		purchaseVO.setTranCode("001");

		System.out.println(purchaseVO.getPurchaseProd().getProdNo());
		System.out.println(purchaseVO);
			
		PurchaseService service = new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		request.setAttribute("purchase", purchaseVO);
		
		return "forward:/purchase/addPurchase.jsp";
		//return "forward:/purchase/addPurchaseResult.jsp";
			
		
		
	}
}
