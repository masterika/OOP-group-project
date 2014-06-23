<%@page import="model.data.db.CommentStorage"%>
<%@page import="model.data.db.StaticStorage"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.data.users.Hotel"%>
<%@page import="model.data.users.Client"%>
<%@page import="model.data.Comment"%>
<%@page import="helper.CommentConstants"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Include the jQuery library (local or CDN) -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Include the plugin *after* the jQuery library -->
<script src="JS/bjqs-1.3.min.js"></script>

<!-- Include the basic styles -->
<link type="text/css" rel="Stylesheet" href="styles/bjqs.css" />

<!-- Include the basic styles -->
<link type="text/css" rel="Stylesheet" href="styles/demo.css" />

<script>
$(document).ready(function() {
    $('#my-slideshow').bjqs({
        'height' : 320,
        'width' : 620,
        'responsive' : true,
        'showmarkers' : false
    });
});
</script>


  <style type="text/css">
        
        #content{
            width: 200px;
            float: left;
        }
        #my-slideshow{
            display: block;
            margin-left: 210px;
        }
</style> 


<title>Insert title here</title>
</head>
<body>
	
	<div id="content">
	
		<a href=index.jsp> main page </a>
		<%
			Hotel hotel = StaticStorage.loadHotel(Integer.parseInt(request.getParameter("ID")));
		%>
		<p> Name: <%=hotel.getName()%> </p>
		<p> Phone: <%=hotel.getTelephone()%> </p>
		<p> Address: <%=hotel.getAdress()%> </p>
		<p> Stars: <%=hotel.getStars()%> </p>
		<p> Email: <%=hotel.getEmail()%> </p>
		<p> Number of rooms: <%=hotel.getRoomNum()%> </p>
		
		<%
			List<Comment> comments = CommentStorage.loadComments(1, hotel.getId()); // 1iani constantebit minda
			for (int i = 0; i < comments.size(); i++) {				
				Comment comment = comments.get(i);
				Client client = StaticStorage.loadClient(comment.getUserId());
			%>
			<p> <%=client.getName()+" : "+comment.getText()%></p>
			<%} 
		%>
		
	<form action="CommentServlet" method="post">
		<input type="hidden" name="id" value="<%=hotel.getId()%>" />
		<%
			int commenterId = ((Client)request.getSession().getAttribute("client")).getId();
		
		%>
		<input type="hidden" name="commenterId" value="<%= commenterId %>" />
		<input type="hidden" name="type" value="<%=1 %>" /> <%//es 1 constantit minda %>
		<input type="text" name="text"/>
		<input type="submit" value="Add Comment" />
	</form>
		
	</div>
	<div id="my-slideshow">
		<ul class="bjqs">	
	<%
		ArrayList<String> images = (ArrayList<String>)request.getAttribute("images");
		for (int i = 0; i < images.size(); i++) {
		%>
		<li><img src="data:image/gif;base64,<%=images.get(i) %>" /></li>
		<%}
	%>
		</ul>
	</div>

</body>
</html>