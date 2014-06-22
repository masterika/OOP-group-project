<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%		
	System.out.print(request.getAttribute("tripId"));
	Trip trip = StaticTripStorage.loadTrip((Integer)request.getAttribute("tripId"));
	List<Location> locations = trip.getLocations();
%>
<title><%=trip.getName()%> view</title>
</head>
<body>
	<a href=<%="trip_edit.jsp?id="+trip.getAgencyId()%>> agency page </a>
	<h1><%=trip.getName()%></h1>
	<p> price: <%=trip.getPrice()%> </p>
	<p> trip type: <%=trip.getType()%> </p>	
	<% 					
		for (int i=0; i<locations.size(); i++) {
			Location location = locations.get(i);
	%>
			<p> <%="Location "+(i+1) %>  </p>
				City: <%=location.getCity() %> 
				<% Hotel hotel = StaticTripStorage.loadHotel(location.getHotelId());// cudi arqiteqtura %>
				Hotel: <a href=<%="ShowPhoto?ID="+hotel.getId()%>> <%=hotel.getName() %></a>				
				Period: <%=location.getDuration() %>
		<%}%>
</body>
</html>