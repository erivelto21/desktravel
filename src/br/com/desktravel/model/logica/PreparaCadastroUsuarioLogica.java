package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.PreparaDAO;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.UsuarioTipo;

public class PreparaCadastroUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		PreparaDAO dao = new PreparaDAO(conexao);
		
		httpSession.setAttribute("usuarioTipo", tiposUsuario(dao, usuario));
		
		if(usuario.getTipo().getId() == 1){
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/privado/cadastro/usuarioCadastroA.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}else if(usuario.getTipo().getId() == 2){
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/privado/cadastro/usuarioCadastroG.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
		}
	}
	
	public ArrayList<UsuarioTipo> tiposUsuario(PreparaDAO dao, Usuario usuario){
		ArrayList<UsuarioTipo> tipo = dao.getUsuarioTipo();
		ArrayList<UsuarioTipo> tipo1 = new ArrayList<UsuarioTipo>();
		
		for(UsuarioTipo t : tipo){
			if(t.getId() > usuario.getTipo().getId()){
				tipo1.add(t);
			}
		}
		return tipo1;
	}

}
