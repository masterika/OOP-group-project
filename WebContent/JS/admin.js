$(function() {

	$("#reg-users-tabs").tabs();
	// $("#reg-users-tabs").tabs("option", "active", 1);
	// $("#reg-users-tabs").height(100);
	// $("#reg-users-tabs").width(500);

	$("#activities").tabs();
	// $("#activities").tabs("option", "active", 1);
	// $("#activities").height(100);
	// $("#activities").width(500);

	$(".button").hover(function() {
		$(this).toggleClass("button-hovered");
	});

	$(".button").click(function() {
		$(this).addClass("button-clicked");
		var id = $(this).siblings(".show-user-link").attr("data-id");
		var p = $(this).siblings("#approval");
		$.ajax({
			url : 'ApproveUserServlet',
			data : {
				"id" : id
			},
			type : 'get',
			cache : false,
			success : function(responseText) {
				console.log(responseText);

				p.text(responseText);
			},
			error : function() {
				alert('error');
			}
		});

		
	});
	
	
	
	$(".bann-button").hover(function() {
		$(this).toggleClass("button-hovered");
	});

	$(".bann-button").click(function() {
		$(this).addClass("bann-button-clicked");
		var id = $(this).siblings(".reg-user-link").attr("data-id");
		var button = $(this).siblings(".banned-par");
		console.log(id);
		$.ajax({
			url : 'BanUserServlet',
			data : {
				"id" : id
			},
			type : 'get',
			cache : false,
			success : function(responseText) {
				console.log(responseText);
				if (responseText = "true")
					button.text(" Banned!");
			},
			error : function() {
				alert('error');
			}
		});
	});

});
