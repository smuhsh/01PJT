<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="com.model2.mvc.service.purchase.vo.*" %>

<%
	PurchaseVO vo = (PurchaseVO) request.getAttribute("purchase");
	System.out.println(vo.getPurchaseProd());
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� Ȯ��</title>
</head>
<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=<%= vo.getTranNo() %>" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.

<table border=1>
	<tr>
		<td>��ǰ��ȣ</td>
		<td><%= vo.getPurchaseProd().getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td>
		<td><%= vo.getBuyer().getUserId() %></td>
		<td></td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>
		
			<%= vo.getPaymentOption() %>
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>�������̸�</td>
		<td><%= vo.getReceiverName()%></td>
		<td></td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td>
		<td><%= vo.getReceiverPhone()%></td>
		<td></td>
	</tr>
	<tr>
		<td>�������ּ�</td>
		<td><%= vo.getDlvyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>���ſ�û����</td>
		<td><%= vo.getDlvyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>����������</td>
		<td><%= vo.getDlvyDate()%></td>
		<td></td>
	</tr>
</table>
</form>


</body>
</html>