package br.com.desktravel.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.model.Usuario;

@WebFilter(filterName="FiltroLogin", urlPatterns="/publico/login.jsp")
public class FiltroLogin implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpSession httpSession = httpServletRequest.getSession();
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

		if(usuario != null){
			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

			if(usuario.getId() == 1){
				httpServletResponse.sendRedirect("/dT/privado/menuAdm.jsp");
			}else if(usuario.getTipo().getId() == 2){
				httpServletResponse.sendRedirect("/dT/privado/menu.jsp");
			}else if(usuario.getTipo().getId() == 3){
				httpServletResponse.sendRedirect("/dT/privado/menuFuncionario.jsp");
			}
		}else{
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
