<%@page import="model.data.db.StaticStorage"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.data.db.CommentStorage"%>
<%@page import="model.data.db.StaticStorage"%>
<%@page import="model.data.users.Agency"%>
<%@page import="java.util.List" %>
<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.users.Client"%>
<%@page import="model.data.Comment"%>
<%@page import="helper.CommentConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> view</title>
</head>
<body>
	<div id="content">
	
		<a href=index.jsp> main page </a>
		<%
		Agency agency = StaticStorage.loadAgency(Integer.parseInt(request.getParameter("ID")));
		%>
		<p> Name: <%=agency.getName()%> </p>
		<p> Phone: <%=agency.getTelephone()%> </p>
		<p> Address: <%=agency.getAdress()%> </p>
		<p> Email: <%=agency.getEmail()%> </p>
	</div>
		<%
			List<Comment> comments = CommentStorage.loadComments(2, agency.getId()); // 1iani constantebit minda
			for (int i = 0; i < comments.size(); i++) {				
				Comment comment = comments.get(i);
				Client client = StaticStorage.loadClient(comment.getUserId());
			%>
			<p> <%=client.getName()+" : "+comment.getText()%></p>
			<%} 
		%>
		
	<form action="CommentServlet" method="post">
		<input type="hidden" name="id" value="<%=agency.getId()%>" />
		<%
			int commenterId = ((Client)request.getSession().getAttribute("client")).getId();
		
		%>
		<input type="hidden" name="commenterId" value="<%= commenterId %>" />
		<input type="hidden" name="type" value="<%=2 %>" /> <%//es 2 constantit minda %>
		<input type="text" name="text"/>
		<input type="submit" value="Add Comment" />
	</form>
</body>
</html>