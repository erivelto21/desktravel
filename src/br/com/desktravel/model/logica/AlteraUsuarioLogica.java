package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.UsuarioDAO;
import br.com.desktravel.model.Usuario;

public class AlteraUsuarioLogica implements Logica{

	private String msgErro = "O seguinte erro foi encontrado: ";
	
	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession httpSession = httpServletRequest.getSession();
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		UsuarioDAO dao = new UsuarioDAO(conexao);
		
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		
		String login = httpServletRequest.getParameter("login");
		String senhaAntiga = httpServletRequest.getParameter("senhaAntiga");
		String senha = httpServletRequest.getParameter("senhaNova");
		String senha2 = httpServletRequest.getParameter("senhaNovaConfi");
		String email = httpServletRequest.getParameter("email");
		String telefone = httpServletRequest.getParameter("telefone");
		
		if (verificaSenha(usuario, senhaAntiga)) {
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioUsuarioAltera.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(validaSenha(senha, senha2)){
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioUsuarioAltera.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(validaCampos(usuario, login, email, telefone)){
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioUsuarioAltera.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if (verificaMudanca(usuario, login, email, telefone, senha2)) {
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/proprioUsuarioAltera.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(geraSenha(senha).equals("")){
			
		}else{
			usuario.setSenha(senha);
		}
		
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setTelefone(telefone);
		
		dao.atualiza(usuario);
		new LogoffLogica().executa(httpServletRequest, httpServletResponse);
	}
	
	public boolean validaCampos(Usuario usuario, String login, String email, String telefone){
		
		if(login.trim().isEmpty() || login == null ){
			this.msgErro += "<br> - Ha campo(s) nulo(s)";
			return true;
		}else{
			if(login.length() > 45 || login.length() < 4){
				this.msgErro += "<br> - O campo login não pode ter mais que 45 caracteres"
						+ "<br> - O campo login não pode ter menos que 4 caracteres";
				return true;
			}else{
				
			}
		}
			
		if(email.trim().isEmpty() || email == null){
			this.msgErro += "<br> - Ha campo(s) nulo(s)";
			return true;
		}else{
			if(email.length() > 250){
				this.msgErro += "<br> - O campo email não pode ter mais que 250 caracteres";
			}else{
				
			}
		}
		
		
		if(telefone.trim().isEmpty() || telefone == null){
			this.msgErro += "<br> - Ha campo(s) nulo(s)";
			return true;
		}else{
			if(telefone.length() < 10){
				this.msgErro += "<br> - O campo telefone não pode ter menos que 10 digitos";
				return true;
			}
		}
		
		return false;
	}
	
	public boolean verificaSenha(Usuario usuario, String senha){
		
		if(usuario.getSenha().equals(senha)){
			return false;
		}else{
			this.msgErro += "<br> A senha esta errada";
			return true;
		}
		
	}
	
	public boolean validaSenha(String novaSenha, String cNovaSenha){
		
		if(novaSenha.trim().isEmpty() || novaSenha == null){
			return false;
		}else{
			if(novaSenha.length() > 45 || novaSenha.length() < 4){
				this.msgErro += "<br> - O campo login não pode ter mais que 45 caracteres "
						+ "<br> - O campo senha não pode ter menos que 4 caracteres";
				return true;
			}else{
				if(novaSenha.equals(cNovaSenha)){
					return false;
				}else{
					this.msgErro +="<br> - As senhas não estao iguais";
					return true;
				}
			}
		}
	}
	
	public boolean verificaMudanca(Usuario usuario, String login, String email, String telefone, String senha){
		
		if(usuario.getLogin().equals(login) && usuario.getEmail().equals(email) && usuario.getTelefone().equals(telefone) && usuario.getSenha().equals(senha)){
			this.msgErro = "Nada alterado";
			return true;
		}else if(usuario.getLogin().equals(login) && usuario.getEmail().equals(email) && usuario.getTelefone().equals(telefone) && senha.equals("")){
			this.msgErro = "Nada alterado";
			return true;
		}
		
		return false;
	}
	
public String geraSenha(String senha){
		
		if(senha.trim().isEmpty() || senha == null){
			return "";
		}else{
			return senha;
		}
	}
}
