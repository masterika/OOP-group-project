<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="model.data.Comment" %>
<%@page import="model.data.users.User" %>
<%@page import="model.data.users.Agency" %>
<%@page import="model.data.db.CommentStorage" %>
<%@page import="model.data.db.StaticStorage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>Turista</title>
		<!--CSS-->
		<link type="text/css" rel="stylesheet" href="CSS/jquery-ui.css">
		<link type="text/css" rel="stylesheet" href="CSS/common.css" />
		<link type="text/css" rel="stylesheet" href="CSS/object.css" />
		<link type="text/css" rel="stylesheet" href="CSS/bjqs.css">
		<!--JS-->
		<script type="text/javascript" src="JS/jquery.min.js"></script>
		<script type="text/javascript" src="JS/jquery-ui.js"></script>
		<script type="text/javascript" src="JS/common.js"></script>
		<script type="text/javascript" src="JS/bjqs-1.3.min.js"></script>
		<script type="text/javascript" src="JS/object.js"></script>
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

		<div class="object">
			<table class="objectT" cellpadding="0" cellspacing="0" border="0" align="center">
				<tr>
					<td class="object_title" colspan="2">
						<h2>Agency</h2>
					</td>
				</tr>
				<tr>
					<td class="object_info">
					<%
						Agency agency = StaticStorage.loadAgency(Integer.parseInt(request.getParameter("ID")));
					%>
						<table class="object_infoT" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td class="object_info_desc">Name:</td>
								<td class="object_info_val"><%=agency.getName()%></td>
							</tr>
							<tr>
								<td class="object_info_desc">Phone:</td>
								<td class="object_info_val"><%=agency.getTelephone()%></td>
							</tr>
							<tr>
								<td class="object_info_desc">Address:</td>
								<td class="object_info_val"><%=agency.getAdress()%></td>
							</tr>
							<tr>
								<td class="object_info_desc">Email:</td>
								<td class="object_info_val"><%=agency.getEmail()%></td>
							</tr>
							
							
						</table>

						<table class="commentsT" cellpadding="0" cellspacing="0" border="0">
							<%
					 			User us =  ((User)request.getSession().getAttribute("user"));
					 			if (us != null) {
					 			int commenterId = us.getId();
					  		%>			
							<form action="CommentServlet" method="post">
							<input type="hidden" name="id" value="<%=agency.getId()%>" />
							<input type="hidden" name="commenterId" value="<%= commenterId %>" />
  							<input type="hidden" name="type" value="<%=1 %>" /> <%}%>
								<tr>
									<td class="comment_inputW">
										<textarea class="comment_input" spellcheck="false" placeholder="Write Comment" name="text"></textarea>
										<button class="comment_submit">Post</button>
									</td>
								</tr>
								
							</form>
							
							<tr>
								<td class="commentsW">
									<%
									List<Comment> comments = CommentStorage.loadComments(1, agency.getId()); 	
									for (int i = 0; i < comments.size(); i++) {				
										Comment comment = comments.get(i);
										User user1 = StaticStorage.loadUser(comment.getUserId());	
									%>
									<div class="comment">
										<table class="commentT" cellpadding="0" cellspacing="0" border="0">
											<tr>
												<td class="commentW">
													<a href="#"><%=user1.getUsername()%>  </a>
													:   <%=comment.getText()%>
													
												</td>
											</tr>
										</table>
									</div>
									<%}%>
								</td>
							</tr>
						</table>
					</td>
					<td class="object_gallery">
						<div class="object_galleryW">
					        <ul class="bjqs">
					     		<%
					     		ArrayList<String> images = (ArrayList<String>)request.getAttribute("images");
								for (int i = 0; i < images.size(); i++) {
								%>
								<li><img src="data:image/gif;base64,<%=images.get(i) %>" /></li>
								<%}%>
					        </ul>
					    </div>
					</td>
				</tr>
			</table>
		</div>

		<div class="footer">
			© 2014 TURISTA. All Rights Reserved
		</div>

	</body>
</html>