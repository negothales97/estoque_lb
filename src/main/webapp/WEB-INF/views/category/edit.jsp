<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<jsp:include page="../includes/head.jsp" />
</head>

<body>
	<div class="container">
		<header>
		<jsp:include page="../includes/header.jsp" />
		</header>

		<div class="row" style="margin-top:20px;">
			<div class="col-sm-12">
				<h1>Editar Categorias</h1>
			</div>
		</div>
		<form method="POST" action="${s:mvcUrl('CC#update').build() }">

			<input type="hidden" value="${category.id }" name="id">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="name">Nome</label> <input type="text" name="name"
							id="name" value="${category.name }" class="form-control" required>
							<f:errors path="category.name"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-primary">Atualizar</button>
				</div>
			</div>
		</form>
	</div>

	<footer>
		<jsp:include page="../includes/footer.jsp" />
	</footer>
</body>

</html>