<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trip Registration</title>
</head>
<body>
	<h1> trip registration  </h1>
	<form action="TripServlet" method="post">			
		Number of locations: <input type="text" name="number"/> <br> 
		<input type="hidden" name="id" value="<%=request.getParameter("id") %>" /> 
	    <input type="submit"/>
	</form>
</body>
</html>