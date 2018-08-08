<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:pageTemplate
	titulo="Livros de Java, Android, iPhone, Ruby, PHP e muito mais ....">



	<section class="pedidos">
		<div class="container">
			<h1>Lista de Pedidos Atuais</h1>
			<p>${sucesso}</p>
			<p>${falha}</p>

			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>ID</th>
					<th>Valor</th>
					<th>Data Pedido</th>
					<th>Titulos</th>
				</tr>
				<c:forEach items="${pedidos }" var="pedidos">
<					<tr>
						<td>${pedidos.id }</td>
						<td>${pedidos.valor }</td>
						<td>${pedidos.data }</td>
						<td>${pedidos.produtos }</td>
					</tr>
				</c:forEach>


				<!-- 		<tr>
						<th>2154</th>
						<th>215,00</th>
						<th>2018-01-01</th>
						<th>muitos livros</th>
					</tr> -->

			</table>
		</div>
	</section>
</tags:pageTemplate>