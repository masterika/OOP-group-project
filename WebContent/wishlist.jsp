<%@page import="model.data.Wishlist"%>
<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.users.Client"%>
<%@page import="model.data.Trip"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Wishlist</title>
</head>
<body>
	<h1>Items:</h1>
	<%
		Wishlist list = ((Client) session.getAttribute("userId"))
				.getWishlist();
		ArrayList<Hotel> hotels = list.getHotels();
		ArrayList<Trip> trips = list.getTrips();
	%>
	<h2>Hotels:</h2>
	<ul>
		<%
			for (int i = 0; i < hotels.size(); i++) {
				Hotel hotel = hotels.get(i);
		%>
		<li><a href=<%="hotel.jsp?hotelId=" + hotel.getId()%>> <%=hotel.getName()%>
		</a></li>
		<%
			}
		%>
	</ul>

	<h2>Trips:</h2>
	<ul>
		<%
			for (int i = 0; i < trips.size(); i++) {
				Trip trip = trips.get(i);
		%>
		<li><a href=<%="trip.jsp?hotelId=" + trip.getId()%>> <%=trip.getName()%>
		</a></li>
		<%
			}
		%>
	</ul>
</body>
</html>