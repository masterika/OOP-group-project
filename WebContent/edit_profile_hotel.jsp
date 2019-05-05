<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>

</head>
<body>
	<h1> Edit Profile Hotel</h1>
	<img src = "profile.jpg" height = "100" width = "95" >
	<p>
	<form action="ChangeUserPasswordServlet" method="post">
		Previous password: <input type="password" name="prevpass"><br> 
		New Password: <input type="password" name="newpass"><br>
		Confirm Password: <input type="password" name="confnewpass"><br>
		<input type="hidden" name="type" value="<%=request.getParameter("id") %>" />
		<input type="hidden" name="user" value="Hotel" />
		
		<input type="submit" value="Change Password">
	</form>
	
	<form action="ChangeSellerAdressServlet" method="post">	
		<%@include file="/sellerAdressChange.jsp"%>
		<input type="hidden" name="user" value="Hotel" />
	</form>	
		
	<form action="ChangeSellerNameServlet" method="post">	
		<%@include file="/seller_name_change.jsp"%>
		<input type="hidden" name="user" value="Hotel" />
	</form>	


	<form action="ChangeUserTelephoneServlet" method="post">	
		<%@include file="/seller_telephone_change.jsp"%>
		<input type="hidden" name="user" value="Hotel" />
	</form>	
	
	<a href = <%="gallery.jsp?ID=" + request.getParameter("id")%> > My Gallery </a>

</body>
</html>















<!-- 



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Turista</title>
	
		<link type="text/css" rel="stylesheet" href="CSS/jquery-ui.css">
		<link type="text/css" rel="stylesheet" href="CSS/common.css" />
		<link type="text/css" rel="stylesheet" href="CSS/object.css" />
		<link type="text/css" rel="stylesheet" href="CSS/edit.css">
		
		<script type="text/javascript" src="JS/jquery.min.js"></script>
		<script type="text/javascript" src="JS/jquery-ui.js"></script>
		<script type="text/javascript" src="JS/common.js"></script>
		<script type="text/javascript" src="JS/edit.js"></script>
		<script type="text/javascript" src="JS/bjqs-1.3.min.js"></script>
	</head>
 
	<body>

		<div class="popups">
			<div class="pop_background"></div>
			<%@include file="signin/login.jsp" %>
			<%@include file="signup/index.jsp" %>
		</div>
		
		<%@include file="/header.jsp" %>

		<div class="cover">
			<table class="searchT" cellpadding="0" cellspacing="0" border="0" align="center">
				<tr>
					<td class="search_inputW">
						<input class="search_input" type="text" spellcheck="false" autocomplete="off" placeholder="Search" />
					</td>
				</tr>
			</table>
		</div>


		<div class="edit">
			<table class="editT" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td class="profile_imgW">
						<img class="profile_img" src="IMG/no_avatar.jpg" />
					</td>
				</tr>
				<tr>
					<td align="center" class="edit_profile_imgW">
						<button class="edit_profile_img">Change Profile Picture</button>
						<input class="edit_profile_img_input" type="file" />
					</td>
				</tr>
				<tr>
					<td class="edit_inputW" align="center">
						<input class="edit_input" type="text" spellcheck="false" autocomplete="off" placeholder="Something" />
					</td>
				</tr>
				<tr>
					<td class="edit_inputW" align="center">
						<input class="edit_input" type="text" spellcheck="false" autocomplete="off" placeholder="Something" />
					</td>
				</tr>
				<tr>
					<td class="edit_inputW" align="center">
						<input class="edit_input" type="text" spellcheck="false" autocomplete="off" placeholder="Something" />
					</td>
				</tr>
				<tr>
					<td class="edit_inputW" align="center">
						<button>EDIT</button>
					</td>
				</tr>
			</table>
		</div>


		<div class="footer">
			© 2014 TURISTA. All Rights Reserved
		</div>

	</body>
</html>




-->