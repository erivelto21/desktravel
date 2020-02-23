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

public class ConsultaViagemConcluidaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		
		ViagemDAO dao = new ViagemDAO(conexao);
		
		if(usuario.getTipo().getId() == 2){
			ArrayList<Viagem> vv = dao.concluida(usuario.getId());
			httpServletRequest.setAttribute("viagens", vv);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemAtivaConsultaG.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}else if(usuario.getTipo().getId() == 1){
			ArrayList<Viagem> vv = dao.concluidaAdm();
			httpServletRequest.setAttribute("viagens", vv);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/consulta/viagemConcluidaConsultaA.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}
	}
}
