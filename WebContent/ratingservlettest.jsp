<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RatingServlet" method="post">	
		raterId: <input type="hidden" name="raterId" value = "1";><br>	
		ratedId: <input type="hidden" name="ratedId" value = "2";><br>		
		rate: <input type="hidden" name="rate" value = "3";><br>				
		 type: <input type="hidden" name="type" value="hotel_rating" />	
		 <input type="submit" value="AddRating"><br>	
	</form>
</body>
</html>