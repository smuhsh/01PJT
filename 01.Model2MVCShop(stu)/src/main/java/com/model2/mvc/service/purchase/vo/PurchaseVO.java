package com.model2.mvc.service.purchase.vo;

import java.sql.Date;

import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;


public class PurchaseVO {
	
//	private UserVO buyer; //구매자 아이디
//	private String divyAddr; //배송주소
//	private String divyDate; // 배송희망일
//	private String divyRequest; //배송요청사항
//	private Date orderDate; //주문일시
//	private String paymentOption; //결제 방법
//	private ProductVO purchaseProd; //상품번호
//	private String receiverName; //수령자 이름
//	private String receiverPhone; //수령자 전화번호
//	private String tranCode; // 배송상태코드
//	private int tranNo; //주문번호

	//2022-04-11 shhwang 보기편하게 테이블 순서랑 똑같이 맞춤
	private int tranNo; //주문번호
	private ProductVO purchaseProd; //상품번호
	private UserVO buyer; //구매자 아이디
	private String paymentOption; //결제 방법
	private String receiverName; //수령자 이름
	private String receiverPhone; //수령자 전화번호
	private String dlvyAddr; //배송주소
	private String dlvyRequest; //배송요청사항
	private String tranCode; // 배송상태코드
	private Date orderDate; //주문일시
	private String dlvyDate; // 배송희망일

	public PurchaseVO(){
	}
	
	public UserVO getBuyer() {
		return buyer;
	}
	public void setBuyer(UserVO buyer) {
		this.buyer = buyer;
	}
	public String getDlvyAddr() {
		return dlvyAddr;
	}
	public void setDlvyAddr(String dlvyAddr) {
		this.dlvyAddr = dlvyAddr;
	}
	public String getDlvyDate() {
		return dlvyDate;
	}
	public void setDlvyDate(String dlvyDate) {
		this.dlvyDate = dlvyDate;
	}
	public String getDlvyRequest() {
		return dlvyRequest;
	}
	public void setDlvyRequest(String dlvyRequest) {
		this.dlvyRequest = dlvyRequest;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public ProductVO getPurchaseProd() {
		return purchaseProd;
	}
	public void setPurchaseProd(ProductVO purchaseProd) {
		this.purchaseProd = purchaseProd;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getTranCode() {
		return tranCode;
	}
	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}
	public int getTranNo() {
		return tranNo;
	}
	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}
	
	@Override
	public String toString() {
		return "PurchaseVO [buyer=" + buyer + ", dlvyAddr=" + dlvyAddr
				+ ", dlvyDate=" + dlvyDate + ", dlvyRequest=" + dlvyRequest
				+ ", orderDate=" + orderDate + ", paymentOption="
				+ paymentOption + ", purchaseProd=" + purchaseProd
				+ ", receiverName=" + receiverName + ", receiverPhone="
				+ receiverPhone + ", tranCode=" + tranCode + ", tranNo="
				+ tranNo + "]";
	}
}