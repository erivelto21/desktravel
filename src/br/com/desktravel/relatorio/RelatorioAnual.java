package br.com.desktravel.relatorio;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.factory.ConnectionFactory;
import br.com.desktravel.model.Relatorio;
import br.com.desktravel.model.Usuario;

public class RelatorioAnual implements Relatorios{

	@Override
	public void relatorio(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		Relatorio relatorio = new Relatorio(new ConnectionFactory().getConnection(), httpServletResponse);
		
		ServletContext contexto = httpServletRequest.getServletContext();
		
		Map<String, Object> parametros = new HashMap<>();
		
		if(usuario.getTipo().getId() == 2){
			String jrxml = contexto.getRealPath("/relatorios/AnualGestor.jrxml");
			parametros.put("gestor_id", usuario.getId());
			relatorio.gerarPdf(jrxml, parametros, httpServletResponse.getOutputStream());
			return;
		}
		
//		String jrxml = contexto.getRealPath("/relatorios/Anual.jrxml");
		String jrxml = contexto.getRealPath("/relatorios/AnualL.jrxml");
		
		relatorio.gerarPdf(jrxml, parametros, httpServletResponse.getOutputStream());
	}

}
