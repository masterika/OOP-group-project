<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.data.users.User" %>
<div class="header">
<table class="headerT" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td class="logoW">
			<img class="logo" src="IMG/logo.png" />
		</td>
		<td class="navigationW">
			<div class="navigation">
				<a href="/Turista">HOME</a>
				<a href="/Turista/HotelsServlet">HOTELS</a>
				<a href="/Turista/AgenciesServlet">AGENCIES</a>
				<%
					User user = (User) session.getAttribute("user");
					if (user == null) {
				%>
					<a href="#" class="register_link">REGISTER</a>
					<a href="#" class="login_link">LOG IN</a>
				<%}else{%>
					<a href="#" class=""><%=user.getUsername().toUpperCase()%></a>
					<a href="logout" class="logout_link">LOG OUT</a>
				<%} %>
				</div>
			</td>
		</tr>
	</table>
</div>