package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.Viagem;

public class ConsultaViagemPendentesLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession session = httpServletRequest.getSession();
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		ViagemDAO dao = new ViagemDAO(conexao);
		
		if(usuarioLogado.getTipo().getId() == 2){
			ArrayList<Viagem> viagensP = dao.viagemPendentes(usuarioLogado);
			
			httpServletRequest.setAttribute("viagens", viagensP);

			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemPendentesConsultaG.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}else if(usuarioLogado.getTipo().getId() == 1){
			ArrayList<Viagem> viagensP = dao.viagemPendentesAdm();
			
			httpServletRequest.setAttribute("viagens", viagensP);
			
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemPendentesConsultaA.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}
	}

}
