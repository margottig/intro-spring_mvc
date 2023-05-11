<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK API</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<h1>Bienvenido a la biblioteca</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Description</th>
				<th>Language</th>
				<th>Number of pages</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="libro" items="${libros }">
				<tr>
					<td> <c:out value="${libro.id }"></c:out></a></td>
					<td> <a href="/books/${libro.id}"><c:out value="${libro.getTitle() }"></c:out></td>
					<td><c:out value="${libro.description }"></c:out></td>
					<td><c:out value="${libro.language }"></c:out></td>
					<td><c:out value="${libro.numberOfPages }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
