<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script src="jquery-1.11.1.min.js"></script>

</head>
<body>
<a href=../index.jsp> main page </a>

<form action="../AccountCreateServlet" method="post">
	<select id="select" name="type">
		<option value="client">Client</option>
		<option value="hotel">Hotel</option>
		<option value="agency">Agency</option>
	</select>
	<div id='inputs'>
		<%@include file="registerClient.jsp" %>
	</div>
</form>


<script>
		$("#select").change(function() {
		var selected = $('#select option:selected').val();
		$('#inputs').empty();
		if (selected == 'client')
			$('#inputs').load("registerClient.jsp");
		else if (selected == 'hotel')
			$('#inputs').load("registerHotel.jsp");
		else
			$('#inputs').load("registerAgency.jsp");
	});
</script>

</body>
</html>