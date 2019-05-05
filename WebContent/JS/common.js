$(document).ready(function() {

	$("body").keyup(function(e) {
		if (e.keyCode == 27) {
			$(".popups > *").hide();
			$("body").css("overflow-y", "scroll");
		}
	});

	$(".pop_background").click(function() {
		$(".popups > *").hide();
		$("body").css("overflow-y", "scroll");
	});

	$(".register_link").click(function() {
		$(".pop_background").show();
		$(".pop_register").show("slow");
		$("body").css("overflow-y", "hidden");
	});

	$(".login_link").click(function() {
		$(".pop_background").show();
		$(".pop_login").show("slow");
		$("body").css("overflow-y", "hidden");
	});

	$(".pop_register_tab").click(function() {
		var target = $(this).attr("data-target");
		$(".pop_register_content_selected").removeClass("pop_register_content_selected");
		$("#pop_register_content_" + target).addClass("pop_register_content_selected");
		$(".pop_register_tab_selected").removeClass("pop_register_tab_selected");
		$(this).addClass("pop_register_tab_selected");
	});

	$(".expand_search_additionalW").click(function() {
		$(this).hide();
		$(".search_additionalW").show();
	});

	$(".datepicker").datepicker();
	
	
	$(function() {
		$(".search_input").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "search",
					type : "GET",
					data : {
						term : request.term
					},
					dataType : "json",
					success : function(data) {
						response( $.map( data, function( item ) {
			            	return {
			            		id: item["id"],
			            		name: item["name"],
			            		adress: item["adress"],
			            		type: item["type"]
			            		
			              	}
			            }));
					}
				});
			},
			select: function( event, ui ) {
//	      		console.log(event);
	      	}
		}).data('ui-autocomplete')._renderItem = function (ul, item) {
			var servlet;
			if(item.type == "hotel"){
				servlet = "ShowHotel?ID="+item.id;
			}else{
				servlet = "ShowAgency?ID="+item.id;
			}
			
			return $( "<li>" )
			    .append( " <a href='"+servlet+"'><p class='ui-autocomplete-name'>"+item.name+"</p><p class='ui-autocomplete-address'>"+item.adress+"</p></a> " )
			    .appendTo( ul );
	    }
	});
});