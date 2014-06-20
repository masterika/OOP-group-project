<%@page import="model.data.db.StaticStorage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Failed</title>
</head>
<body>
<h1>Please Try Again</h1>

<p>account creation failed</p>
<%=StaticStorage.isValidIdentificator(232) %>
</body>
</html>