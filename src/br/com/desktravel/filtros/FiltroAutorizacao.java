package br.com.desktravel.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.desktravel.model.Usuario;

@WebFilter(filterName="FiltroAutorizacao", urlPatterns="/*")
public class FiltroAutorizacao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String uri  = request.getRequestURI();
		String logica = request.getParameter("logica");
	
		if(logica == null){
			logica = "";
		}
		
		if(uri.endsWith("login.jsp") || logica.endsWith("AutenticaUsuario") || uri.endsWith(".css") || uri.endsWith(".js")){
			chain.doFilter(servletRequest, servletResponse);
		}else{
			Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
			if(usuarioLogado != null){
				chain.doFilter(servletRequest, servletResponse);
			}else{
				servletRequest.setAttribute("msgErro", "Sem autorização");
				RequestDispatcher rd = request.getRequestDispatcher("/publico/login.jsp");
				rd.forward(servletRequest, servletResponse);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
