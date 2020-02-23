package br.com.desktravel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.desktravel.model.Cidade;
import br.com.desktravel.model.Endereco;
import br.com.desktravel.model.Estado;
/*
public class EnderecoDAO {
	
	private Connection conexao;
	
	public EnderecoDAO(Connection conexao){
		this.conexao = conexao;
	}

	public Endereco endereco(int id){
		String sql = "select * from endereco where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Endereco endereco = null;
			
			while(rs.next()){
				String idC = rs.getString("cidade_id");
				String ruaE = rs.getString("rua");
				String numeroE = rs.getString("numero");
				
				int numero = Integer.parseInt(numeroE);
				int idCC = Integer.parseInt(idC);
				
				Cidade cidade = cidade(idCC);
				Estado estado = estado(cidade.getEstado().getId());
				
				endereco = new Endereco();
				endereco.setCidade(cidade);
				endereco.setEstado(estado);
				endereco.setNumero(numero);
				endereco.setRua(ruaE);
			}

			rs.close();
			pstm.close();
			return endereco;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cidade cidade(int id){
		String sql = "select * from cidade where id = ?;";
	
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Cidade cidade = null;
			while(rs.next()){
				String nome = rs.getString("nome");
				String idE = rs.getString("estado_id");
				
				int idEstado = Integer.parseInt(idE);
				Estado estado = estado(idEstado);
				
				cidade = new Cidade();
				cidade.setId(id);
				cidade.setNome(nome);
				cidade.setEstado(estado);
			}
			
			rs.close();
			pstm.close();
			
			return cidade;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Estado estado(int id){
		String sql = "select * from estado where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Estado estado = null;
			
			while(rs.next()){
				String nome = rs.getString("nome");
				
				estado = new Estado();
				estado.setId(id);
				estado.setNome(nome);
			}
			
			rs.close();
			pstm.close();
			
			return estado;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int adiciona(Endereco endereco){
		String sql = "insert into endereco(cidade_id, rua, numero) values(?, ?, ?);";
		String sql2 = "SELECT @@IDENTITY AS 'Identity';";
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			PreparedStatement pstmt1 = conexao.prepareStatement(sql2);
			
			pstmt.setInt(1, endereco.getCidade().getId());
			pstmt.setString(2, endereco.getRua());
			pstmt.setInt(3, endereco.getNumero());
			
			pstmt.execute();
			
			ResultSet rs = pstmt1.executeQuery();
			
			int id = 0;
			
			while(rs.next()){
				String idE = rs.getString("Identity");
				
				id = Integer.parseInt(idE);
				
			}
			
			rs.close();
			pstmt.close();
			
			return id;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
*/

public class EnderecoDAO {
	
	private Connection conexao;
	
	public EnderecoDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Endereco endereco(int id){
		String sql = "select * from endereco where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Endereco endereco = null;
			
			while(rs.next()){
				String idC = rs.getString("id_cidade");
				String ruaE = rs.getString("rua");
				String numeroE = rs.getString("numero");
				
				int numero = Integer.parseInt(numeroE);
				int idCC = Integer.parseInt(idC);
				
				Cidade cidade = cidade(idCC);
				Estado estado = estado(cidade.getEstado().getId());
				
				endereco = new Endereco();
				endereco.setCidade(cidade);
				endereco.setEstado(estado);
				endereco.setNumero(numero);
				endereco.setRua(ruaE);
			}

			rs.close();
			pstm.close();
			return endereco;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cidade cidade(int id){
		String sql = "select * from cidade where id = ?;";
	
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Cidade cidade = null;
			while(rs.next()){
				String nome = rs.getString("nome");
				String idE = rs.getString("id_estado");
				
				int idEstado = Integer.parseInt(idE);
				Estado estado = estado(idEstado);
				
				cidade = new Cidade();
				cidade.setId(id);
				cidade.setNome(nome);
				cidade.setEstado(estado);
			}
			
			rs.close();
			pstm.close();
			
			return cidade;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Estado estado(int id){
		String sql = "select * from estado where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Estado estado = null;
			
			while(rs.next()){
				String nome = rs.getString("nome");
				
				estado = new Estado();
				estado.setId(id);
				estado.setNome(nome);
			}
			
			rs.close();
			pstm.close();
			
			return estado;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int adiciona(Endereco endereco){
		String sql = "insert into endereco(id_cidade, rua, numero) values(?, ?, ?);";
		String sql2 = "SELECT @@IDENTITY AS 'Identity';";
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			PreparedStatement pstmt1 = conexao.prepareStatement(sql2);
			
			pstmt.setInt(1, endereco.getCidade().getId());
			pstmt.setString(2, endereco.getRua());
			pstmt.setInt(3, endereco.getNumero());
			
			pstmt.execute();
			
			ResultSet rs = pstmt1.executeQuery();
			
			int id = 0;
			
			while(rs.next()){
				String idE = rs.getString("Identity");
				
				id = Integer.parseInt(idE);
				
			}
			
			rs.close();
			pstmt.close();
			
			return id;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
