<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<link media="screen" rel="stylesheet" type="text/css" href="css/main.css" />
<link media="screen" rel="stylesheet" type="text/css" href="css/iframes.css" />
</head>
<body>
	<center>
		<form ACTION="${pageContext.request.contextPath}/login" method="post">
			<p>
				<img src="img/logo.gif" /><br> &nbsp;
			</p>
			<TABLE width=200 cellSpacing=5 cellPadding=0 border=0
				style="border-style: dashed; border-width: 1px" bgcolor="#FFE5B6">

				<tr>
					<td><input type="text" name="login" placeholder="username" />
					</td>
				</tr>
				<tr>
					<td><input type="password" name="password" placeholder="password" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="submit"></td>
				</tr>
				<tr>
					<td style="PADDING-BOTTOM: 10px" width="99%"><a
						href="${pageContext.request.contextPath}/newuser">Registration</a>
					</td>
					<td style="PADDING-BOTTOM: 10px" width="99%">
					<a href="${pageContext.request.contextPath}/fight">Test Battle</a>
					</td>
				</tr>
			</TABLE>
		</form>
	</center>
</body>
</html>
