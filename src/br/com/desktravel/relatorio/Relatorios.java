package br.com.desktravel.relatorio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Relatorios {
	
	public void relatorio(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws Exception;

}
