$(function(){
	
		$("#reg-users-tabs").tabs();
		//$("#reg-users-tabs").tabs("option", "active", 1);
		//$("#reg-users-tabs").height(100);
	//	$("#reg-users-tabs").width(500);
	

		$("#activities").tabs();
//		$("#activities").tabs("option", "active", 1);
//		$("#activities").height(100);
//		$("#activities").width(500);
		
		$(".button").hover(function(){
			$(this).toggleClass("button-hovered");
		});
		$(".button").click(function(){

			$(this).addClass("button-clicked");
			$.get('/ApproveUserServlet', function(){
				$("#approval").text(true);
				
			});
			
			
			
		});

});