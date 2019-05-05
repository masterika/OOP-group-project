<%@page import="model.data.WishProduct"%>
<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.users.Client"%>
<%@page import="model.data.Trip"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.data.db.StaticWishlistStorage"%>
<%@page import="model.data.db.StaticStorage"%>
<%@page import="model.data.db.StaticTripStorage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Wishlist</title>
</head>
<body>
	<h1>Products:</h1>
	<%	
		int userId = Integer.parseInt(request.getParameter("id"));	
		List<WishProduct> hotelIds = StaticWishlistStorage.loadProductList(userId, "hotel"); 
		List<WishProduct> tripIds = StaticWishlistStorage.loadProductList(userId, "trip"); 	
	%>
	<h2>Hotels:</h2>
	<ul>
		<%
			for (int i = 0; i < hotelIds.size(); i++) {
				Hotel hotel = StaticStorage.loadHotel(hotelIds.get(i).getObjectId());
		%>
		<li><a href=<%="ShowHotel?ID=" + hotel.getId()%>> <%=hotel.getName()%>
		</a></li>
		
				<form action="WishItemDeleteServlet" method="post">	
					<input type="submit" value="Delete"><br>
					<input type="hidden" name="id" value="<%=hotel.getId() %>" />
					<input type="hidden" name="type" value="hotel" />
				</form>
		<%
			}
		%>
	</ul>

	<h2>Trips:</h2>
	<ul>
		<%
			for (int i = 0; i < tripIds.size(); i++) {
				Trip trip = StaticTripStorage.loadTrip(tripIds.get(i).getObjectId()); 
		%>
		<li><a href=<%="trip_view.jsp?id=" + trip.getId()%>> <%=trip.getName()%>
		</a></li>
			<form action="WishItemDeleteServlet" method="post">	
					<input type="submit" value="Delete"><br>
					<input type="hidden" name="id" value="<%=trip.getId() %>" />
					<input type="hidden" name="type" value="trip" />
			</form>
		<%
			}
		%>
	</ul>
</body>
</html>