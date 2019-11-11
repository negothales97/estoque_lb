<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="row">
	<div class="col-sm-12">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				href="${s:mvcUrl('CC#index').build() }">Categorias</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${s:mvcUrl('PC#index').build() }">Produtos</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${s:mvcUrl('UC#index').build() }">Usuários</a></li>
			<!-- <li class="nav-item"><a class="nav-link"
				href="${s:mvcUrl('OC#index').build()}">Novo Pedido</a></li> -->
		</ul>
	</div>
</div>