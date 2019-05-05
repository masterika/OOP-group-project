<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.data.users.Agency" %>
<%@page import = "model.data.Trip" %>
<%@page import = "model.data.users.Hotel" %>
<%@page import = "model.data.db.StaticTripStorage" %>
<%@page import = "model.data.db.StaticStorage" %>
<%@page import = "model.data.Location" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tripis editi</title>
</head>

<%			
	Trip trip = StaticTripStorage.loadTrip(Integer.parseInt(request.getParameter("id")));
	List<Location> locations = trip.getLocations();
%>
<title><%=trip.getName()%> view</title>
</head>
<body>	
	<h1><%=trip.getName()%></h1>
	<p> price: <%=trip.getPrice()%> </p>	
	<form action="ChangeTripPriceServlet" method="post">	
		New Price : <input type="text" name="newprice"><br>
		<input type="submit" value="Change Price"><br>
		<input type="hidden" name="type" value="<%=trip.getId() %>" />		
	</form>
		<p>CREATE NEW LOCATION </p>
	<form action="AddLocationServlet" method="post">	
		New City : <input type="text" name="newcity"><br>
		New Hotel : <input type="text" name="newhot"><br>
		New period: <input type="text" name="newper"><br>
		<input type="submit" value="Add Location"><br>
		<input type="hidden" name="type" value="<%=trip.getId() %>" />
		
	</form>

	<% 					
		for (int i=0; i<locations.size(); i++) {			
			Location location = locations.get(i);
	%>
			<p> <%="Location "+(i+1) %>  </p>
				City: <%=location.getCity() %> 
				<% Hotel hotel = StaticStorage.loadHotel(location.getUserId()); %>
				Hotel: <a href=<%="ShowPhoto?ID="+hotel.getId()%>> <%=hotel.getName() %></a>				
				Period: <%=location.getDuration() %>
		
		
			<form action="ChangeLocationPeriodServlet" method="post">	
					New Period : <input type="text" name="newper"><br>
					<input type="submit" value="Change Period"><br>
					<input type="hidden" name="type" value="<%=location.getId() %>" />
					<input type="hidden" name="trip" value="<%=trip.getId() %>" />
		
				</form>
				<form action="ChangeLocationHotelServlet" method="post">	
					New Hotel : <input type="text" name="newiden"><br>
					<input type="submit" value="Change Hotel"><br>
					<input type="hidden" name="type" value="<%=location.getId() %>" />
					<input type="hidden" name="trip" value="<%=trip.getId() %>" />
				</form>
				
				<form action="LocationDeleteServlet" method="post">	
					<input type="submit" value="Delete"><br>
					<input type="hidden" name="type" value="<%=location.getId() %>" />
					<input type="hidden" name="trip" value="<%=trip.getId() %>" />
				</form>
		
		
		
		<%}%>
	
</body>




</html>