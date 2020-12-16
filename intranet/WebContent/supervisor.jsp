<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supervisor</title>
</head>
<body>
	<div class="tab">
		<button class="tablinks" onclick="changeTab(event,'Pending')">Pending
			Review</button>
		<button class="tablinks" onclick="changeTab(event,'Permits')">Permits</button>
	</div>

	<div id="Pending"></div>

	<div id="Permits"></div>

	<script type="text/javascript">
		const BASE_URL = "http://localhost:8080";
		const myCookie = readCookie(user);
		const user;
		//get me
		$.ajax({
			url : BASE_URL + "/supervisor/me?token=" + myCookie,
			type : GET,
			cache : false,
			success : function(response) {
				console.log(response)
				user = JSON.parse(response);
			}
		})
		//get and show permit requests pending review
		$.ajax({
			url : BASE_URL + "/permits?status=pending",
			type : GET,
			cache : false,
			success : function(response) {
				const permits = JSON.parse(response);

			}
		})
		//get and show the permits for my department
		$.ajax({
			url : BASE_URL + "/permits?dep=" + user.depID,
			type : GET,
			cache : false,
			success : function(response) {
				const permits = JSON.parse(response)
				var table = $("<table/>").attr("id", "permitTable");
				$("#Permits").append(table)
				for (var i = 0; i < permits.length; i++) {
					var name = "<td>" + permits[i].name + "<td>";
					var status = "<td>" + permits[i].status + "<td>";
					var from = "<td>" + permits[i].fromDate + "<td>";
					var to = "<td>" + permits[i].toDate + "<td>";
					var button = "<button onclick = viewPermit("+ permits[i].id")>" + View +"</button>";
					$("#permitTable").append(tr + name + status + from + to);
				}
			}
		})

		function viewPermit(id) {
			window.location.replace(BASE_URL + "/permits/" + id)
		}

		function readCookie(name) {
			var nameEQ = name + "=";
			var ca = document.cookie.split(';');
			for (var i = 0; i < ca.length; i++) {
				var c = ca[i];
				while (c.charAt(0) == ' ')
					c = c.substring(1, c.length);
				if (c.indexOf(nameEQ) == 0)
					return c.substring(nameEQ.length, c.length);
			}
			return null;
		}
	</script>
</body>
</html>