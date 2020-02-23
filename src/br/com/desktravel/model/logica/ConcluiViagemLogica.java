package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Status;
import br.com.desktravel.model.Viagem;

public class ConcluiViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		String viagemId = httpServletRequest.getParameter("idV");
		
		int id = Integer.parseInt(viagemId);
		
		ViagemDAO dao = new ViagemDAO(conexao);
//		Viagem viagem = dao.viagem(id);
		
//		if(verificar(viagem.getMotivoStatus())){
//			httpServletRequest.setAttribute("msgErro", "A trabalhos a serem concluidos");
//			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/sistema?logica=ConsultaViagemAtiva");
//			rd.forward(httpServletRequest, httpServletResponse);
//			return;
//		}else{
			dao.viagemConclui(id);
			httpServletResponse.sendRedirect("privado/menuFuncionario.jsp");
			return;
//		}
		
	}
	
	public boolean verificar(Status status){
		if(status == Status.Progresso){
			return true;
		}
		
		return false;
	}
}
