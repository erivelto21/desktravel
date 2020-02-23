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

public class ConsultaViagemNegadaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
	
		ViagemDAO dao = new ViagemDAO(conexao);
		
		ArrayList<Viagem> viagens = new ArrayList<Viagem>();
		
		if(usuario.getTipo().getId() == 2){
			viagens = dao.viagensNegadasG(usuario.getId());
			httpServletRequest.setAttribute("viagens", viagens);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemNegadaConsultaG.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}else if(usuario.getTipo().getId() == 1){
			viagens = dao.viagensNegadasA();
			httpServletRequest.setAttribute("viagens", viagens);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemNegadaConsultaA.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
	}

}
