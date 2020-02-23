	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="<c:url value="/privado/menu.jsp" />">Desk Travel</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastro</span></a>
	        <ul class="dropdown-menu">
				<li><a href="<c:url value="/sistema?logica=PreparaCadastroUsuario" />">Cadastrar Usuario</a></li>
	        </ul>
	      </li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Viagem </span></a>
	      	<ul class="dropdown-menu">
				<li><a href='<c:url value="/sistema?logica=ConsultaViagemPendentes"/>'>Viagens pendentes</a></li>
				<li><a href='<c:url value="/sistema?logica=ConsultaViagemAtivas"/>'>Viagens aprovadas</a></li>
	        	<li><a href='<c:url value="/sistema?logica=ConsultaViagemConcluida"/>'>Viagens Concluida</a></li>
	        	<li><a href='<c:url value="/sistema?logica=ConsultaViagemNegada"/>'>Viagens Negadas</a></li>
	        </ul>
	      </li>
		  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Colaboradores </span></a>
	      	<ul class="dropdown-menu">
				<li><a href='<c:url value="/sistema?logica=ConsultaSubordinados"/>'>Listar</a></li>
				<li><a href='<c:url value="/sistema?logica=PreparaRemoveUsuario"/>'>Cancelar Usuario</a></li>
	        </ul>
	      </li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Relatorio </a>
	      	<ul class="dropdown-menu">
				<li><a href='<c:url value="/relatorio?tipo=Anual"/>'>Anual</a></li>
	        	<li class="dropdown-submenu">
	        		<a class="test" tabindex="-1" href="#">Mensal</a>
			        <ul class="dropdown-menu">
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=1"/>'>Janeiro</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=2"/>'>Fevereiro</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=3"/>'>Março</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=4"/>'>Abril</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=5"/>'>Maio</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=6"/>'>Junho</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=7"/>'>Julho</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=8"/>'>Agosto</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=9"/>'>Setembro</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=10"/>'>Outubro</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=11"/>'>Novembro</a></li>
			        	<li><a href='<c:url value="/relatorio?tipo=Mensal&mes=12"/>'>Dezembro</a></li>
			        </ul>
	      		</li>
	        </ul>
	      </li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
      		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>  ${usuarioLogado.nome} <span class="caret"></span></a>
	      		<ul class="dropdown-menu">
	      			<li><a href='<c:url value="/sistema?logica=PreparaProprioUsuarioAltera"/>'>Alterar Dados</a></li>
					<li><a href='<c:url value="/logoff"/>'>Sair</a></li>
	        	</ul>
	      </li>
    	</ul>
	  </div>
	</nav>