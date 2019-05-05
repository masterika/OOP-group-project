<%@page import="model.data.db.StaticStorage"%>
<%@page import="model.data.db.PicturesStorage"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>        
        
</head>
<body>
	<div id="picturesDiv">
		<%
		ArrayList<String> images = PicturesStorage.getPicturesByID(Integer.parseInt(request.getParameter("ID")));
		System.out.println(images.size());
		for (int i = 0; i < images.size(); i++) {
		%>
		<li><img src="data:image/gif;base64,<%=images.get(i) %>" /></li>
		<%}
		%>
	</div>

	<form action="UploadPhoto" method="post" enctype="multipart/form-data">
		<input type="hidden" name="userId" value='<%=request.getParameter("ID")%>' />
		<input type="file" name="image[]" multiple />
		<input type="submit" id="submitButton"/>
	</form>
	
</body>
</html>
