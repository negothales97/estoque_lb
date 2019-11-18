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
				<h1>Editar Pedido</h1>
			</div>
			<div class="col-sm-6">
				<button type="button" id="btnAdcProduct"
					class="btn btn-success float-right">
					<i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
		<form method="POST" action="${s:mvcUrl('BC#update').build() }">
			<input type="hidden" value="${budget.id }" name="id">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="user">Usuários</label> <select class="form-control"
							name="userId">
							<option>Selecione..</option>
							<c:forEach items="${users }" var="user">
								<option value="${user.id }" ${user.id == budget.user.id ? 'selected' : '' }>${user.name }</option>
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

	<div class="modal fade" id="modalNewProductOrder" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
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