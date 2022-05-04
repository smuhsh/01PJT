package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
//import com.model2.mvc.service.user.dao.UserDAO;


public class UpdatePurchaseAction extends Action {
	//2022-04-15 shhwang
	//구매정보 수정 요청
	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		
		int tranNo= Integer.parseInt(request.getParameter("tranNo"));
		
		PurchaseVO purchaseVO=new PurchaseVO();
		purchaseVO.setTranNo(tranNo);
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDlvyAddr (request.getParameter("dlvyAddr"));
		purchaseVO.setDlvyRequest(request.getParameter("dlvyRequest"));
		purchaseVO.setDlvyDate(request.getParameter("dlvyDate"));
		
		System.out.println(purchaseVO);
		
		PurchaseService service=new PurchaseServiceImpl();
		service.updatePurchase(purchaseVO);
		
		request.setAttribute("purchaseVO", purchaseVO); //2022-04-15 shhwang		
		
//		return "redirect:/getPurchase.do?prodNo="+tranNo+"&menu=manage";//2022-04-07 shhwang
		return "redirect:/getPurchase.do?tranNo="+tranNo;//2022-04-07 shhwang
		
	}
}