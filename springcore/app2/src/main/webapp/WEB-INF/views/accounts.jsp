<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oracle bank application</title>
</head>

<body>
	<table border="2">
		<thead>
			<tr>
				<th>account Id</th>
				<th>Name</th>
				<th>Balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="account" items="${accountList}">
				<tr>
					<td>${account.id }</td>
					<td>${account.name }</td>
					<td>${account.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="transfer">transfer request</a><br/>
	<a href="deposit">deposit request</a><br/>
	<a href="withdraw">withdraw request</a><br/>
</body>
</html>