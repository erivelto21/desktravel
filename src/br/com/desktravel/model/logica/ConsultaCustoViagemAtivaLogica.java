package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.Viagem;

public class ConsultaCustoViagemAtivaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		ViagemDAO dao = new ViagemDAO(conexao);
		
		Viagem viagem = dao.viagemAtivaGasto(usuario.getId());
		
		if(viagem == null){
			httpServletRequest.setAttribute("msg", "Não existe viagem ativa");
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/privado/menuFuncionario.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		httpServletRequest.setAttribute("viagem", viagem);
		
		RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/atualizarCustos.jsp");
		rd.forward(httpServletRequest, httpServletResponse);
	}

}
