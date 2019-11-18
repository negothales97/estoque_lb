<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
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

		<div class="row" style="margin-top: 20px;">
			<div class="col-sm-12">
				<h1>Editar Produtos</h1>
			</div>
		</div>
		<form method="POST" action="${s:mvcUrl('PC#update').build() }">

			<input type="hidden" value="${product.id }" name="id">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="name">Nome</label> <input type="text" name="name"
							id="name" class="form-control" value="${product.name }">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="publishing">Editora</label> <input type="text"
							name="publishing" id="publishing" class="form-control"
							value="${product.publishing }">
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="category">Categoria</label> <select name="categoryId"
							class="form-control">
							<option>Selecione..</option>
							<c:forEach items="${categories }" var="category">
								<option value="${category.id }"
									${category.id == product.category.id ? "selected" : ""}>${category.name }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-primary">Atualizar</button>
				</div>
			</div>
		</form>

	<footer>
		<jsp:include page="../includes/footer.jsp" />
	</footer>
</body>

</html>