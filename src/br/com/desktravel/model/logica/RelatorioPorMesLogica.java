package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import br.com.desktravel.model.Relatorio;
//import br.com.desktravel.model.Usuario;

public class RelatorioPorMesLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
//		HttpSession httpSession = httpServletRequest.getSession();
//		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
//		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
//		
//		String mesS = httpServletRequest.getParameter("mes");
//		
//		int mes = Integer.parseInt(mesS);
		
		Relatorio relatorio = new Relatorio(conexao, httpServletResponse);
		
		ServletContext contexto = httpServletRequest.getServletContext();
		String jrxml = contexto.getRealPath("/relatorios/porMes.jrxml");
		
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("mes", 5);
		parametros.put("Nomes", "Maio");
		relatorio.gerarPdf(jrxml, parametros, httpServletResponse.getOutputStream());
	}

}
