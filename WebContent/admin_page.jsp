<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.data.users.User"%>
<%@ page import="listeners.SessionCountListeners"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.data.users.Agency"%>
<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.users.Client"%>
<%@page import="model.data.users.Sellers"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script src="JS/admin.js"></script>
;
<link rel='stylesheet' type='text/css' href='styles/styles.css' />

</head>
<body>
	<h1>Welcome Admin!</h1>
	<%@include file="logout.html"%>

	<!-- BEGIN SIDEBAR -->
	<!-- <div id="admin-page-sidebar">-->
	<ul id="admin-page-sidebar-menu">
		<li>Dashboard</li>
		<li>Pages</li>
		<li>Data Tables</li>
	</ul>
	<!-- </div>-->
	<div>Users Online</div>
	<div><%=SessionCountListeners.getActiveSessions()%></div>
	<br>

	<!-- Show registered users lists -->
	<div id="reg-users-tabs">
		<p id="reg-users">registered users</p>

		<div>
			<ul>
				<li><a href="#reg-hotels-tab"><span>hotels</span></a></li>
				<li><a href="#reg-agencies-tab"><span>agencies</span></a></li>
				<li><a href="#reg-clients-tab"><span>clients</span></a></li>
			</ul>
			<div id="reg-hotels-tab">
				<jsp:include page="/HotelsForAdminServlet" flush="true" />
				<%
					ArrayList<Hotel> hotels = (ArrayList<Hotel>) request
							.getAttribute("hotels");
					for (int i = 0; i < hotels.size(); i++) {
				%>
				<li><a href=<%="ShowPhoto?ID=" + hotels.get(i).getId()%>> <%=hotels.get(i).getName()%></a></li>
				<%
					}
				%>
				</ul>
			</div>
			<!--  		
			
			<div id="reg-agencies-tab">
			<jsp:include page="/AgenciesForAdminServlet" flush="true" />
<%-- 				<% --%>
// 					ArrayList<Agency> agencies = (ArrayList<Agency>) request
// 							.getAttribute("agencies");
// 					for (int i = 0; i < agencies.size(); i++) {
<%-- 			 	%> --%>
				<li><a href=
<%-- 				<%="ShowPhoto?ID=" //+ agencies.get(i).getId()%>>  --%>
<%-- 				<%=agencies.get(i).getName()%> --%>
<!-- 				</a></li> -->
			<%-- 		}		<% --%>

			<%-- 				%> --%>
			<!-- 				</ul> -->
			<!-- 			</div> -->


			<div id="activities">
				<p>Activities</p>
				<ul>
					<li><a href="#waiting-users-tab">waiting users</a></li>
					<li><a href="#comments-tab">comments</a></li>

				</ul>
			</div>

			<div id="waiting-users-tab">
				<jsp:include page="/SellersToApproveServlet" flush="true" />
				<%
					ArrayList<Sellers> sellers = (ArrayList<Sellers>) request
							.getAttribute("sellers");
					for (int i = 0; i < sellers.size(); i++) {
				%>
				<li class="show-user"><a
					href=<%="ShowPhoto?ID=" + sellers.get(i).getId()%>> <%=sellers.get(i).getName()%></a>
					approval status:
					<p id="approval"><%=sellers.get(i).getApprStatus()%></p> 
					 <%	session.setAttribute("sellerID", sellers.get(i).getId());%>
					<div class="button">Approve</li>
				<%
					}
				%>
				</ul>
			</div>
			<div id="comments-tab">
			</div>
</body>
</html>