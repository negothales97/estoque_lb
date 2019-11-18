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
				<h1>Novo Pedido</h1>
			</div>
		</div>
		<form method="POST" action="${s:mvcUrl('BC#save').build() }">

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="user">Usuários</label> <select class="form-control"
							name="userId">
							<option>Selecione..</option>
							<c:forEach items="${users }" var="user">
								<option value="${user.id }">${user.name }</option>
							</c:forEach>
						</select>
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