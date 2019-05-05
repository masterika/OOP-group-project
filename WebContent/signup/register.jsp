<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script src="../JS/jquery-1.11.1.min.js"></script>
<!--<link rel="stylesheet" type="text/css" href="/Turista/styles/registerStyles.css">-->
<link rel="stylesheet" type="text/css" href="/Turista/CSS/inputStyles.css">

</head>
<body>
<a href=../index.jsp> main page </a>

<div id="bg">
	<div class="module">
		<form action="../AccountCreateServlet" method="post">
		<!--  <ul>
      <li class="tab activeTab"><img src="http://i.imgur.com/Fk1Urva.png" alt="" class="icon"/></li>
      <li class="tab" ><img src="http://i.imgur.com/ZsRgIDD.png" alt="" class="icon"/></li>
      <li class="tab" ><img src="http://i.imgur.com/34Q50wo.png" alt="" class="icon"/></li>
      
    </ul>-->
			<select id="select" name="type">
				<option value="client">Client</option>
				<option value="hotel">Hotel</option>
				<option value="agency">Agency</option>
			</select>
			<div id='inputs'>
				<%@include file="registerClient.jsp" %>
			</div>
		</form>
	</div>
</div>

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