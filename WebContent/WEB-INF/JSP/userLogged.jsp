<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Location: ${buildingId}</title>
<link media="screen" rel="stylesheet" type="text/css" href="css/main.css" />
<link media="screen" rel="stylesheet" type="text/css" href="css/iframes.css" />
</head>
<body>
<!-- 	<p> -->
<!-- 		<img src="img/logo.gif" /><br> &nbsp; -->
<!-- 	</p> -->
<%-- 	<h1>You are logged in as: ${login}</h1> --%>
<%-- 	<div>Your name is: ${name}</div> --%>
<%-- 	<div>Your Birth day is: ${bday}</div> --%>
<%-- 	<div>Your user id: ${id}</div> --%>
	<div>
	<iframe id="char" src="${pageContext.request.contextPath}/char?nickname=${login}&id=${id}&sessionID=${sessionID}"  scrolling="yes">
  		<p>Your browser does not support iframes.</p> 
	</iframe>
	</div>
	<div>x</div>
	<div>
	<iframe id="chat" src="${pageContext.request.contextPath}/chat" scrolling="yes">
	
	</iframe>
	<iframe id="room" src="${pageContext.request.contextPath}/room?nickname=${login}&buildingId=${buildingId}"  scrolling="yes">
	
	</iframe>
	</div>
	<div>
	<iframe id="buttons" src="${pageContext.request.contextPath}/buttons" scrolling="no">
	
	</iframe>
	</div>
<%-- <iframe src='<c:import url="/WEB-INF/JSP/userLogged.jsp" />'> --%>
<!--   <p>Your browser does not support iframes.</p> -->
<!-- </iframe> -->
<%-- <iframe src='<c:import url="/WEB-INF/JSP/userLogged.jsp" />'> --%>
<!--   <p>Your browser does not support iframes.</p> -->
<!-- </iframe> -->
</body>
</html>