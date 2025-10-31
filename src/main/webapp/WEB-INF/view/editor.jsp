<%@ page import="contacts.model.*"%>
<%
Person p = (Person) request.getAttribute("person");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editor Contatto</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Momo+Trust+Sans:wght@200..800&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/css/main.css">
</head>
<body>
	<main class="container form-wrapper">
		<div class="title-bar">
			<h1><%=(p == null) ? "Nuovo Contatto" : "Modifica Contatto"%></h1>
		</div>
		<form action="contacts" method="post" class="needs-validation"
			novalidate>

			<input type="hidden" name="action" value="save"> <input
				type="hidden" name="id" value="<%=(p != null) ? p.getId() : ""%>">

			<div class="mb-3">
				<label for="name" class="form-label">Nome:</label> <input
					type="text" class="form-control" id="name" name="name"
					placeholder="Mario" value="${person.name}" required>
				<span class="invalid-feedback">Inserisci il nome</span>
			</div>

			<div class="mb-3">
				<label for="surname" class="form-label">Cognome:</label> <input
					type="text" class="form-control" id="surname" name="surname"
					placeholder="Rossi" value="${person.surname}" required>
				<span class="invalid-feedback">Inserisci il cognome</span>
			</div>

			<div class="mb-3">
				<label for="address" class="form-label">Indirizzo:</label> <input
					type="text" class="form-control" id="address" name="address"
					placeholder="Via Roma 123, Milano" value="${person.address}"
					required>
				<span class="invalid-feedback">Inserisci l'indirizzo</span>
			</div>

			<div class="mb-3">
				<label for="phone" class="form-label">Telefono:</label> <input
					type="tel" class="form-control" id="phone" name="phone"
					placeholder="3331234567" value="${person.phone}"
					pattern="(\+39)?[0-9]{9,10}"
					title="Il telefono deve contenere 9 o 10 cifre" required>
				<span class="invalid-feedback">Inserisci un numero di telefono valido (9-10 cifre)</span>
			</div>

			<div class="mb-4">
				<label for="age" class="form-label">Età:</label> <input
					type="number" class="form-control" id="age" name="age"
					placeholder="30" value="${person.age}" min="1" max="120" required>
				<span class="invalid-feedback">Inserisci un'età valida (1-120)</span>
			</div>

			<div class="action-wrapper">
				<button class="btn action-btn" type="submit">SALVA</button>
				<a class="btn action-btn" href="contacts">ANNULLA</a>
			</div>
		</form>
	</main>
	<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>