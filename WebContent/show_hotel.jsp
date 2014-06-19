<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.db.HotelStorage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		HotelStorage storage = new HotelStorage();
		Hotel hotel = storage.loadHotel(Integer.parseInt(request.getParameter("ID")));
		%>
		<p> Name: <%=hotel.getName()%> </p>
		<p> Phone: <%=hotel.getTelephone()%> </p>
		<p> Address: <%=hotel.getAdress()%> </p>
		<p> Stars: <%=hotel.getStars()%> </p>
		<p> Email: <%=hotel.getEmail()%> </p>
		<p> Number of rooms: <%=hotel.getRoomNum()%> </p>
		
</body>
</html>