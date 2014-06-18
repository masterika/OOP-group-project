<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit hotel profile</title>
</head>
<body>
	<form action="" method="post">
		Old password: <input type="password" name="oldPassword"><br> 
		New Password: <input type="password" name="newPassword"><br>
		Confirm Password: <input type="password" name="newPassword"><br>
		Email: <input type="text" name="email"/> <br/>
		Address: <input type="text" name="adress"/> <br/>
   		Phone: <input type="text" name="phone" /> <br/> <%-- value =  ???? --%>
		<input type="submit" value="Save changes">
	</form>	
</body>
</html>