<script src="JS/fb-login.js"></script>
<script src="JS/google-login.js"></script>



<div class="pop_login">
	<div class="pop_login_title">Log In</div>
	<table class="pop_loginT" cellpadding="0" cellspacing="5" border="0"
		align="center">
		<form action="LoginServlet" method="post">
			<tr>
				<td class="pop_login_row"><input type="text" spellcheck="false"
					autocomplete="off" name="username" placeholder="USERNAME" /></td>
			</tr>
			<tr>
				<td class="pop_login_row"><input type="password"
					spellcheck="false" autocomplete="off" name="password"
					placeholder="PASSWORD" /></td>
			</tr>
			<tr>
				<td class="pop_login_row">
					<button>LOG IN</button>
				</td>

			</tr>
			<fb:login-button autologoutlink="true" scope="public_profile,email"
				onlogin="checkLoginState();" >
			</fb:login-button>

			<div id="status"></div>

			<!-- GOOGLE -->
			<div id="gConnect">
				<button class="g-signin"
					data-scope="https://www.googleapis.com/auth/plus.login"
					data-requestvisibleactions="http://schemas.google.com/AddActivity"
					data-clientId="1083863416343-r3a1t0pehjnt7unfqn1c1v2u2334okja.apps.googleusercontent.com" data-callback="onSignInCallback"
					data-theme="dark" data-cookiepolicy="single_host_origin">
				</button>
			</div>
			<div id="authOps" style="display: none">
				<h2>User is now signed in to the app using Google+</h2>
				<button id="disconnect">Disconnect</button>

				<h2>User's profile information</h2>
				<div id="profile"></div>

				<h2>User's friends that are visible to this app</h2>
				<div id="visiblePeople"></div>

				<h2>Authentication Logs</h2>
				<pre id="authResult"></pre>
			</div>
			<div id="loaderror">
				This section will be hidden by JQuery. If you can see this message,
				you may be viewing the file rather than running a web server.<br />
				The sample must be run from http or https. See instructions at <a
					href="https://developers.google.com/+/quickstart/javascript">
					https://developers.google.com/+/quickstart/javascript</a>.
			</div>

		</form>

	</table>
</div>



