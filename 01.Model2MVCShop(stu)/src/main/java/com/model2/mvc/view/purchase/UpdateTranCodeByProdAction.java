package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class UpdateTranCodeByProdAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int prodNo = 0;
		int tranNo = 0;
		String tranCode = request.getParameter("tranCode");
		
		PurchaseService service=new PurchaseServiceImpl();
		
		if (tranCode.equals("002")){
			prodNo= Integer.parseInt(request.getParameter("prodNo"));
			tranNo = service.getSaleList(prodNo);
		}
		else if (tranCode.equals("003")){
			tranNo= Integer.parseInt(request.getParameter("tranNo"));
		}
		
		PurchaseVO purchaseVO=new PurchaseVO();
		purchaseVO.setTranNo(tranNo);
		purchaseVO.setTranCode(tranCode);
		
		service.updateTranCode(purchaseVO);
		
		if(request.getParameter("listType").equals("sale")){
			return "redirect: /listSale.do";
		}
		else if(request.getParameter("listType").equals("purchase")){
			return "redirect: /listPurchase.do";
		}
		else {
			return "error";
		}
	}
}