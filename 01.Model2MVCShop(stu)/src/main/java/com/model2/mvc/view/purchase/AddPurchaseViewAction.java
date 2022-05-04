package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;


public class AddPurchaseViewAction extends Action{

	//2022-04-13 shhwang
	//구매를 위한 상품요청으로 ProductVO prodNo를 조회하기 위해 findProduct 호출
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
//		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
//		
//		ProductService productService = new ProductServiceImpl();
//		ProductVO productVO = productService.findProduct(prodNo);
//		
//		//2022-04-13 shhwang
//		//고유한 client 마다 session 생성 후 request 요청
//		
//		HttpSession httpSession = request.getSession();
//		//session userId 생성
//		String userId=((UserVO)httpSession.getAttribute("userId")).getUserId();
//		
//		UserService userService = new UserServiceImpl();
//		UserVO userVO = userService.getUser(userId);		
//		
//		request.setAttribute("userVO", productVO);
//		request.setAttribute("productVO", productVO);		
//		System.out.println(userVO);
//		System.out.println(productVO);

		//2022-04-14 shhwang
		// session 은 나중에하자 일단 prodNo 로 구매하려는 상품을 가져와야한다.
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService productService = new ProductServiceImpl();
		ProductVO productVO = productService.findProduct(prodNo);
		
		request.setAttribute("productVO", productVO);
		System.out.println(productVO);

		return "forward:/purchase/addPurchaseView.jsp";
	}
}
