<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<h1>Create New Agency</h1>

<form action="CreateAgency" method="post">
    UserName: <input type="text" name="username"/> <br/>
    Email: <input type="text" name="email"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    AgencyName: <input type="text" name="name"/> <br/>
    AgencyAdress: <input type="text" name="adress"/> <br/>
   	Telephone: <input type="text" name="telephone"/> <br/>
    <input type="submit" value="Create" name="create"/>
</form>

</body>
</html>