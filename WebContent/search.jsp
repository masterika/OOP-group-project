<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<form action="search" method="get">

		<input type="radio" name="type" value="Hotel" checked="checked">Hotel
		<input type="radio" name="type" value="Agency">Agency <br>
		<input name="keyword" type="text">
		<input value="Search" type="submit">

	</form>


</body>
</html>