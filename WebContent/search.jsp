<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
    <%@page import="java.util.ArrayList" %>
    <%@page import="model.data.users.Hotel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="JS/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
		<a href=index.jsp> main page </a>

	<form action="search" method="get">

		<input type="radio" name="type" value="Hotel" checked="checked">Hotel
		<input type="radio" name="type" value="Agency">Agency <br>
		<input name="keyword" type="text"> <input value="Search"
			type="submit" id="searchBtn">

	</form>
	<br>
	<div id="list">
		<%
			if (request.getAttribute("hotels") != null) {
		%>
		<ul>
		<%
		ArrayList<Hotel> hotels = (ArrayList<Hotel>)request.getAttribute("hotels");
		for (int i = 0; i < hotels.size(); i++) {
		%>
		<li><a href=<%="ShowHotel?ID="+hotels.get(i).getId()%>> <%=hotels.get(i).getName() %></a></li>
		<%} %>
		</ul>
		<%
			}
		%>
	</div>



</body>
</html>