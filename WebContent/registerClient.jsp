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
    UserName: <input type="text" name="username"/> <br/>
    Email: <input type="text" name="email"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    Name: <input type="text" name="name"/> <br/>
    SurName: <input type="text" name="surname"/> <br/>
   	Telephone: <input type="text" name="telephone"/> 
    <input type="submit" value="Create" name="create"/>
</form>

</body>
</html>