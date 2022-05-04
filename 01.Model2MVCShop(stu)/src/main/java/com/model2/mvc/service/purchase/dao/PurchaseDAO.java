package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;

import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class PurchaseDAO {
	
	//2022-04-12 shhwang 
	//ȸ���� ��ǰ�� ������ tranNo�ֹ���ȣ,  purchaseProd��ǰ��ȣ �� ��ġ�ϴ��� Ȯ������ �ʿ�
	ProductService productService = new ProductServiceImpl();
	UserService userService = new UserServiceImpl();
	
	public PurchaseDAO(){
		
	}

	public void insertPurchase(PurchaseVO purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "INSERT INTO transaction VALUES (seq_transaction_tran_no.nextval,?,?,?,?,?,?,?,?,sysdate,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, purchaseVO.getPurchaseProd().getProdNo());
		stmt.setString(2, purchaseVO.getBuyer().getUserId());
		stmt.setString(3, purchaseVO.getPaymentOption());
		stmt.setString(4, purchaseVO.getReceiverName());
		stmt.setString(5, purchaseVO.getReceiverPhone());
		stmt.setString(6, purchaseVO.getDlvyAddr());
		stmt.setString(7, purchaseVO.getDlvyRequest());
		stmt.setString(8, purchaseVO.getTranCode());
		stmt.setString(9, purchaseVO.getDlvyDate());
//		stmt.setInt(1, purchaseVO.getPurchaseProd().getProdNo());
//		stmt.setString(2, purchaseVO.getBuyer().getUserId());
//		stmt.setString(3, purchaseVO.getManuDate().replace("-","")); // -�� �������� ġȯ
//		stmt.setInt(4, purchaseVO.getPrice()); 
//		stmt.setString(5, purchaseVO.getFileName());
		
		stmt.executeUpdate();
		
		con.close();
	}
	//2022-04-12 shhwang 
	//�������� �� ��ȸ�� ���� DBMS �� �����Ѵ�.
	public PurchaseVO findPurchase(int tranNo) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "SELECT * FROM transaction WHERE tran_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, tranNo);

		ResultSet rs = stmt.executeQuery();
		
		PurchaseVO purchaseVO = null;
		while (rs.next()) {
			purchaseVO = new PurchaseVO();
			purchaseVO.setTranNo(tranNo);
			purchaseVO.setPurchaseProd(productService.findProduct(Integer.parseInt(rs.getString("prod_no"))));
			purchaseVO.setBuyer(userService.getUser(rs.getString("buyer_id")));
			purchaseVO.setPaymentOption(rs.getString("payment_option"));
			purchaseVO.setReceiverName(rs.getString("receiver_name"));
			purchaseVO.setReceiverPhone(rs.getString("receiver_phone"));
			purchaseVO.setDlvyAddr(rs.getString("demailaddr"));
			purchaseVO.setDlvyRequest(rs.getString("dlvy_request"));
			purchaseVO.setTranCode(rs.getString("tran_status_code"));
			purchaseVO.setOrderDate(rs.getDate("order_data"));
			purchaseVO.setDlvyDate(rs.getString("dlvy_date"));
		}
		
		con.close();

		return purchaseVO;
	}
	
	//2022-04-12 shhwang 
	//�ǸŸ�� ���⸦ ���� DBMS �� �����Ѵ�.
	public int getSaleList(int prodNo) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "SELECT tran_no FROM product p, transaction t\n"
				+ "WHERE p.prod_no = t.prod_no AND p.prod_no=?";
					
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, prodNo);
		
		ResultSet rs = stmt.executeQuery();
		int tranNo = 0;
		
		if(rs.next()) {
		tranNo = rs.getInt("tran_no");
		}
		
		con.close();

		return tranNo;
	}
	//2022-04-12 shhwnag
	//���Ÿ�� ���⸦ ���� DBMS �� �����Ѵ�.
	public HashMap<String,Object> getPurchaseList(SearchVO searchVO, String userId) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
//		String sql = "select * from PRODUCT ";
//		if (searchVO.getSearchCondition() != null) {
//			if (searchVO.getSearchCondition().equals("0")) {
//				sql += " where  PROD_NO='" + searchVO.getSearchKeyword()
//						+ "'";
//			} else if (searchVO.getSearchCondition().equals("1")) {
//				sql += " where PROD_NAME='" + searchVO.getSearchKeyword()
//						+ "'";
//			}
//		}
		//2022-04-12 shhwang ȸ����ȣ�� ������ ���̵�� �������� Ȯ���Ѵ�. 
//		String sql = "SELECT * FROM transaction t\n"
//				+"(SELECT user_id FROM users u)"
//				+"WHERE t.buyer_id = u.user_id AND t.buyer_id = '"+userId+"'"	
//			    +"ORDER BY  u.user_id";
//		String sql = "SELECT * FROM transaction t\n"
//				+"(SELECT u.user_id FROM users )u"
//				+"WHERE t.buyer_id = u.user_id AND t.buyer_id = '"+userId+"'"	
//				+"ORDER BY  user_id";
		String sql = "SELECT * FROM transaction \n"
				+"WHERE buyer_id = '"+userId+"'";	 	
		
		
		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		System.out.println("�ο��� ��:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<PurchaseVO> list = new ArrayList<PurchaseVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				PurchaseVO vo = new PurchaseVO();
				vo.setTranNo(rs.getInt("tran_no"));
				vo.setPurchaseProd(productService.findProduct(Integer.parseInt(rs.getString("prod_no"))));
				vo.setBuyer(userService.getUser(rs.getString("buyer_id")));
				vo.setPaymentOption(rs.getString("payment_option"));
				vo.setReceiverName(rs.getString("receiver_name"));
				vo.setReceiverPhone(rs.getString("receiver_phone"));
				vo.setDlvyAddr(rs.getString("demailaddr"));
				vo.setDlvyRequest(rs.getString("dlvy_request"));
				vo.setTranCode(rs.getString("tran_status_code"));
				vo.setOrderDate(rs.getDate("order_data"));
				vo.setDlvyDate(rs.getString("dlvy_date"));

				list.add(vo);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}

	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		
		Connection con = DBUtil.getConnection();

		String sql = "UPDATE transaction SET payment_option=?,"
					+"receiver_name=?, receiver_phone=?, demailaddr=?, dlvy_request=?, dlvy_date=?"
					+ "WHERE tran_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, purchaseVO.getPaymentOption());
		stmt.setString(2, purchaseVO.getReceiverName());
		stmt.setString(3, purchaseVO.getReceiverPhone());
		stmt.setString(4, purchaseVO.getDlvyAddr());
		stmt.setString(5, purchaseVO.getDlvyRequest());
		stmt.setString(6, purchaseVO.getDlvyDate());
		stmt.setInt(7, purchaseVO.getTranNo());
		
		stmt.executeUpdate();
		
		con.close();
	}
	//2022-04-12 shhwang
	//���Ż��� �ڵ� ������ ���� DBMS �� �����Ѵ�.
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception{
		
		Connection con = DBUtil.getConnection();

		String sql = "UPDATE transaction SET tran_status_code=? WHERE tran_no=?";
		
		//System.out.println(purchaseVO);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, purchaseVO.getTranCode());
		stmt.setInt(2, purchaseVO.getTranNo());
		
		stmt.executeUpdate();
		
		con.close();
	}


}