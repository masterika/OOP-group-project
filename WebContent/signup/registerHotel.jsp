<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New Hotel</title>
</head>
<body>

<h1>Create New Hotel</h1>

<form  method="post">
    <%@include file="userFields.html" %>
    <%@include file="sellersFields.html" %>
    <input type="text" placeholder="Number of rooms" class="textbox" name="rooms_num"/><br/>
    <input type="text" placeholder="Stars" class="textbox" name="stars"/><br/>
    <input type="submit" value="Create" class="button" name="create"/>
</form>

</body>
</html>