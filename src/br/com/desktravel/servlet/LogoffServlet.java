package br.com.desktravel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoff")
public class LogoffServlet extends HttpServlet{
	
	public void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) 
	throws ServletException, IOException{
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.invalidate();
		httpServletResponse.sendRedirect("publico/login.jsp");
	}
}
