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
<title>구매 내역 확인</title>
</head>
<body>

<form name="updatePurchase" action="/updatePurchaseView.do?tranNo=<%= vo.getTranNo() %>" method="post">

다음과 같이 구매가 되었습니다.

<table border=1>
	<tr>
		<td>물품번호</td>
		<td><%= vo.getPurchaseProd().getProdNo() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자아이디</td>
		<td><%= vo.getBuyer().getUserId() %></td>
		<td></td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>
		
			<%= vo.getPaymentOption() %>
		
		</td>
		<td></td>
	</tr>
	<tr>
		<td>구매자이름</td>
		<td><%= vo.getReceiverName()%></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자연락처</td>
		<td><%= vo.getReceiverPhone()%></td>
		<td></td>
	</tr>
	<tr>
		<td>구매자주소</td>
		<td><%= vo.getDlvyAddr() %></td>
		<td></td>
	</tr>
		<tr>
		<td>구매요청사항</td>
		<td><%= vo.getDlvyRequest() %></td>
		<td></td>
	</tr>
	<tr>
		<td>배송희망일자</td>
		<td><%= vo.getDlvyDate()%></td>
		<td></td>
	</tr>
</table>
</form>


</body>
</html>