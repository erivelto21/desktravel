package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.ViagemDAO;

public class RemoveViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		String idViagemRemoveS =  httpServletRequest.getParameter("idV");
		int idViagemRemove = Integer.parseInt(idViagemRemoveS);
		ViagemDAO dao = new ViagemDAO(conexao);
		
		dao.remove(idViagemRemove);
	}

}
