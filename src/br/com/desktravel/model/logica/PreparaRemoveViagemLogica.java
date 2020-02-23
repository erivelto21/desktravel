package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Usuario;

public class PreparaRemoveViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		ViagemDAO dao = new ViagemDAO(conexao);
		
		httpServletRequest.setAttribute("viagens", dao.viagensUsuario(usuario.getId()));
		
		RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/remove/viagemRemove.jsp");
		rd.forward(httpServletRequest, httpServletResponse);
	}

}
