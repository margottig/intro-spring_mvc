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
<title>TITULO AQUI</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>

	<h1>Registra un libro</h1>

	<div class="container w-50 border border-primary border-2 mt-5">
		<h1 class="text-center text-danger pt-2 pb-2">Formulario</h1>

		<form:form action="/books/new" method="post" modelAttribute="book">
			<div class="row mb-3">
				<form:errors class="text-danger" path="title"></form:errors>
				<form:errors class="text-danger" path="language"></form:errors>
				<form:errors class="text-danger" path="description"></form:errors>
			</div>
			<div class="row mb-3">
				<form:label path="title" for="text" class="col-sm-3 col-form-label">Titulo:</form:label>
<%-- 				<form:errors class="text-danger" path="title"></form:errors> --%>
				<div class="col-sm-8">
					<form:input path="title" type="text" class="form-control"
						name="nombre" id="text" aria-describedby="text" />
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="language" for="text"
					class="col-sm-3 col-form-label">Language:</form:label>
<%-- 				<form:errors class="text-danger" path="language"></form:errors> --%>
				<div class="col-sm-8">
					<form:input path="language" type="text" class="form-control"
						name="nombre" id="text" aria-describedby="text" />

				</div>
			</div>
			<div class="row mb-3">
				<form:label path="description" for="text"
					class="col-sm-3 col-form-label">Description:</form:label>
<%-- 				<form:errors class="text-danger" path="description"></form:errors> --%>
				<div class="col-sm-8">
					<form:input path="description" type="text" class="form-control"
						name="nombre" id="text" aria-describedby="text" />
				</div>
			</div>
			<div class="row mb-3">
				<form:label path="numberOfPages" for="text"
					class="col-sm-3 col-form-label">Num of Pages:</form:label>
				<div class="col-sm-8">
					<form:input path="numberOfPages" type="text" class="form-control"
						name="nombre" id="text" aria-describedby="text" />
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-sm-11 d-flex justify-content-end">
					<button type="submit" class="btn btn-lg btn-primary w-25">Submit</button>
				</div>
			</div>

		</form:form>

	</div>

</body>
</html>
