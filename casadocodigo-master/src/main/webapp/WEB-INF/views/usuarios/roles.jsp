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
			<td><form:form
					action="${s:mvcUrl('UC#salvaRoles').arg(0, usuario.nome).build() }"
					method="POST" commandName="usuario">

					<tr>
						<h1>Cadastro de Permissoes para ${nome}</h1>
					</tr>
					<p>${message}</p>


					<tr>Permissões:
					</tr>
					<div>
						<tr>
							<form:checkboxes path="roles" items="${listaRoles1}" />
						</tr>
					</div>
					<tr>
						<input type="submit" name="submit" value="Atualizar">
					</tr>


				</form:form></td>







		</div>
	</section>
</tags:pageTemplate>
