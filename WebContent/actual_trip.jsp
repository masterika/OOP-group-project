<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%/*
	aqedan ver daiwyeb. sawyisi aris trip faili sadac gadacem locationebis raodenobas
*/
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trip Creation</title>
</head>
<body>
<h1> trip registration  </h1>
	<form action = "ActualTripServlet" method = "post">		
		Name: <input type="text" name="name"/> <br/>
		Price: <input type="text" name="price"/> <br/>
		Type: <input type="text" name="type"/> <br/>
		Start date	<input type="text" name="sDate"/> <br/>	
		End date	<input type="text" name="eDate"/> <br/>		
		<% int num = Integer.parseInt((String)request.getAttribute("N_Locations"));%>
		<input type="hidden" name="N_Locations" value=<%=num %> />
		<%
			for (int i=1; i<=num; i++) {
				%>
				<h4> <%="Location "+i %>  </h4>				
				City: <input type="text" name="<%="city"+i%>"/>
				Hotel: <input type="text" name="<%="hotel"+i%>"/>
				Period: <input type="text" name="<%="period"+i%>"/>
			<%}%>
		 <input type="submit"/>
	</form>
</body>
</html>