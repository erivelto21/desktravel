package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.UsuarioDAO;
import br.com.desktravel.model.Usuario;

public class PreparaRemoveUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		UsuarioDAO dao = new UsuarioDAO(conexao);
		
		if(usuario.getTipo().getId() == 2){
			httpServletRequest.setAttribute("items", dao.subordinadosG(usuario.getId()));
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/remove/usuarioRemoveG.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}else if(usuario.getTipo().getId() == 1){
			httpServletRequest.setAttribute("items", dao.subordinadosA());
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/remove/usuarioRemoveA.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}
		
	}

}
