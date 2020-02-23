package br.com.desktravel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.desktravel.adaptadores.AdaptadorViagem;
import br.com.desktravel.model.Custo;

public class CustoDAO {
	
	private Connection conexao;
	
	public CustoDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Custo custo(int id){
		String sql = "select * from custo where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			ResultSet rs = pstm.executeQuery();
			Custo custo = null;
		
			while(rs.next()){
				Double combustivel =  rs.getDouble("combustivel");
				Double alimentacao =  rs.getDouble("alimentacao");
				Double hospedagem = rs.getDouble("hospedagem");
				Double outroGastos = rs.getDouble("outrosGastos");
				String desc = rs.getString("descricaoOutroCusto");
				
				custo = new Custo();
				
				custo.setCombustivel(combustivel);
				custo.setAlimentacao(alimentacao);
				custo.setHospedagem(hospedagem);
				custo.setOutrosGastos(outroGastos);
				custo.setDescOG(desc);
				custo.setId(id);
			}
			rs.close();
			pstm.close();
			
			return custo;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int adiciona(Custo custo){
		String sql = "insert into custo(combustivel, alimentacao, hospedagem, outrosGastos, descricaoOutroCusto) values (?, ?, ?, ?, ?);";
		String sql2 = "SELECT @@IDENTITY AS 'Identity';";
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			PreparedStatement pstmt1 = conexao.prepareStatement(sql2);
			
			pstmt.setDouble(1, custo.getCombustivel());
			pstmt.setDouble(2, custo.getAlimentacao());
			pstmt.setDouble(3, custo.getHospedagem());
			pstmt.setDouble(4, custo.getOutrosGastos());
			pstmt.setString(5, custo.getDescOG());
			
			pstmt.execute();
			
			ResultSet rs = pstmt1.executeQuery();
			int id = 0;
			
			while(rs.next()){
				String idC = rs.getString("Identity");
				
				id = Integer.parseInt(idC);
				
			}
			
			return id;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(Custo custo){
		String sql = "update custo set combustivel = ?, alimentacao = ?, hospedagem = ?, outrosGastos = ? where id = ?;";
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setDouble(1, custo.getCombustivel());
			pstmt.setDouble(2, custo.getAlimentacao());
			pstmt.setDouble(3, custo.getHospedagem());
			pstmt.setDouble(4, custo.getOutrosGastos());
			pstmt.setInt(5, custo.getId());
			
			pstmt.execute();
			
			pstmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualiza(int viagem, Custo custo){
		String sql = "update viagens set valorA_gasolina = ?, valorA_alimentacao = ?, valorA_hospedagem = ?, valorA_outros_gastos = ? where id = ?;";
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setDouble(1, AdaptadorViagem.valor(custo.getCombustivel()));
			pstmt.setDouble(2, AdaptadorViagem.valor(custo.getAlimentacao()));
			pstmt.setDouble(3, AdaptadorViagem.valor(custo.getHospedagem()));
			pstmt.setDouble(4, AdaptadorViagem.valor(custo.getOutrosGastos()));
			pstmt.setInt(5, viagem);
			
			pstmt.execute();
			
			pstmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
