package br.com.desktravel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import br.com.desktravel.adaptadores.AdaptadorUsuario;
import br.com.desktravel.adaptadores.AdaptadorViagem;
import br.com.desktravel.model.Tipo;
import br.com.desktravel.model.Usuario;
/*
public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Usuario autentica(String login, String senha){
		String sql = "select * from usuario join usuario_tipo on usuario.tipo = usuario_tipo.id and (usuario.login = ? and usuario.senha = ?);";
		
		Usuario usuario = null;
		
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, senha);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				String idU = rs.getString("id");
				String nomeU = rs.getString("nome");
				String loginU = rs.getString("login");
				String senhaU = rs.getString("senha");
				String tipoId = rs.getString("tipo");
				String tipoNome = rs.getString("genero");
				String idS = rs.getString("id_superior");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				int tipo = Integer.parseInt(tipoId);
				int id = Integer.parseInt(idU);
				int idSuperior = Integer.parseInt(idS);
				
				Tipo tipoO = new Tipo();
				tipoO.setId(tipo);
				tipoO.setGenero(tipoNome);
				
				usuario = new Usuario();
				usuario.setId(id);
				usuario.setLogin(loginU);
				usuario.setNome(nomeU);
				usuario.setSenha(senhaU);
				usuario.setTipo(tipoO);
				usuario.setId_superior(idSuperior);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
			}
			
			rs.close();
			pstm.close();
			
			return usuario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public boolean adiciona(Usuario usuario){
		String sql = "insert into usuario(login, nome, senha, tipo, cod_funcionario, id_superior, email, telefone) values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getNome());
			pstm.setString(3, usuario.getSenha());
			pstm.setInt(4, usuario.getTipo().getId());
			pstm.setInt(5, usuario.getCod_funcionario());
			pstm.setInt(6, usuario.getId_superior());
			pstm.setString(7, usuario.getEmail());
			pstm.setString(8, usuario.getTelefone());
			
			pstm.execute();
			pstm.close();
			
			return true;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Usuario usuario(int id){
		String sql = "select * from usuario join usuario_tipo where usuario.id = ? and usuario.tipo = usuario_tipo.id;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Usuario usuario = new Usuario();
			
			while(rs.next()){
				String idU = rs.getString("id");
				String loginU = rs.getString("login");
				String senhaU = rs.getString("senha");
				String nome = rs.getString("nome");
				String tipoId = rs.getString("tipo");
				String tipoNome = rs.getString("genero");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				int tipo = Integer.parseInt(tipoId);
				int idC = Integer.parseInt(idU);
				
				Tipo tipoO = new Tipo();
				tipoO.setId(tipo);
				tipoO.setGenero(tipoNome);
				
				usuario = new Usuario();
				usuario.setId(idC);
				usuario.setLogin(loginU);
				usuario.setSenha(senhaU);
				usuario.setNome(nome);
				usuario.setTipo(tipoO);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
				
			}
			
			rs.close();
			pstm.close();
			
			return usuario;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Usuario> subordinadosA(){
		String sql = "select * from usuario where tipo = 2 or tipo = 3;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			while(rs.next()){
				int  id = rs.getInt("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				int cod_funcionario = rs.getInt("cod_funcionario");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				Usuario usuario = new Usuario();
				
				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setNome(nome);
				usuario.setCod_funcionario(cod_funcionario);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
				
				usuarios.add(usuario);
			}
			
			rs.close();
			pstm.close();
			
			return usuarios;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Usuario> subordinadosG(int idS){
		String sql = "select * from usuario where id_superior = ? ;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idS);
			
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			while(rs.next()){
				int  id = rs.getInt("id");
				String login = rs.getString("login");
				String nome = rs.getString("nome");
				int cod_funcionario = rs.getInt("cod_funcionario");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				Usuario usuario = new Usuario();
				
				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setNome(nome);
				usuario.setCod_funcionario(cod_funcionario);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
				
				usuarios.add(usuario);
			}
			
			rs.close();
			pstm.close();
			
			return usuarios;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		String sql="delete from usuario where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(Usuario usuario){
		
		String sql = "update usuario set login = ?, senha = ?, email = ?, telefone = ? where id = ?";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getTelefone());
			pstm.setInt(5, usuario.getId());
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean loginExiste(String login){
		String sql = "select * from usuario where login = ?";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, login);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				return true;
			}
			
			return false;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean idExiste(int id){
		String sql = "select * from usuario where cod_funcionario = ?";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				return true;
			}
			
			return false;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
*/

public class UsuarioDAO {
	
	private Connection conexao;
	
	public UsuarioDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Usuario autentica(String login, String senha){
		
//		try {
//			PreparedStatement pstm = conexao.prepareStatement("select * from viagens");
////			pstm.execute();
//						ResultSet rs = pstm.executeQuery();
//
//			while(rs.next()){
//				System.out.print(rs.getString("situacao"));
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return null;
		String sql = "select * from funcionarios where usuario = ? and senha = ?;";
		
		Usuario usuario = null;
		
		try {
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, senha);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				String idU = rs.getString("id");
				String nomeU = rs.getString("nome");
				String loginU = rs.getString("usuario");
				String senhaU = rs.getString("senha");
				String tipo_funcionario = rs.getString("tipo_funcionario");
				String idS = rs.getString("id_gestor");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				int id = Integer.parseInt(idU);
				int idSuperior = Integer.parseInt(idS);
				
				usuario = new Usuario();
				usuario.setId(id);
				usuario.setLogin(loginU);
				usuario.setNome(nomeU);
				usuario.setSenha(senhaU);
				usuario.setTipo(AdaptadorUsuario.getTipoUsuario(tipo_funcionario));
				usuario.setId_superior(idSuperior);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
			}
			
			rs.close();
			pstm.close();
			
			return usuario;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public boolean adiciona(Usuario usuario){
		String sql = "insert into funcionarios(usuario, nome, senha, tipo_funcionario, id_gestor, email, telefone) values (?, ?, ?, ?, ?, ?, ?);";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getNome());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, AdaptadorUsuario.getTipo_funcionario(usuario.getTipo()));
			pstm.setInt(5, usuario.getId_superior());
			pstm.setString(6, usuario.getEmail());
			pstm.setString(7, usuario.getTelefone());
			
			pstm.execute();
			pstm.close();
			
			return true;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	
	public Usuario usuario(int id){
		String sql = "select * from funcionarios where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Usuario usuario = new Usuario();
			
			while(rs.next()){
				int idU = rs.getInt("id");
				String loginU = rs.getString("usuario");
				String senhaU = rs.getString("senha");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo_funcionario");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				usuario = new Usuario();
				usuario.setId(idU);
				usuario.setLogin(loginU);
				usuario.setSenha(senhaU);
				usuario.setNome(nome);
				usuario.setTipo(AdaptadorUsuario.getTipoUsuario(tipo));
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
				
			}
			
			rs.close();
			pstm.close();
			
			return usuario;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Usuario> subordinadosA(){
		String sql = "select * from funcionarios where tipo_funcionario = ? or tipo_funcionario = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, "Gestor");
			pstm.setString(2, "Colaborador");
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			while(rs.next()){
				int  id = rs.getInt("id");
				String login = rs.getString("usuario");
				String nome = rs.getString("nome");
//				int cod_funcionario = rs.getInt("cod_funcionario");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				Usuario usuario = new Usuario();
				
				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setNome(nome);
//				usuario.setCod_funcionario(cod_funcionario);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
				
				usuarios.add(usuario);
			}
			
			rs.close();
			pstm.close();
			
			return usuarios;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Usuario> subordinadosG(int idS){
		String sql = "select * from funcionarios where id_gestor = ? ;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idS);
			
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			
			while(rs.next()){
				int  id = rs.getInt("id");
				String login = rs.getString("usuario");
				String nome = rs.getString("nome");
//				int cod_funcionario = rs.getInt("cod_funcionario");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				
				Usuario usuario = new Usuario();
				
				usuario.setId(id);
				usuario.setLogin(login);
				usuario.setNome(nome);
				usuario.setEmail(email);
				usuario.setTelefone(telefone);
//				usuario.setCod_funcionario(cod_funcionario);
				
				usuarios.add(usuario);
			}
			
			rs.close();
			pstm.close();
			
			return usuarios;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		String sql="delete from funcionarios where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(Usuario usuario){
		
		String sql = "update funcionarios set usuario = ?, senha = ?, email = ?, telefone = ? where id = ?";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getTelefone());
			pstm.setInt(5, usuario.getId());
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean loginExiste(String login){
		String sql = "select * from funcionarios where usuario = ?";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setString(1, login);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				return true;
			}
			
			return false;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean idExiste(int id){
//		String sql = "select * from funcionarios where cod_funcionario = ?";
//		
//		try{
//			PreparedStatement pstm = conexao.prepareStatement(sql);
//			pstm.setInt(1, id);
//			
//			ResultSet rs = pstm.executeQuery();
//			
//			while(rs.next()){
//				return true;
//			}
//			
//			return false;
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
		return false;
	}
}
