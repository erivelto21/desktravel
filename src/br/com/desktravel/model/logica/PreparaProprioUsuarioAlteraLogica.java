package br.com.desktravel.model.logica;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.model.Usuario;

public class PreparaProprioUsuarioAlteraLogica implements Logica
{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		if(usuario.getTipo().getId() == 3){
			httpServletRequest.setAttribute("usuario", usuario);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioFuncionarioAltera.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}else if(usuario.getTipo().getId() == 2){
			httpServletRequest.setAttribute("usuario", usuario);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioUsuarioAlteraG.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}else if(usuario.getTipo().getId() == 1){
			httpServletRequest.setAttribute("usuario", usuario);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioUsuarioAlteraA.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}
	}

}
