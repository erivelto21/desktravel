package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.model.Relatorio;

public class RelatorioSubordinadoLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		ServletContext contexto = httpServletRequest.getServletContext();
		String jrxml = contexto.getRealPath("/relatorios/rep.jrxml");
        
        Map<String, Object> parametros = new HashMap<>();
	
		Relatorio relatorio = new Relatorio(conexao, httpServletResponse);
		relatorio.gerarPdf(jrxml, parametros, httpServletResponse.getOutputStream());
	}

}
