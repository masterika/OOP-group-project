<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "model.data.db.StaticTripStorage" %>
    <%@page import = "model.data.Trip" %>
    <%@page import="java.util.List" %>
    <%@page import = "model.data.users.Agency" %>
       <%@page import = "model.data.users.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>trips:</title>
</head>
<body>
<ul>
		<%
			User user = (User)request.getSession().getAttribute("user");		
			
			List<Trip> trips = StaticTripStorage.loadTrips(user.getId());
			System.out.println(trips.size());
			for (int i = 0; i < trips.size(); i++) {
				Trip trip = trips.get(i);	
				%>				
		<li><a href=<%="trip_edit.jsp?id="+trip.getId()%>> <%=trip.getName() %> </a></li>
		 
				
				<form action="TripDeleteServlet" method="post">	
					<input type="submit" value="Delete"><br>
					<input type="hidden" name="type" value="<%=trip.getId() %>" />
				</form>
		
		
		
		<%} %>
		</ul>
	<a href="trip.jsp"> create new trip</a>
</body>
</html>