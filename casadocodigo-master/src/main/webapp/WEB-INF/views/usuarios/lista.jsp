<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate
	titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">
	<section>
		<div class="container">
			<h1>Lista de Usuarios</h1>
			<p>${sucesso}</p>
			<p>${falha}</p>
			<p>${message}</p>

			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Roles</th>
					<th></th>
				</tr>
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td>${usuario.email }</td>
						<td>${usuario.roles }</td>

						<td><form:form
								action="${s:mvcUrl('UC#editaRoles').arg(0, usuario.nome).build() }"
								method="POST">
								<input type="image"
									src="${contextPath }resources/imagens/editar.png" alt="Edit"
									title="Editar" />
							</form:form></td>
					</tr>
				</c:forEach>

			</table>
			<ul>
				<td><li class="btn btn-default"><span><a
							href="${s:mvcUrl('UC#form').build()}">Cadastro de Usuario</a></span></li></td>

				</td>
				</li>
			</ul>
		</div>
	</section>
</tags:pageTemplate>
