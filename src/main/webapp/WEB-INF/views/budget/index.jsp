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
					<a href="${s:mvcUrl('BC#create').build() }">
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
							<th scope="col">Pedido</th>
							<th scope="col">Total</th>
							<th scope="col">Usuário</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${budgets.size() > 0 }">
							<c:forEach items="${budgets }" var="budget">
								<tr>
									<td>${budget.id }</td>
									<td class="input-money">${budget.total }</td>
									<td>${budget.user.name}</td>
									<td><a
										href="${s:mvcUrl('BC#edit').arg(0,budget.id).build() }"
										title="Editar" class="act-list act-edit">
											<button type="button" class="btn btn-primary">
												<i class="fa fa-edit" aria-hidden="true"></i>
											</button>
									</a> <a href="${s:mvcUrl('BC#delete').arg(0,budget.id).build() }"
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

	<footer>
		<jsp:include page="../includes/footer.jsp" />
	</footer>
</body>

</html>