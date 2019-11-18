<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<jsp:include page="includes/head.jsp" />
</head>

<body>

	<div class="container">

		<div class="row">
			<div class="col-sm-12">
				<h1 class="d-flex justify-content-center">Venda de Livros - Casa do Código</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form action="${s:mvcUrl('CC#index').build() }" method="get">
					<div class="form-group">
						<label for="email">E-mail</label> <input type="email"
							class="form-control" id="email" name="email">
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" name="password">
					</div>

					<button type="submit" class="btn btn-primary">Entrar</button>
				</form>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>

	<footer>
		<jsp:include page="includes/footer.jsp" />
	</footer>
</body>

</html>