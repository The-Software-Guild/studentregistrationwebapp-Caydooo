<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.softra.model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
</head>
<body>
	<c:set var="name" scope="application" value="${requestScope.student.getName()}"></c:set>
	<c:set var="age" scope="application" value="${requestScope.student.getAge()}"></c:set>
	<c:set var="mobile" scope="application" value="${requestScope.student.getMobileNo()}"></c:set>
	<c:set var="address" scope="application" value="${requestScope.student.getAddress()}"></c:set>
	
	Registered Successfully!!!<br/>
	Your details are:<br/>
	Name: <c:out value="${applicationScope.name}"></c:out><br/>
	Age: <c:out value="${applicationScope.age}"></c:out><br/>
	Mobile Number: <c:out value="${applicationScope.mobile}"></c:out><br/>
	Address: <c:out value="${applicationScope.address}"></c:out><br/>
</body>
</html>