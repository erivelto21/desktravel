package br.com.desktravel.model.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
}
