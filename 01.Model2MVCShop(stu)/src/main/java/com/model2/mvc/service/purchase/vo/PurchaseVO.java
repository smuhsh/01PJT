package com.model2.mvc.service.purchase.vo;

import java.sql.Date;

import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;


public class PurchaseVO {
	
//	private UserVO buyer; //������ ���̵�
//	private String divyAddr; //����ּ�
//	private String divyDate; // ��������
//	private String divyRequest; //��ۿ�û����
//	private Date orderDate; //�ֹ��Ͻ�
//	private String paymentOption; //���� ���
//	private ProductVO purchaseProd; //��ǰ��ȣ
//	private String receiverName; //������ �̸�
//	private String receiverPhone; //������ ��ȭ��ȣ
//	private String tranCode; // ��ۻ����ڵ�
//	private int tranNo; //�ֹ���ȣ

	//2022-04-11 shhwang �������ϰ� ���̺� ������ �Ȱ��� ����
	private int tranNo; //�ֹ���ȣ
	private ProductVO purchaseProd; //��ǰ��ȣ
	private UserVO buyer; //������ ���̵�
	private String paymentOption; //���� ���
	private String receiverName; //������ �̸�
	private String receiverPhone; //������ ��ȭ��ȣ
	private String dlvyAddr; //����ּ�
	private String dlvyRequest; //��ۿ�û����
	private String tranCode; // ��ۻ����ڵ�
	private Date orderDate; //�ֹ��Ͻ�
	private String dlvyDate; // ��������

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