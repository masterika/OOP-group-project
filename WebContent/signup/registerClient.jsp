<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<h1>Create New Client</h1>

<form  method="post">
	<%@include file="userFields.html" %>
	<input type="text" placeholder="First Name" class="textbox" name="name"/><br/>
	<input type="text" placeholder="Last Name" class="textbox" name="surname"/><br/>
	<input type="text" placeholder="Phone" class="textbox" name="telephone"/><br/>
    <input type="submit" value="Create" class="button" name="create"/>
</form>

</body>
</html>