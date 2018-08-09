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
						<td>
						<form:form action="${s:mvcUrl('UC#roles').build()}">
					<input type="submit" value="Editar Roles" />
				</form:form>
						</td>

					</tr>
				</c:forEach>

			</table>
			<ul>
				<form:form action="${s:mvcUrl('UC#form').build()}">
					<input type="submit" value="Cadastro de Usuario" />
				</form:form>

			</ul>
		</div>
	</section>
</tags:pageTemplate>
