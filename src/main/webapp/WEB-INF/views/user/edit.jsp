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

		<div class="row" style="margin-top:20px;">
			<div class="col-sm-12">
				<h1>Editar Usuários</h1>
			</div>
		</div>
		<form method="POST" action="${s:mvcUrl('UC#update').build() }">

			<input type="hidden" value="${user.id }" name="id">
			
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="name">Nome</label> <input type="text" value="${user.name }" name="name"
							id="name" class="form-control">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="cpf">CPF</label> <input type="text" value="${user.cpf }" name="cpf"
							id="cpf" class="form-control">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="email">E-mail</label> <input type="email" value="${user.email }" name="email"
							id="email" class="form-control">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="phone">Telefone</label> <input type="text" value="${user.phone }" name="phone"
							id="phone" class="form-control">
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