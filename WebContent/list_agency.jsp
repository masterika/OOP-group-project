<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="model.data.users.Agency" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Welcome to page of Agencies </h1>
	<ul>
	<%
	ArrayList<Agency> agency = (ArrayList<Agency>)request.getAttribute("agencies");
	for (int i = 0; i < agency.size(); i++) {
	%>
	<li><a href=<%="ShowAgency?ID="+agency.get(i).getId()%>> <%=agency.get(i).getName() %></a></li>
	<%} %>
	</ul>
</body>
</html>