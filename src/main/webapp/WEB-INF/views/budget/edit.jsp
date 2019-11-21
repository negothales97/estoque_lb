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
			<div class="col-sm-6">
				<h1>Pedido</h1>
			</div>
			<div class="col-sm-6">
				<button type="button" id="btnAdcProduct"
					class="btn btn-success float-right">
					<i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
		<input type="hidden" value="${budget.id }" name="id">
		<div class="row">
			<div class="col-sm-6">
				<h4>Comprador: ${budget.user.name }</h4>
			</div>
		</div>
	</div>

	<div class="container" style="padding-top: 20px;">
		<div class="row">
			<div class="col-sm-12">
				<h5>Itens Pedido</h5>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">Produto</th>
							<th scope="col">Preço Unitário</th>
							<th scope="col">Quantidade</th>
							<th scope="col">Total</th>
							<th scope="col">Ações</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${budgetProducts.size() > 0 }">
							<c:forEach items="${budgetProducts }" var="budgetProduct">
								<tr>
									<td>${budgetProduct.product.name }</td>
									<td>${budgetProduct.price }</td>
									<td>${budgetProduct.qtd }</td>
									<td>${budgetProduct.total }</td>
									<td><a
										href="${s:mvcUrl('BC#removeProduct').arg(0,budgetProduct.id).build() }"
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

		<hr>
		<div class="row">
			<div class="col-sm-12">
				<h4>Outros Pedidos</h4>
			</div>
		</div>
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

						<c:if test="${otherBudgets.size() > 0 }">
							<c:forEach items="${otherBudgets }" var="otherBudget">
								<tr>
									<td>${otherBudget.id }</td>
									<td>${otherBudget.total }</td>
									<td>${otherBudget.user.name}</td>
									<td><a
										href="${s:mvcUrl('BC#edit').arg(0,otherBudget.id).build() }"
										title="Editar" class="act-list act-edit">
											<button type="button" class="btn btn-primary">
												<i class="fa fa-edit" aria-hidden="true"></i>
											</button>
									</a> <a
										href="${s:mvcUrl('BC#delete').arg(0,otherBudget.id).build() }"
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

	<div class="modal fade" id="modalNewProductOrder" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Adicionar
						Produto</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form method="POST"
					action="${s:mvcUrl('BC#includeProduct').build() }">
					<div class="modal-body">
						<input type="hidden" name="idBudget" id="idBudget"
							value="${budget.id }">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="idProduct">Produto</label> <select name="idProduct"
										id="idProduct" class="form-control" required>
										<option disabled selected>Selecione..</option>
										<c:forEach items="${products }" var="product">
											<option value="${product.id}">${product.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="form-group">
									<label for="qtd">Quantidade</label> <input type="number"
										class="form-control" name="qtd" id="qtd" required>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="form-group">
									<label for="price">Preço Unitário</label> <input type="text"
										class="form-control" name="price" id="price" required>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-link" data-dismiss="modal">Fechar</button>
						<button type="submit" class="btn btn-primary">Salvar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<footer>

		<jsp:include page="../includes/footer.jsp" />
	</footer>
	<script type="text/javascript">
		$('#btnAdcProduct').click(function() {
			$('#modalNewProductOrder').modal('show');
		});
	</script>

</body>

</html>