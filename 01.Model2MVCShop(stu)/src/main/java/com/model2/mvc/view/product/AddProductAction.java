package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ProductVO productVO=new ProductVO();
		
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		//productVO.setManuDate(request.getParameter("manuDate"));
		productVO.setManuDate(request.getParameter("manuDate").replace("-",""));
		
		//searchVO.setPageUnit(Integer.parseInt(pageUnit));
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
		
		System.out.println(productVO);
		
		ProductService service=new ProductServiceImpl();
		service.addProduct(productVO);
		
		request.setAttribute("vo", productVO);
		
		return "redirect:/product/addProductView.jsp";
		//return "forward:/product/addProductView.jsp";
		//2022-03-30 shhwang
		//return "forward:/product/updateProduct.jsp";
	}
}
