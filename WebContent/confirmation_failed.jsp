<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>confirmation failed</title>

</head>
<body>
	<h1>Confirmation of new password failed</h1>
	<h2>Please try again</h2>
	<p>
	<form action="ChangeUserPasswordServlet" method="post">
		Previous password: <input type="password" name="prevpass"><br>
		New Password: <input type="password" name="newpass"><br>
		Confirm Password: <input type="password" name="confnewpass"><br>

		<input type="submit" value="Change Password">
	</form>

</body>
</html>