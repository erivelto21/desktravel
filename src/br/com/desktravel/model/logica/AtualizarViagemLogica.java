package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Status;
import br.com.desktravel.model.Viagem;

public class AtualizarViagemLogica implements Logica{
	
	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		String trabalhoV = httpServletRequest.getParameter("motivo");
		String statusV = httpServletRequest.getParameter("status");
		String idV = httpServletRequest.getParameter("idV");
	
		if(trabalhoV.equals("")){
			httpServletResponse.sendRedirect("sistema?logica=ConsultaViagemAtiva");
			return;
		}
		
		if(statusV.equals("Status.emProgresso")){
			String msgErro = "- Não foi possivel atualizar o Status, pois ele ja estar em progresso ";
			httpServletRequest.setAttribute("msgErro", msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=ConsultaViagemAtiva");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}

		Status status = Status.valueOf(statusV);
		
		int viagem = Integer.parseInt(idV);
		
		ViagemDAO dao = new ViagemDAO(conexao);
		
		dao.atualizarStatus(viagem ,status);	
		
//		conclui(viagem, conexao);
		httpServletResponse.sendRedirect("sistema?logica=ConsultaViagemAtiva");
	}
	
//	public void conclui(int id, Connection conexao){
//		ViagemDAO dao = new ViagemDAO(conexao);
//		Viagem viagem = dao.viagem(id);
//		
//		boolean aux = true;
//		
//		if(viagem.getMotivoStatus() == Status.concluiu || viagem.getMotivoStatus() == Status.falhou){
//			
//		}else{
//			aux = false;
//		}
//		
//		if(aux == true){
//			
//		}
//	}

}
