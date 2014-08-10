<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Importações das TAGs do Struts -->
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Contatos</title>
<script type="text/javascript">
	/* Função generica que nos permite submeter o formulário 
	   com nomes de métodos dinâmicos que deverão ser executados
	   na action. */
	function executar(metodoExecutar) {
		document.getElementById("form_contato").acao.value = metodoExecutar;
		document.getElementById("form_contato").submit();
	}
</script>

<style type="text/css">
body {
	margin: 0 auto;
	padding: 0 auto;
	text-align: center;
	background-image: url("imagens/wooden-background.jpg");
}

.center {
	width:700px;
	margin: 0 auto;
	padding: 0 auto;
	margin-top:7px;
	text-align:left;
	 background-color:white;
}

#tabela {
	background: #E1E1E1;
}

#tabela table {
	border-collapse: collapse;
}

#tabela table,td,th {
	border: 1px solid black;
	padding: 5px;
}

</style>
</head>
<body>
	<html:form styleId="form_contato" action="contatoAction.src">
		<html:hidden property="acao" value="empty" />

		<!-- Mensagens Informativas -->
		<div class="ui-widget" style="text-align: center;">
			<logic:messagesPresent message="true">
				<html:messages id="message" message="true">
					<div class="ui-state-highlight ui-corner-all"
						style="padding: 0 .7em; border: 1px solid #FFA1A1; background: #C0C0C0; color: #363636; width: 500px; margin: 0 auto;">
						<p>
							<b><bean:write filter="false" name="message" /></b>
						</p>
					</div>
				</html:messages>
			</logic:messagesPresent>
		</div>

		<table class="center" id="td-inicio">
			<tr>
				<td style="background-color: #ccc" colspan="2">
					<h3>Contato</h3>
				</td>
			</tr>
			<tr>
				<td><label>ID</label></td>
				<td><html:text property="id" name="contatoForm"
						style="width: 85px; background-color:#E8E8E8" readonly="true" /></td>
			</tr>
			<tr>
				<td><label>Codigo</label></td>
				<td><html:text property="codigo" name="contatoForm"
						style="width: 85px;" /></td>
			</tr>
			<tr>
				<td><label>Nome</label></td>
				<td><html:text property="nome" name="contatoForm"
						style="width: 200px;" /></td>
			</tr>
			<tr>
				<td><label>Sobrenome</label></td>
				<td><html:text property="sobrenome" name="contatoForm"
						style="width: 200px;" /></td>
			</tr>
			<tr>
				<td><label>Data de Nascimento</label></td>
				<td><html:text property="dataNascimento" name="contatoForm"
						style="width: 100px;" /></td>
			</tr>
			<tr>
				<td><label>E-mail</label></td>
				<td><html:text property="email" name="contatoForm"
						style="width: 200px;" /></td>
			</tr>
			<tr>
				<td><label>Observações</label></td>
				<td><html:textarea rows="3" cols="300" property="observacao"
						name="contatoForm" style="width: 300px;" /></td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="button" onclick="executar('inserir')">Salvar</button>

					<button type="button" onclick="executar('alterar')">Alterar</button>

					<button type="button" onclick="executar('filtrar')">Filtrar</button>

					<button type="button" onclick="executar('excluir')">Excluir</button>

					<button type="button" onclick="executar('limpar')">Limpar</button>


				</td>
			</tr>
		</table>
	</html:form>
	<!-- TABELA DE CONSULTA -->
	<!-- Criando a tabela onde serão exibidos os dados -->
	<table class="center" >
		<tr style="background-color: #ccc">
			<td>ID</td>
			<td>Código</td>
			<td>Nome</td>
			<td>Sobrenome</td>
			<td>Nascimento</td>
			<td>E-mail</td>
			<td>Observações</td>
			<td>Ação</td>

		</tr>
		<!--id="contatoCorrente" = Objeto corrente da lista assim como o lista[i] no for convencional 
        name="contatoForm" = Nome mapeado para a classe FORM que contém o atributo do tipo lista com o nome igual ao indicado no "property" 
        property="contatos" = Nome do atributo do tipo lista que desejamos percorrer. 
        type="br.com.src.contatostruts.contato.model.ContatoPO" = Tipo dos objetos que estão na lista. -->
		<logic:iterate indexId="i" id="contatoCorrente" name="contatoForm"
			property="contatos"
			type="br.com.src.agendastruts.agenda.contato.model.ContatoPO">
			<tr>
				<td>${contatoCorrente.id}</td>
				<td>${contatoCorrente.codigo}</td>
				<td>${contatoCorrente.nome}</td>
				<td>${contatoCorrente.sobrenome}</td>
				<td>${contatoCorrente.dataNascimento}</td>
				<td>${contatoCorrente.email}</td>
				<td>${contatoCorrente.observacao}</td>
				<td><a
					href="contatoAction.src?acao=selecionar&id=${contatoCorrente.id}">
						<img alt="Selecionar" src="imagens/upload-icon.png">
				</a></td>
			</tr>
		</logic:iterate>

	</table>


</body>
</html:html>