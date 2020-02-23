package br.com.desktravel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.exception.DeskTravelServletException;
import br.com.desktravel.model.logica.Logica;

@WebServlet("/sistema")
public class SistemaServlet extends HttpServlet{
	
	public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	throws ServletException, IOException{
		String acao = httpServletRequest.getParameter("logica");
		System.out.println(acao);
		String nomeClasse = "br.com.desktravel.model.logica." + acao + "Logica";
		try {
			Class classe = Class.forName(nomeClasse);
			Object obj = classe.newInstance();
			Logica logica = (Logica) obj;
			logica.executa(httpServletRequest, httpServletResponse);
		} catch (ClassNotFoundException e) {
			throw new DeskTravelServletException(e.getMessage());
		} catch (InstantiationException e) {
			throw new DeskTravelServletException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new DeskTravelServletException(e.getMessage());
		} catch (Exception e) {
			throw new DeskTravelServletException(e.getMessage());
		}
		
	}
}
