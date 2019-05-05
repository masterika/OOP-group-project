<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import = "model.data.users.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>

</head>
<body>
	<h1>Edit Profile Client</h1>
	<img src="profile.jpg" height="100" width="95">
	<form action="ChangeUserProfilePictureServlet" method="post">
		Upload picture: <input type="file" name="file">
	</form>
	
	<form action="ChangeUserPasswordServlet" method="post" >
		Previous password: <input type="password" name="prevpass"><br>
		New Password: <input type="password" name="newpass"><br>
		Confirm Password: <input type="password" name="confnewpass"><br>
		
		<input type="hidden" name="type" value="<%=request.getParameter("id") %>" />		
		<input type="hidden" name="user" value="Client" />
		
		<input type="submit" value="Change Password">
	</form>
		
	
	<form action="ChangeUserTelephoneServlet" method="post">	
		<%@include file="/seller_telephone_change.jsp"%>
		<input type="hidden" name="user" value="Client" />
	</form>		
	<%User user = ((User)session.getAttribute("user"));		
		int id = user.getId();
	%>
	<a href=<%="wishlist.jsp?id="+id%>>My Wishlist </a>
	
</body>
</html>