<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
				<h1>Novo Usuário</h1>
			</div>
		</div>
		<form method="POST" action="${s:mvcUrl('UC#save').build() }">

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="name">Nome</label> <input type="text" name="name"
							id="name" class="form-control" required>
						<f:errors path="user.name" />
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="cpf">CPF</label> <input type="text" name="cpf"
							id="cpf" class="form-control input-cpf" required>
						<f:errors path="user.cpf" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="email">E-mail</label> <input type="email" name="email"
							id="email" class="form-control" required>
						<f:errors path="user.email" />
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="phone">Telefone</label> <input type="text" name="phone"
							id="phone" class="form-control input-phone" required>
						<f:errors path="user.phone" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-primary">Salvar</button>
				</div>
			</div>
		</form>
	</div>

	<footer>
		<jsp:include page="../includes/footer.jsp" />
	</footer>
</body>

</html>