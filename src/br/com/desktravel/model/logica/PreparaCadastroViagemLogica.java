package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.PreparaDAO;

public class PreparaCadastroViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		PreparaDAO dao = new PreparaDAO(conexao);
		
		String estado = httpServletRequest.getParameter("idEstado");

		httpServletRequest.setAttribute("estados", dao.getEstados());
		
		
		if(estado != null){
			if(estado.equals("limpar")){
				
			}else{
				int id = Integer.parseInt(estado);
				httpServletRequest.setAttribute("cidades", dao.getCidades(id));
				httpServletRequest.setAttribute("estado", id);
			}
		}
		
		RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/cadastro/viagemCadastro.jsp");
		rd.forward(httpServletRequest, httpServletResponse);
		
	}

}
