<div class="pop_register">
	<table class="pop_registerT" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="pop_register_tab pop_register_tab_selected" data-target="client">Client</td>
			<td class="pop_register_tab" data-target="hotel">Hotel</td>
			<td class="pop_register_tab" style="border-right: none;" data-target="agency">Agency</td>
		</tr>
		
		<tr>
			<form action="AccountCreateServlet" method="post">
			<input type="hidden" name="type" value="client"/>
			<td id="pop_register_content_client" class="pop_register_content pop_register_content_selected" colspan="3">
				<table class="pop_register_contentT" cellpadding="0" cellspacing="5" border="0" align="center">
					<%@include file="userFields.html" %>
					<tr>
						<td class="pop_register_content_row">
							<input type="text" spellcheck="false" autocomplete="off" name="name" placeholder="FIRST NAME" />
						</td>
					</tr>
					<tr>
						<td class="pop_register_content_row">
							<input type="text" spellcheck="false" autocomplete="off" name="surname" placeholder="LAST NAME" />
						</td>
					</tr>
					
					<tr>
						<td class="pop_register_content_row">
							<button>REGISTER</button>
						</td>
					</tr>
				</table>
			</td>
			</form>

			<form action="AccountCreateServlet" method="post">
			<input type="hidden" name="type" value="hotel"/>
			<td id="pop_register_content_hotel" class="pop_register_content" colspan="3">
				<table class="pop_register_contentT" cellpadding="0" cellspacing="5" border="0" align="center">
					<%@include file="userFields.html" %>
					<%@include file="sellersFields.html" %>
					<tr>
						<td class="pop_register_content_row">
							<input type="text" spellcheck="false" autocomplete="off" name="rooms_num" placeholder="NUMBER OF ROOMS" />
						</td>
					</tr>
					<tr>
						<td class="pop_register_content_row">
							<input type="text" spellcheck="false" autocomplete="off" name="stars" placeholder="STARS" />
						</td>
					</tr>
					<tr>
						<td class="pop_register_content_row">
							<button>REGISTER</button>
						</td>
					</tr>
				</table>
			</td>
			</form>

			<form action="AccountCreateServlet" method="post">
			<input type="hidden" name="type" value="agency"/>
			<td id="pop_register_content_agency" class="pop_register_content" colspan="3">
				<table class="pop_register_contentT" cellpadding="0" cellspacing="5" border="0" align="center">
					<%@include file="userFields.html" %>
					<%@include file="sellersFields.html" %>
					<tr>
						<td class="pop_register_content_row">
							<button>REGISTER</button>
						</td>
					</tr>
				</table>
			</td>
			</form>
		</tr>
	</table>
</div>