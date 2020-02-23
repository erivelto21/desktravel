package br.com.desktravel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.desktravel.model.Cidade;
import br.com.desktravel.model.Estado;
import br.com.desktravel.model.UsuarioTipo;

public class PreparaDAO {
	
	private Connection conexao;
	
	public PreparaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Estado> getEstados(){
		String sql = "select * from estado;";
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Estado> estados = new ArrayList<Estado>();
			while(rs.next()){
				String idE = rs.getString("id");
				String nome = rs.getString("nome");
				
				int id = Integer.parseInt(idE);
				
				Estado estado = new Estado();
				estado.setId(id);
				estado.setNome(nome);
				estados.add(estado);
			
			}
			
			rs.close();
			pstm.close();
			
			return estados;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	public ArrayList<Cidade> getCidades(int idEE){
//		String sql = "select * from cidade where estado_id = ?;";
//		try{
//			
//			PreparedStatement pstm = conexao.prepareStatement(sql);
//			pstm.setInt(1, idEE);
//			
//			ResultSet rs = pstm.executeQuery();
//			
//			ArrayList<Cidade> cidades = new ArrayList<Cidade>();
//			while(rs.next()){
//				String idE = rs.getString("id");
//				String nome = rs.getString("nome");
//				String estadoC_Id = rs.getString("estado_id");
//				
//				int id = Integer.parseInt(idE);
//				int estado_id = Integer.parseInt(estadoC_Id);
//				Estado estado = new EnderecoDAO(this.conexao).estado(estado_id);
//				
//				Cidade cidade = new Cidade();
//				cidade.setId(id);
//				cidade.setNome(nome);
//				cidade.setEstado(estado);
//				cidades.add(cidade);
//			
//			}
//			
//			rs.close();
//			pstm.close();
//			
//			return cidades;
//		}catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	public ArrayList<Cidade> getCidades(int idEE){
		String sql = "select * from cidade where id_estado = ?;";
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idEE);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Cidade> cidades = new ArrayList<Cidade>();
			while(rs.next()){
				String idE = rs.getString("id");
				String nome = rs.getString("nome");
				String estadoC_Id = rs.getString("id_estado");
				
				int id = Integer.parseInt(idE);
				int estado_id = Integer.parseInt(estadoC_Id);
				Estado estado = new EnderecoDAO(this.conexao).estado(estado_id);
				
				Cidade cidade = new Cidade();
				cidade.setId(id);
				cidade.setNome(nome);
				cidade.setEstado(estado);
				cidades.add(cidade);
			
			}
			
			rs.close();
			pstm.close();
			
			return cidades;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<UsuarioTipo> getUsuarioTipo(){
		String sql = "select * from usuario_tipo;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<UsuarioTipo> tipos = new ArrayList<UsuarioTipo>();
			
			while(rs.next()){			
				String idT = rs.getString("id");
				String genero = rs.getString("genero");
				
				int id = Integer.parseInt(idT);
				
				UsuarioTipo tipo = new UsuarioTipo();
				tipo.setId(id);
				tipo.setGenero(genero);
				tipos.add(tipo);
			}
			
			rs.close();
			pstm.close();
			
			return tipos;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
