<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Configurazione Database</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/main.css">
</head>
<body>
	<main class="container form-wrapper">
		<div class="title-bar">
			<h1>Configurazione Database</h1>
		</div>
		<%
			String error = request.getParameter("error");
			if ("connection".equals(error)) {
			%>
			<div class="alert alert-danger" role="alert">
				Impossibile connettersi al database. Verifica i dati inseriti.
			</div>
		    <%
		    }
		%>
		<form action="config" method="post" class="needs-validation"
			novalidate>
			<div class="mb-3">
				<label for="host" class="form-label">Host:</label> <input
					type="text" class="form-control" id="host" name="host"
					value="localhost" required>
				<span class="invalid-feedback">Inserisci l'host</span>
			</div>

			<div class="mb-3">
				<label for="port" class="form-label">Porta:</label> <input
					type="number" class="form-control" id="port" name="port"
					value="3306" required>
				<span class="invalid-feedback">Inserisci la porta</span>
			</div>

			<div class="mb-3">
				<label for="database" class="form-label">Nome Database:</label> <input
					type="text" class="form-control" id="database" name="database"
					value="rubrica" required>
				<span class="invalid-feedback">Inserisci il nome del database</span>
			</div>

			<div class="mb-3">
				<label for="username" class="form-label">Username:</label> 
				<input type="text" class="form-control" id="username" name="username" value="rubrica" required>
				<span class="invalid-feedback">Inserisci lo username</span>
			</div>

			<div class="mb-4">
				<label for="password" class="form-label">Password:</label> <input
					type="password" class="form-control" id="password" name="password"
					value="rubrica" required>
				<span class="invalid-feedback">Inserisci la password</span>
			</div>

			<div class="action-wrapper">
				<button class="btn action-btn" type="submit">PROCEDI</button>
			</div>
		</form>
	</main>
	<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>