<%@page import="com.tka.entity.Player"%>
<%@page import="com.tka.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>


<%
ArrayList<Player> playerlist = (ArrayList<Player>) request.getAttribute("allusers");
%>
<table border="1" cellspacing="0" cellpadding="10">
	<tr>
		<input type="radio" />
		<th>NAME</th>
		<th>AGE</th>
		<th>ID</th>
		<th>TEAM</th>
	</tr>

	<%
	for (Player player : playerlist) { // Use Player type here
		out.println("<tr>");
		out.println("<td>" + player.getName() + "</td>"); // Access Player fields
		out.println("<td>" + player.getAge() + "</td>");
		out.println("<td>" + player.getId() + "</td>");
		out.println("<td>" + player.getTeam() + "</td>");
		out.println("</tr>");
	}
	%>