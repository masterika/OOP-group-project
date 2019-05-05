<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.data.users.Agency" %><!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8" />
		<title>Turista</title>
		<!--CSS-->
		<link type="text/css" rel="stylesheet" href="CSS/jquery-ui.css">
		<link type="text/css" rel="stylesheet" href="CSS/common.css" />
		<link type="text/css" rel="stylesheet" href="CSS/objects.css" />
		<!--JS-->
		<script type="text/javascript" src="JS/jquery.min.js"></script>
		<script type="text/javascript" src="JS/jquery-ui.js"></script>
		<script type="text/javascript" src="JS/common.js"></script>
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

		<div class="objects">
			<h2 class="objects_header">AGENCIES</h2>

			<table class="objectsT" cellpadding="0" cellspacing="10" border="0" align="center">
				<tr>
					<%
					ArrayList<Agency> agency = (ArrayList<Agency>)request.getAttribute("agencies");
					for (int i = 0; i < agency.size(); i++) {
					%>
					<td class="object">
						<table class="objectT" cellpadding="0" cellspacing="5" border="0">
							<tr>
								<td class="object_imgW">
									<img class="object_img" src="http://goglamping.net/wp-content/uploads/2014/05/higher-manor-farm-yurt-main-215x148.jpg" />
								</td>
							</tr>
							<tr>
								<td class="object_title">
									<li><a href=<%="ShowAgency?ID="+agency.get(i).getId()%>> <%=agency.get(i).getName() %></a></li>
									
								</td>
							</tr>
						</table>
					</td>
					<%} %>
				</tr>
			</table>
		</div>

		<div class="footer">
			© 2014 TURISTA. All Rights Reserved
		</div>

	</body>
</html>