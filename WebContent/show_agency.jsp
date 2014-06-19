<%@page import="model.data.users.Agency"%>
<%@page import="model.data.db.AgencyStorage"%>
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
		AgencyStorage storage = new AgencyStorage();
        Agency agency = storage.loadAgency(Integer.parseInt(request.getParameter("ID")));
		%>
		<p> Name: <%=agency.getName()%> </p>
		<p> Phone: <%=agency.getTelephone()%> </p>
		<p> Adress: <%=agency.getAdress()%> </p>
		<p> Email: <%=agency.getEmail()%> </p>
	
</body>
</html>