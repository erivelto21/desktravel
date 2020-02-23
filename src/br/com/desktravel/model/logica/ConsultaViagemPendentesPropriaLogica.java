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

public class ConsultaViagemPendentesPropriaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		HttpSession session = httpServletRequest.getSession();
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
		ViagemDAO dao = new ViagemDAO(conexao);
		
		ArrayList<Viagem> viagensP = dao.viagemPendentesP(usuarioLogado);
		
		httpServletRequest.setAttribute("viagens", viagensP);

		RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemPendentesPropriasConsulta.jsp");
		rd.forward(httpServletRequest, httpServletResponse);	
	}

}
