<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="model.data.users.Hotel" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href=index.jsp> main page </a>
	<h1> Welcome to page of Hotels </h1>
		<ul>
		<%
		ArrayList<Hotel> hotels = (ArrayList<Hotel>)request.getAttribute("hotels");
		for (int i = 0; i < hotels.size(); i++) {
		%>
		<li><a href=<%="ShowPhoto?ID="+hotels.get(i).getId()%>> <%=hotels.get(i).getName() %></a></li>
		<%} %>
		</ul>

</body>
</html>