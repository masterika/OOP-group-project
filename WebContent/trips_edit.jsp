<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "model.data.db.StaticTripStorage" %>
    <%@page import = "model.data.Trip" %>
    <%@page import="java.util.List" %>
    <%@page import = "model.data.users.Agency" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>trips:</title>
</head>
<body>
<ul>
		<%
			Agency agency = (Agency)request.getSession().getAttribute("agency");
			List<Trip> trips = StaticTripStorage.loadTrips(agency.getAgencyId());
			System.out.println(agency.getAgencyId());
			System.out.println(trips.size());
			for (int i = 0; i < trips.size(); i++) {
				Trip trip = trips.get(i);	
				%>				
		<li><a href=<%="trip_edit.jsp?id="+trip.getId()%>> Edit trip </a></li>
		<%} %>
		</ul>
	<a href="trip.jsp"> create new trip</a>
</body>
</html>