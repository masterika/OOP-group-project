<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.data.users.Agency"%>
<%!int id;%>
<%!String name;%>
<%
	Agency user = (Agency) request.getSession().getAttribute("agency");
	if (user != null) {
		id = user.getId();
		name = user.getUsername();
	} else {
		id = -1;
		name = "";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=name%></title>
</head>
<body>
	<h1>
		Welcome
		<%=name%></h1>
	<a href=<%="edit_profile_agency.jsp?id=" + id%>> edit profile</a>
	<%@include file="logout.html"%>
</body>
</html>