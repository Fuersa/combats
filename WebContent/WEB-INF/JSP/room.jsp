<%@ page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>

<body bgcolor="#E1FDE2">
	<center>
		<b>${roomName}(</b>${count}<b>)</b>
	</center>
	<c:forEach var="entry" items="${myMap}">
  ==> <c:out value="${entry.key}" /> [<c:out value="${entry.value}" />]</br>
	</c:forEach>
</body>
</html>