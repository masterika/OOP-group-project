<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.data.users.User"%>
<%@ page import="listeners.SessionCountListeners"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h1>Welcome Admin!</h1>
	<%@include file="logout.html"%>

	<!-- BEGIN SIDEBAR -->
	<div class="admin-page-sidebar">
		<ul class="admin-page-sidebar-menu">
			<li>Dashboard</li>
			<li>Pages</li>
			<li>Data Tables</li>
		</ul>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN DASHBOARD CONTENT -->
	<div class="dashboard-content">
		<div class="statistics-bar">
			<div class="stat-box">
				<div class="title">Users Online</div>
				<div class="numbers"><%=SessionCountListeners.getActiveSessions()%></div>
				<br>
			</div>
			
			<!-- TOTAL NUMBER OF REGISTERED USERS -->
			<div class="stat-box">
				<div class="title">Total number of registered users</div>

				<div class="numbers">
					<jsp:include page="/RegUsersNumServlet" flush="true" />
					<%=session.getAttribute("numOfRegUsers")%>
				</div>
				<br>
			</div>
		</div>
		<div class="notifications-box">
			<div class="title">Notifications</div>
			<div class="notifications-box-tabs">
			
			<!-- RECENTLY REGISTERED USERS -->
				<div class="title">Recent Users</div>
				<div class="user-box">

					<form action=RecentUsersServlet method="post">
						Date: <input type="text" name="date"/> <br/>
						 <input	type="submit" value="Show Users" name="showUsers"/>
						 
					</form>
				</div>
				<%
					ArrayList<User> users = null;
					if ((ArrayList<User>) session.getAttribute("listOfRecentUsers") != null) {
						users = (ArrayList<User>) session
								.getAttribute("listOfRecentUsers");
				%>
				<ul>
					<%
						for (int i = 0; i < users.size(); i++) {
								User user = users.get(i);
					%>
					<li><a href=<%="user_page.jsp?id=" + user.getId()%>> <%=user.getUsername()%>
							<br> is approved: <%=user.getApprStatus()%>
					</a>
						<form action=ApproveUserServlet method="post">
							<input type="submit" value="Approve" name="approve">
						</form></li>
					<%
						}
					}
					%>
				</ul>

			</div>
			<div class="notifications-box-tabs">
				<div class="title">Recent Comments</div>
			</div>
			<div class="notifications-box-tabs">
				<div class="title">Recent Activities</div>
			</div>




		</div>
		<div class="site-visits-chart-box">
			<div class="chart">Chart</div>
		</div>
		<div class="conversations-box">Chat</div>
	</div>
	<!-- END DASHBOARD CONTENT -->





</body>
</html>