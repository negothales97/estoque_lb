<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
<jsp:include page="includes/head.jsp" />
</head>

<body>

	<div class="container">
		<c:if test="${error != null}">
			<section class="content-header" style="padding-top: 20px;">
				<!-- Main row -->
				<div class="row">
					<!-- Left col -->
					<section class="col-sm-12">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							${error }
						</div>
					</section>
				</div>
			</section>
		</c:if>

		<div class="row">
			<div class="col-sm-12">
				<h1 class="d-flex justify-content-center">Venda de Livros -
					Casa do Código</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<form action="${s:mvcUrl('HC#validaAdmin').build() }" method="POST">
					<div class="form-group">
						<label for="email">E-mail</label> <input type="email"
							class="form-control" id="email" name="email" required>
					</div>
					<div class="form-group">
						<label for="password">Senha</label> <input type="password"
							class="form-control" id="password" name="password" required>
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