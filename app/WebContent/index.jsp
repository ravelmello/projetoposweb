<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                  <h3 class="box-title">Cadastrar</h3>
                </div>
                
                <form role="form" action="./service.do?action=insert" method="post">
                  <div class="box-body">
                    <div class="form-group">
                      <label for="nome">Nome</label>
                      <input type="text" class="form-control" name="nome" placeholder="Nome">
                    </div>
                    <div class="form-group">
                      <label for="cpf">CPF</label>
                      <input type="text" class="form-control" name="cpf" placeholder="CPF">
                    </div>
                    <div class="form-group">
                      <label for="cep">CEP</label>
                      <input type="text" class="form-control" name="cep" placeholder="CEP">
                    </div>
                    <div class="form-group">
                      <label for="logradouro">Logradouro</label>
                      <input type="text" class="form-control" name="logradouro" placeholder="Logradouro">
                    </div>
                    <div class="form-group">
                      <label for="bairro">Bairro</label>
                      <input type="text" class="form-control" name="bairro" placeholder="Bairro">
                    </div>
                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                  </div>
                </form>
              </div>
             
      		</div>
      		
     	 </div>
     	 
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</html>