<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
<link rel="stylesheet" type="text/css" href="/Turista/styles/inputStyles.css">

</head>
<body>

<div class="module">
<p> Please Enter User Name and Password</p>

<form action="../LoginServlet" method="post">
	<input type="text" placeholder="Username" class="textbox" name="username"/><br/>
	<input type="password" placeholder="Password" class="textbox" name="password"/><br/> 
    <input type="submit" value="Login" name="login"/>
</form>

</div>
</body>
</html>