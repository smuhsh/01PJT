package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;


public class PurchaseServiceImpl implements PurchaseService{
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		purchaseDAO = new PurchaseDAO();
	}
	
	@Override	
	public PurchaseVO addPurchase(PurchaseVO purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		purchaseDAO.insertPurchase(purchaseVO);
		return purchaseVO;
	}
	
	public PurchaseVO findPurchase(int prodNo) throws Exception {
		return purchaseDAO.findPurchase(prodNo);
	}
	
	@Override	
	public HashMap<String,Object> getPurchaseList(SearchVO searchVO, String userId) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchaseList(searchVO, userId);
	}
	
	public PurchaseVO updatePurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.updatePurchase(purchaseVO);
		return purchaseVO;
	}
	
	@Override
	public int getSaleList(int prodNo) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDAO.getSaleList(prodNo);
	}
	
	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		purchaseDAO.updateTranCode(purchaseVO);	
	}

}