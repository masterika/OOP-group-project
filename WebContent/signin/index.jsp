<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign in</title>
<link rel="stylesheet" type="text/css" href="/Turista/styles/style.css">
</head>
<body>
	<%
		String failed = request.getParameter("failed");
		if (failed != null) {
	%>
	<h1>Please Try Again</h1>
	<p>Your user name or password are incorrect. Please try again</p>
	<%
		}
	%>

	<%@include file="login.html"%>
</body>
</html>