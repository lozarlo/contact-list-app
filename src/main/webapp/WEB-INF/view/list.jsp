<%@ page import="java.util.Vector"%>
<%@ page import="contacts.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Contatti</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Momo+Trust+Sans:wght@200..800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/main.css">
</head>
<body>
	<main class="container table-container">
		<div class="title-bar">
			<h1>Rubrica</h1>
		</div>

		<table
			class="table table-striped table-hover text-center align-middle">
			<thead class="table-success">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">Cognome</th>
					<th scope="col">Telefono</th>
					<th scope="col">Azioni</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<%
				Vector<Person> contacts = ContactsManager.getAll(session);
				for (Person p : contacts) {
				%>
				<tr>
					<th scope="row">
						<span id="id-col-table">
							<%=p.getId()%>
							<img class="icon" 
								src="${pageContext.request.contextPath}/assets/person_icon.svg" alt="person icon">
						</span>
					</th>
					<td><%=p.getName()%></td>
					<td><%=p.getSurname()%></td>
					<td><%=p.getPhone()%></td>
					<td>
						<div class="action-wrapper">
							<a class="btn btn-sm action-btn"
								href="contacts?action=edit&id=<%=p.getId()%>"> 
								MODIFICA 
							</a> 
							<a
								class="btn btn-sm action-btn"
								href="contacts?action=delete&id=<%=p.getId()%>"
								onclick="return confirm('Delete this contact?')"> 
								ELIMINA 
							</a>
						</div>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div class="action-wrapper">
			<a class="btn btn-sm action-btn" href="contacts?action=new">
				NUOVO </a>
		</div>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>