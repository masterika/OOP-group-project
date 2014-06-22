<%@page import="model.data.db.StaticStorage"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.data.users.Agency"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> view</title>
</head>
<body>
	<div id="content">
	
		<a href=index.jsp> main page </a>
		<%
		Agency agency = StaticStorage.loadAgency(Integer.parseInt(request.getParameter("ID")));
		%>
		<p> Name: <%=agency.getName()%> </p>
		<p> Phone: <%=agency.getTelephone()%> </p>
		<p> Address: <%=agency.getAdress()%> </p>
		<p> Email: <%=agency.getEmail()%> </p>
	</div>

</body>
</html>