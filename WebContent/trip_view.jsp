<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "model.data.Trip" %>
<%@page import = "model.data.users.Hotel" %>
<%@page import = "model.data.db.StaticTripStorage" %>
<%@page import = "model.data.db.StaticUserIdGetterStorage" %>
<%@page import = "model.data.db.StaticStorage" %>
<%@page import = "model.data.Location" %>
<%@page import = "java.util.List" %>
<%@page import="model.data.users.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%			
	Trip trip = StaticTripStorage.loadTrip(Integer.parseInt(request.getParameter("id")));
	List<Location> locations = trip.getLocations();
%>
<title><%=trip.getName()%> view</title>
</head>
<body>
	<a href=<%="ShowAgency?ID="+trip.getUserId()%>> agency page </a>
	<h1><%=trip.getName()%></h1>
	<p> price: <%=trip.getPrice()%> </p>
	<p> trip type: <%=trip.getType()%> </p>
	<p> start date: <%=trip.getsDate()%> </p>	
	<p> end date: <%=trip.geteDate()%> </p>	
	<% 					
		for (int i=0; i<locations.size(); i++) {			
			Location location = locations.get(i);
	%>
			<p> <%="Location "+(i+1) %>  </p>
				City: <%=location.getCity() %> 
				<% Hotel hotel = StaticStorage.loadHotel(location.getUserId());// cudi arqiteqtura %>
				Hotel: <a href=<%="ShowPhoto?ID="+hotel.getId()%>> <%=hotel.getName() %></a>				
				Period: <%=location.getDuration() %>
		<%}%>
		
		<form action="WishListServlet" method="post">
			<input type="hidden" name="id" value="<%=trip.getId()%>" /> 
			<%
				int userId = ((User)request.getSession().getAttribute("user")).getId(); // es meordeba jerjerobit, gamosasworebelia		
			%> 
	 		<input type="hidden" name="userId" value="<%= userId %>" /> 
	 		<input type="hidden" name="type" value="trip" /> <%//es trip constantit minda %> 
			<input type="submit" value="Add to WishList" /> 			
		</form>
</body>
</html>	


