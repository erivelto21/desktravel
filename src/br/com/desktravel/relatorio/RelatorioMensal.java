package br.com.desktravel.relatorio;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.factory.ConnectionFactory;
import br.com.desktravel.model.Relatorio;

public class RelatorioMensal implements Relatorios{

	@Override
	public void relatorio(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		String numeroMes = httpServletRequest.getParameter("mes");
		
		int mes = Integer.parseInt(numeroMes);
		
		Relatorio relatorio = new Relatorio(new ConnectionFactory().getConnection(), httpServletResponse);
		
		ServletContext contexto = httpServletRequest.getServletContext();
//		String jrxml = contexto.getRealPath("/relatorios/porMes.jrxml");
		String jrxml = contexto.getRealPath("/relatorios/porMesL.jrxml");
		
		Map<String, Object> parametros = new HashMap<>();
//		parametros.put("mes", mes);
		parametros.put("mes", mesS(mes));
		parametros.put("Nomes", mes(mes));
		relatorio.gerarPdf(jrxml, parametros, httpServletResponse.getOutputStream());
	}
	
	private String mes(int mes){
		switch(mes){
			case 1:
				return "Janeiro";
			case 2:
				return "Fevereiro";
			case 3:
				return "Março";
			case 4:
				return "Abril";
			case 5:
				return "Maio";
			case 6:
				return "Junho";
			case 7:
				return "Julho";
			case 8:
				return "Agosto";
			case 9:
				return "Setembro";
			case 10:
				return "Outubro";
			case 11:
				return "Novembro";
			case 12:
				return "Dezembro";
			default:
				return null;
		}
	}
	
	public String mesS(int mes){
		switch(mes){
		case 1:
			return "01";
		case 2:
			return "02";
		case 3:
			return "03";
		case 4:
			return "04";
		case 5:
			return "05";
		case 6:
			return "06";
		case 7:
			return "07";
		case 8:
			return "08";
		case 9:
			return "09";
		case 10:
			return "10";
		case 11:
			return "11";
		case 12:
			return "12";
		default:
			return null;
	}
	}
}
