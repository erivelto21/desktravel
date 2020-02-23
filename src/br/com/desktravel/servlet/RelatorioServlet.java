package br.com.desktravel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.exception.DeskTravelServletException;
import br.com.desktravel.relatorio.RelatorioMensal;
import br.com.desktravel.relatorio.Relatorios;

@WebServlet("/relatorio")
public class RelatorioServlet extends HttpServlet{

	public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException{
			String tipo = httpServletRequest.getParameter("tipo");
			String nomeClasse = "br.com.desktravel.relatorio.Relatorio" + tipo;
			
			try {
				Class classe = Class.forName(nomeClasse);
				Object object = classe.newInstance();
				Relatorios relatorio = (Relatorios) object;
				relatorio.relatorio(httpServletRequest, httpServletResponse);
			} catch (Exception e) {
				throw new DeskTravelServletException(e.getMessage());
			}
	}
}
