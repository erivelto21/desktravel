package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.UsuarioDAO;
import br.com.desktravel.model.Usuario;

public class AutenticaUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		Usuario usuarioAutenticado = null;
		
		String login = httpServletRequest.getParameter("login");
		String senha = httpServletRequest.getParameter("senha");
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		UsuarioDAO dao = new UsuarioDAO(conexao);
		
		usuarioAutenticado = dao.autentica(login, senha);
		
		if(usuarioAutenticado != null){	
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			httpServletRequest.setAttribute("usuario", usuarioAutenticado.getLogin());
			
			if(usuarioAutenticado.getTipo().getId() == 1){
				httpServletResponse.sendRedirect("privado/menuAdm.jsp");
			}else if(usuarioAutenticado.getTipo().getId() == 2){
				httpServletResponse.sendRedirect("privado/menu.jsp");
			}else if(usuarioAutenticado.getTipo().getId() == 3){
				httpServletResponse.sendRedirect("privado/menuFuncionario.jsp");
			}
		}else{
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/publico/login.jsp");
			httpServletRequest.setAttribute("msgErro", "usuario/senha invalidos");
			rd.forward(httpServletRequest, httpServletResponse);
		}
	}
	
}
