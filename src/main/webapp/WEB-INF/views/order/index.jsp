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

		<form method="get">
			<div class="row" style="margin-top: 20px;">
				<div class="col-sm-4">
					<h1>Lista de Pedidos</h1>
				</div>
				<div class="col-sm-4" style="padding-top: 10px;">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pesquisar"
							name="searchString">
						<div class="input-group-append">
							<button class="btn btn-outline-secondary" type="submit">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="col-sm-4">
					<a href="${s:mvcUrl('PC#create').build() }">
						<button type="button" class="btn btn-success float-right">Novo</button>
					</a>
				</div>
			</div>
		</form>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nome</th>
							<th scope="col">Categoria</th>
							<th scope="col">Editora</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${products.size() > 0 }">
							<c:forEach items="${products }" var="product">
								<tr>
									<td>${product.id }</td>
									<td>${product.name }</td>
									<td>${product.category.name }</td>
									<td>${product.publishing}</td>
									<td><a
										href="${s:mvcUrl('PC#edit').arg(0,product.id).build() }"
										title="Editar" class="act-list act-edit">
											<button type="button" class="btn btn-primary">
												<i class="fa fa-edit" aria-hidden="true"></i>
											</button>
									</a> <a href="${s:mvcUrl('PC#delete').arg(0,product.id).build() }"
										title="Excluir" class="act-list act-delete">
											<button type="button" class="btn btn-danger">
												<i class="fa fa-trash" aria-hidden="true"></i>
											</button>

									</a></td>
								</tr>
							</c:forEach>
						</c:if>

					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>