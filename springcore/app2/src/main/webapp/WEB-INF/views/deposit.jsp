<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oracle bank fund deposit</title>
</head>
<body>
<form:form action="deposit" method="post" modelAttribute="depositDto">
	Enter from account:<form:input path="accId"/><br/>
	Enter to amount to deposit:<form:input path="amount"/><br/>
	<input type ="submit"/>
</form:form>
</body>
</html>