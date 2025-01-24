<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Team List</title>
</head>
<body>

	<h2>List of Teams</h2>

	<!-- Check if teams are available -->
	<c:if test="${not empty allteams}">
		<!-- Display the list of teams -->
		<table border="1">
			<thead>
				<tr>
					<th>Team Name</th>
					<th>Players</th>
				</tr>
			</thead>
			<tbody>
				<!-- Loop through the list of teams -->
				<c:forEach var="team" items="${allteams}">
					<tr>
						<td>${team.name}</td>
						<td>
							<!-- Loop through players of each team --> <c:forEach
								var="player" items="${team.players}">
								<p>${player.name}</p>
								<!-- Display player name -->
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<!-- If no teams are found -->
	<c:if test="${empty allteams}">
		<p>No teams found.</p>
	</c:if>

</body>
</html>

