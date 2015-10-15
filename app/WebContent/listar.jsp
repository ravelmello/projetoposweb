<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="trabalho.unipe.entity.*" %>
<%@ page import="trabalho.unipe.persistence.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="bean" class="trabalho.unipe.manager.ManagerBean" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>
<body>
	<div class="container">
	
		<div class="row row-offcanvas row-offcanvas-left">
		
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			  <br/>
			  <div class="row">
		          <div class="list-group">
		            <a href="index.jsp" class="list-group-item active">Cadastrar</a>
		            <a href="listar.jsp" class="list-group-item">Listar</a>
		          </div>
	          </div>
	        </div>
	        
	        <div class="col-xs-12 col-sm-9">
          		
          		<br>
          		<% if(request.getAttribute("msg") != null) { %>
	          		<div class="alert alert-success"> 
	          			<button type="button" class="close" data-dismiss="alert">x</button>
	                  	<h4>Sucesso!</h4>
	                  		${msg}
	          		</div>
          		<% } %>
          		
          		<div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Lista de Pessoas</h3>
                </div>
                
                <table id="pessoaTable" class="table table-striped table-bordered">
		            <thead>
		                <tr>
		                    <th>Id</th>
		                    <th>Nome</th>
		                    <th>CPF</th>
		                    <th>CEP</th>
		                    <th>Opcoes</th>
		                </tr>
		            </thead>
		            <tbody>
		            	<c:forEach items="${bean.lista}" var="pessoa">
		            		<tr>
		            			<td> ${pessoa.id}   </td>
		            			<td> ${pessoa.nome} </td>
		            			<td> ${pessoa.cpf}  </td>
		            			<td> ${pessoa.cep}  </td>
		            			<td> 
		            				<a href="service.do?action=search&id=${pessoa.id}"> Alterar</a> / 
		            				<a href="service.do?action=delete&id=${pessoa.id}"> Deletar</a>
		            			 </td>
		            		</tr>
		            	</c:forEach>
		            </tbody>
		        </table>
              </div>
              
      		</div>
      		
     	 </div>
     	 
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function() {
        $('#pessoaTable').DataTable();
    } );
</html>