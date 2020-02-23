package br.com.desktravel.model.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoffLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.invalidate();
		httpServletResponse.sendRedirect("publico/login.jsp");
	}

}
