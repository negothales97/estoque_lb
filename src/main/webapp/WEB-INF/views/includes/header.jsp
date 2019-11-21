<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a
				class="nav-link ${pageName =='category' ? 'active' : ''}"
				href="${s:mvcUrl('CC#index').build() }">Categorias</a></li>
			<li class="nav-item"><a
				class="nav-link ${pageName =='product' ? 'active' : ''}"
				href="${s:mvcUrl('PC#index').build() }">Produtos</a></li>
			<li class="nav-item"><a
				class="nav-link ${pageName =='user' ? 'active' : ''}"
				href="${s:mvcUrl('UC#index').build() }">Usuarios</a></li>
			<li class="nav-item"><a
				class="nav-link ${pageName =='budget' ? 'active' : ''}"
				href="${s:mvcUrl('BC#index').build()}">Pedidos</a></li>
		</ul>
	</div>
</div>
<c:if test="${success != null}">
<section class="content-header" style="padding-top:20px;">
	<!-- Main row -->
	<div class="row">
		<!-- Left col -->
		<section class="col-sm-12">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">&times;</button>
				${success }
			</div>
		</section>
	</div>
</section>
</c:if>