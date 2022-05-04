package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.dao.UserDAO;


public class UpdateProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int prodNo= Integer.parseInt(request.getParameter("prodNo"));
		String menu = request.getParameter("menu");
		
		ProductVO productVO=new ProductVO();
		productVO.setProdNo(prodNo);
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setPrice (Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);
		
		request.setAttribute("productVO", productVO); //2022-03-31 shhwang		
		
//		HttpSession session=request.getSession();
//		String sessionId=((ProductVO)session.getAttribute("product")).getProdName(); 2022-03-31 login 필요 session 정보

//		if(sessionId.equals(prodName)){
//			session.setAttribute("prodct", productVO);
//		}
		
		//return "redirect:/getProduct.do?prodNo="+prodNo+"&menu=search";//2022-04-02 shhwang
		//return "redirect:/getProduct.do?prodNo="+prodNo+"&menu=";//2022-04-02 shhwang		
		//return "redirect:/getProduct.do?prodNo="+prodNo;//2022-04-07 shhwang
		//return "redirect:/getProduct.do?prodNo="+prodNo+"&menu=manage";//2022-04-07 shhwang
		return "redirect:/getProduct.do?prodNo="+prodNo+"&menu=search";//2022-04-14 shhwang
		
	}
}