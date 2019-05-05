<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.data.users.User"%>
<%@ page import="listeners.SessionCountListeners"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.data.users.Agency"%>
<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.users.Client"%>
<%@page import="model.data.users.Sellers"%>
<%@page import="model.data.Comment"%>
<%@page import="model.data.db.StaticStorage"%>
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

		<ul>
			<li><a class="reg-hotels" href="#reg-hotels-tab"><span>hotels</span></a></li>
			<li><a class="reg-agencies" href="#reg-agencies-tab"><span>agencies</span></a></li>
			<li><a class="reg-clients" href="#reg-clients-tab"><span>clients</span></a></li>
		</ul>
		<div id="reg-hotels-tab">

			<ul>
				<%
					ArrayList<Hotel> hotels = StaticStorage.getHotelsFromDB();

					for (int i = 0; i < hotels.size(); i++) {
				%>
				<li><a class="reg-user-link"
					data-id="<%=hotels.get(i).getId()%>"
					href=<%="ShowPhoto?ID=" + hotels.get(i).getId()%>> <%=hotels.get(i).getName()%></a>

					<p class="banned-par">
						ban status:
						<%=hotels.get(i).getBannStatus()%></p>
					<div class="bann-button">BANN!!!</div></li>
				<%
					}
				%>

			</ul>
		</div>
		<div id="reg-agencies-tab">

			<ul>
				<%
					ArrayList<Agency> agencies = StaticStorage.getAgenciesFromDB();
					for (int i = 0; i < agencies.size(); i++) {
				%>
				<li><a class="reg-user-link"
					data-id="<%=agencies.get(i).getId()%>"
					href=<%="ShowPhoto?ID=" + agencies.get(i).getId()%>> <%=agencies.get(i).getName()%>
				</a>
					<p class="banned-par">
						ban status:
						<%=agencies.get(i).getBannStatus()%></p>
					<div class="bann-button">BANN!!!</div></li>
				<%
					}
				%>
			</ul>
		</div>

		<div id="reg-clients-tab">

			<ul>
				<%
					ArrayList<Client> clients = StaticStorage.getClientsFromDB();
					for (int i = 0; i < clients.size(); i++) {
				%>
				<li><a class="reg-user-link"
					data-id="<%=clients.get(i).getId()%>"
					href=<%="ShowPhoto?ID=" + clients.get(i).getId()%>> <%=clients.get(i).getName()%>
				</a>
					<p class="banned-par">
						ban status:
						<%=clients.get(i).getBannStatus()%></p>
					<div class="bann-button">BANN!!!</div></li>
				<%
					}
				%>
			</ul>

		</div>
	</div>

	<br>
	<div id="activities">
		<p>Activities</p>
		<ul>
			<li><a href="#waiting-users-tab">waiting users</a></li>
			<li><a href="#comments-tab">comments</a></li>
		</ul>
	</div>

	<div id="waiting-users-tab">


		<ul>
			<%
				ArrayList<Sellers> sellers = StaticStorage.getSellersToApprove();
				for (int i = 0; i < sellers.size(); i++) {
			%>
			<li class="show-user"><a data-id="<%=sellers.get(i).getId()%>"
				class="show-user-link"
				href=<%="ShowPhoto?ID=" + sellers.get(i).getId()%>> <%=sellers.get(i).getName()%></a>
				<p id="approval">
					approval status:
					<%=sellers.get(i).getApprStatus()%></p>

				<div class="button">Approve</div></li>

			<%
				}
			%>
		</ul>
	</div>


	<div id="comments-tab">
		<ul>
			<%
				ArrayList<Comment> comments = StaticStorage.getCommentsFromDB();
				for (int i = 0; i < comments.size(); i++) {
					Comment comment = comments.get(i);
			%>
			<li>
				<%
					if (comment.getType() == 1) {
				%> <a class="comment-link"
				href="<%="ShowHotel?ID=" + comment.getObjectId()%>">
					<div class="comment-block">
						<%
							User user = StaticStorage.loadUser(comment.getUserId());
						%>
						<%=user.getUsername() + ": "%>
						<p>
							<%=comment.getText()%>
						</p>
					</div>
			</a> <%
 	}
 		if (comment.getType() == 2) {
 %> <a class="comment-link"
				href="<%="ShowAgency?ID=" + comment.getObjectId()%>"><div
						class="comment-block">
						<%
							User user = StaticStorage.loadUser(comment.getUserId());
						%>
						<%=user.getUsername() + ": "%>
						<p>
							<%=comment.getText()%>
						</p>
					</div> </a> <%
 	}
 		if (comment.getType() == 3) {
 %> <a class="comment-link"
				href="<%="trip_view.jsp?ID=" + comment.getObjectId()%>">
					<div class="comment-block">
						<%
							User user = StaticStorage.loadUser(comment.getUserId());
						%>
						<%=user.getUsername() + ": "%>
						<p>
							<%=comment.getText()%>
						</p>
					</div>
			</a> <%
 	}
 %>
			</li>
			<%
				}
			%>

		</ul>

	</div>



</body>
</html>