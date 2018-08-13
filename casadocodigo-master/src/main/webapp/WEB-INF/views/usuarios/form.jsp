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
				<h1>Cadastro de Usuarios</h1>
				<form:form action="${s:mvcUrl('UC#gravarUsuario').build() }"
					method="post" commandName="usuario" enctype="multipart/form-data">
					<p>${message}</p>
					<div class="form-group">
						<label>E-mail</label>
						<form:input path="email" cssClass="form-control"
							style="min-width:100%" />
						<form:errors path="email" />
					</div>
					<div class="form-group">
						<label>Nome</label>
						<form:input path="nome" cssClass="form-control"
							style="min-width:100%" />
						<form:errors path="nome" />
					</div>
					<div class="form-group">
						<label>Senha</label>
						<form:input path="senha" cssClass="form-control"
							style="min-width:100%" />
						<form:errors path="senha" />
					</div>
					<div class="form-group">
						<label>Confirme a Senha</label>
						<form:input path="senha2" cssClass="form-control"
							style="min-width:100%" />
						<form:errors path="senha2" />
					</div>

					<button type="submit" class="btn btn-primary"
						style="min-width: 25%">Cadastrar</button>
				</form:form>
			</div>
		

	</section>


</tags:pageTemplate>