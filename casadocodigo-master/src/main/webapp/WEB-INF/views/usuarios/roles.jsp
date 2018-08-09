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
			<h1>Cadastro de Permissoes</h1>
			<p>${sucesso}</p>
			<p>${falha}</p>
			<p>${message}</p>


			<tr>
			<c:forEach items="${listaRoles }" var="listaRoles">
					<tr>
						<td>${listaRoles.nome }</td>
						<td><input type="checkbox" name="finalizado" 
              value="true" ${listaRoles.nome} 'checked' : '' }/></td>
					</tr>
				</c:forEach>
              <tr></tr>
				
				<td><li class="btn btn-default"><span><a
							href="${s:mvcUrl('UC#listar').build()}">Atualizar</a></span></li></td>
			</tr>

		</div>
	</section>
</tags:pageTemplate>
