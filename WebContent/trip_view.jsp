<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.data.db.TripStorage" %>
<%@page import = "model.data.Trip" %>
<%@page import = "model.data.Location" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%/*
	amit vtestav TripStorages loadTrips.
	dasaweria comentarebi, reitingi, linki agencyze,dajavshna da listshi chamateba.
	exla ar tqva aba shen ra dawereo, aqedan titqmis arcerti feature ar gvaq da aq rogor damewera
*/
%>
<%	
	int id = 1; // shesacvlelia, romel gverdsac unda amis view imis requestisgan unda amovigot parametrad id
	TripStorage storage = new TripStorage(id); //testireba!
	Trip trip = storage.loadTrip(id);
	List<Location> locations = trip.getLocations();
%>
<title><%=trip.getName()%> view</title>
</head>
<body>
	<h1><%=trip.getName()%></h1>
	<p> price: <%=trip.getPrice()%> </p>
	<p> trip type: <%=trip.getType()%> </p>	
	<% 					
		for (int i=0; i<locations.size(); i++) {
			Location location = locations.get(i);
	%>
			<p> <%="Location "+(i+1) %>  </p>
				City: <%=location.getCity() %> 
				Hotel: <%=location.getHotel()%> 
				Period: <%=location.getDuration() %>
		<%}%>
</body>
</html>