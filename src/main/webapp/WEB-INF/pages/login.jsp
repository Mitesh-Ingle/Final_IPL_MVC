<center>
	<a href="Players">ALL PLAYERS</a> <a href="teams">ALL TEAMS</a> <a
		href="matches">ALL MATCHES</a>
</center>
<center>
	<font color="red"> <%
 String message = (String) request.getAttribute("message");
 if (message != null) { // Checking if the message is not null
 	out.println(message);
 }
 %>
	</font>
</center>
<h1>For Players</h1>
<form action="logincheck">
	<center>
		Username: <input type="text" name="uname"> <br> <br>
		Password : <input type="text" name="Password"> <br> <br>
		<input type="Submit" value="login">
	</center>
</form>

<h1>For Teams</h1>
<form action="teamcheck">
	<center>
		Username: <input type="text" name="uname"> <br> <br>
		Password : <input type="text" name="Password"> <br> <br>
		<input type="Submit" value="login">
	</center>
</form>
<h1>For Matches</h1>
<form action="teamcheck">
	<center>
		Username: <input type="text" name="uname"> <br> <br>
		Password : <input type="text" name="Password"> <br> <br>
		<input type="Submit" value="login">
	</center>
</form>