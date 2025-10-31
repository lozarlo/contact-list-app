
<%
String error = request.getParameter("error");
boolean hasError = "true".equals(error);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/main.css">
</head>
<body>
	<%
	if (session.getAttribute("dbHost") == null) {
		response.sendRedirect("index.jsp");
		return;
	}
	%>
	<main class="container form-wrapper">
		<div class="title-bar">
			<h1>Login</h1>
		</div>

		<form action="login" method="post" class="needs-validation" novalidate>
			<div class="mb-3">
				<label for="username" class="form-label">Username:</label> 
				<input type="text" class="form-control <%=hasError ? "is-invalid" : ""%>"
					id="username" name="username" required>
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">Password:</label>
				<input type="password" class="form-control <%=hasError ? "is-invalid" : ""%>"
					id="password" name="password" required>
			</div>

			<%
			if (hasError) {
			%>
			<div class="text-danger mb-3 text-center">Username o password errati</div>
			<%
			}
			%>

			<div class="action-wrapper">
				<button class="btn action-btn" type="submit">ACCEDI</button>
			</div>
		</form>
	</main>
	<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>