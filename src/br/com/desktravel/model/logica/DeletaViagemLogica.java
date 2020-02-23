package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Viagem;

public class DeletaViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");

		String idV = httpServletRequest.getParameter("idV");
		int id = Integer.parseInt(idV);

		ViagemDAO dao = new ViagemDAO(conexao);
		
		Viagem viagem = dao.viagem(id);
		
		if(viagem.getPendente() == true){
			dao.remove(viagem.getId());
		}

		httpServletResponse.sendRedirect("sistema?logica=ConsultaViagemPendentesPropria");
	}

}
