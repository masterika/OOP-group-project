<!DOCTYPE html>
<%@page import="model.data.users.User"%>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Turista</title>
		<!--CSS-->
		<link type="text/css" rel="stylesheet" href="CSS/jquery-ui.css">
		<link type="text/css" rel="stylesheet" href="CSS/common.css" />
		<link type="text/css" rel="stylesheet" href="CSS/home.css" />
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
			<%@include file="search/index.jsp" %>
		</div>

		<table class="tops" cellpadding="0" cellspacing="0" border="0">
			<tr>
				<td class="top_objects" style="border-right: 1px solid #AAA;">
					<h2>Top Agencies</h2>
					<table class="top_objectsT" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<%@include file="agency/links.jsp" %>
							<%@include file="agency/links.jsp" %>
							<%@include file="agency/links.jsp" %>
						</tr>
					</table>
				</td>
				<td class="top_objects">
					<h2>Top Hotels</h2>
					<table class="top_objectsT" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<%@include file="hotel/links.jsp" %>
							<%@include file="hotel/links.jsp" %>
							<%@include file="hotel/links.jsp" %>	
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<div class="footer">
			© 2014 TURISTA. All Rights Reserved
		</div>

	</body>
</html>