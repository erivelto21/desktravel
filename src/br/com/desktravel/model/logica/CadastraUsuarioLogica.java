package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.UsuarioDAO;
import br.com.desktravel.model.Tipo;
import br.com.desktravel.model.Usuario;

public class CadastraUsuarioLogica implements Logica{
	
	private String msgErro = "O seguinte erro foi encontrado: ";
	
	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {

		HttpSession session = httpServletRequest.getSession();
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuarioSuperior = (Usuario) session.getAttribute("usuarioLogado");
		Usuario usuario = new Usuario();
		
		String id = httpServletRequest.getParameter("cod_funcionario");
		String login = httpServletRequest.getParameter("login");
		String nome = httpServletRequest.getParameter("nome");
		String senha = httpServletRequest.getParameter("senha");
		String tipo = httpServletRequest.getParameter("tipo");
		String confirmarSenha = httpServletRequest.getParameter("senhaConfirmar");
		String email = httpServletRequest.getParameter("email");
		String telefone = httpServletRequest.getParameter("telefone");
		
		
		if(validaNullcamp(id, login, nome, senha, confirmarSenha, tipo, email, telefone)){
			httpServletRequest.setAttribute("cod_funcionario", id);
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("nome", nome);
			httpServletRequest.setAttribute("tipo", tipo);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroUsuario");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(validaT(login, nome, senha, telefone)){
			httpServletRequest.setAttribute("cod_funcionario", id);
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("nome", nome);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroUsuario");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		UsuarioDAO dao = new UsuarioDAO(conexao);
		
		int idU = Integer.parseInt(id);
		int tipoU = Integer.parseInt(tipo);
		
		if(validaE(idU, login, dao)){
			httpServletRequest.setAttribute("cod_funcionario", id);
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("nome", nome);
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroUsuario");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		usuario.setCod_funcionario(idU);
		usuario.setLogin(login);	
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setId_superior(usuarioSuperior.getId());
		usuario.setEmail(email);
		usuario.setTelefone(telefone);
		
		Tipo tipoO = new Tipo();
		
		tipoO.setId(tipoU);
	
		usuario.setTipo(tipoO);
		
//		if(!usuario.verificarNome()){
//			System.out.println("elo");
//			this.msgErro += "<br> - So letras sao permitidas no campo nome";
//			httpServletRequest.setAttribute("msgErro", this.msgErro);
//			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/cadastro/usuarioCadastro.jsp");
//			rd.forward(httpServletRequest, httpServletResponse);
//			return;
//		}
		
		if (isTelefone(telefone)) {
			this.msgErro += "O campo telefone estar com o formato invalido <br> Formato valido : (99) 9999-9999";
			httpServletRequest.setAttribute("cod_funcionario", id);
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("nome", nome);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroUsuario");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(verifaSenha(senha, confirmarSenha)){
			httpServletRequest.setAttribute("cod_funcionario", id);
			httpServletRequest.setAttribute("login", login);
			httpServletRequest.setAttribute("nome", nome);
			httpServletRequest.setAttribute("email", email);
			httpServletRequest.setAttribute("telefone", telefone);
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroUsuario");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(dao.adiciona(usuario)){
			httpServletResponse.sendRedirect("sistema?logica=PreparaCadastroUsuario");
			return;
		}
	}
	
	public boolean validaNullcamp(String id, String login, String nome, String senha, String confirmarSenha, String tipo, String email, String telefone){
		
		boolean camposNulos = false;
		
		if(id.trim().isEmpty() || id == null){
			camposNulos = true;
		}else if(login.trim().isEmpty() || login == null ){
			camposNulos = true;
		}else if(nome.trim().isEmpty() || nome == null){
			camposNulos = true;
		}else if(senha.trim().isEmpty() || senha == null){
			camposNulos = true;
		}else if(confirmarSenha.trim().isEmpty() || confirmarSenha == null){
			camposNulos = true;
		}else if(tipo.trim().isEmpty() || tipo == null){
			camposNulos = true;
		}else if(email.trim().isEmpty() || email == null){
			camposNulos = true;
		}else if(telefone.trim().isEmpty() || telefone == null){
			camposNulos = true;
		}
		
		if(camposNulos == true){
			this.msgErro += "<br> - Ha campo(s) nulo(s)";
			return true;
		}
		
		return false;
	}
	
	public boolean validaE(int id, String login, UsuarioDAO dao){
		if(dao.idExiste(id)){
			this.msgErro += "<br> - Esse id ja esta cadastrado";
			return true;
		}
		if(dao.loginExiste(login)){
			this.msgErro += "<br> - Esse login ja esta cadastrado";
			return true;
		}
		
		return false;
	}
	
	public boolean validaT(String login, String nome, String senha, String telefone){
		
		if(login.length() > 45 || login.length() < 4){
			this.msgErro += "<br> - O campo login não pode ter mais que 45 caracteres"
					+ "<br> - O campo login não pode ter menos que 4 caracteres";
			return true;
		}else if(nome.length() > 45 || nome.length() < 4){
			this.msgErro += "<br> - O campo nome não pode ter mais que 45 caracteres "
					+ "<br> O campo nome nao pode ter menos que 4 caracteres";
			return true;
		}else if(senha.length() > 45 || senha.length() < 4){
			this.msgErro += "<br> -  "
					+ "<br> - O campo login não pode ter mais que 45 caracteres "
					+ "<br> - O campo senha não pode ter menos que 4 caracteres";
			return true;
		}else if(telefone.length() < 10){
			this.msgErro += "<br> - O campo telefone não pode ter menos que 10 digitos";
			return true;
		}
		
		return false;
	}
	
	public boolean isTelefone(String numeroTelefone) {
		if(numeroTelefone.length() < 14 || numeroTelefone.length() > 14  ){
			return true;
		}
		
		for(int i = 0; i < numeroTelefone.length(); i++){
			
			if(verificaNumero(numeroTelefone.charAt(i)) || verificaCar(i, numeroTelefone.charAt(i))){
				
			}else{
				return true;
			}
		}
		return false;
	}
	
	public boolean verificaCar(int indice, char car){
		if(indice == 0 && car == '('){
			return true;
		}else if(indice == 3 && car == ')'){
			return true;
		}else if(indice == 4 && car == ' '){
			return true;
		}else if(indice == 9 && car == '-'){
			return true;
		}
		
		return false;
	}
	
	public boolean verificaNumero(char numero){
		char numeros [] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		for(char n : numeros){
			if(n == numero){
				return true;
			}
		}
		return false;
	}
	
	public boolean verifaSenha(String senha, String senha2){
		
		if(senha.equals(senha2)){
			return false;
		}else{
			this.msgErro += "<br> - As senhas estao diferentes";
			return true;
		}
	}
}
