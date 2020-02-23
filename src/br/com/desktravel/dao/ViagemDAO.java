package br.com.desktravel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.desktravel.adaptadores.AdaptadorViagem;
import br.com.desktravel.model.Custo;
import br.com.desktravel.model.Endereco;
import br.com.desktravel.model.Status;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.Viagem;
/*
public class ViagemDAO {
	
	private Connection conexao;
	
	public ViagemDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Viagem> viagemPendentesAdm(){
		String sql = "select  * from viagem join usuario on viagem.usuario_id = usuario.id and viagem.pendente = true and viagem.aprovacao = false;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				String aprovacao = rs.getString("aprovacao");
				int idC = rs.getInt("custo_id");
				int idE = rs.getInt("endereco_id");
				String pendente = rs.getString("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Boolean aprov = Boolean.parseBoolean(aprovacao);
				Boolean pend = Boolean.parseBoolean(pendente);
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(dataSaida);
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			rs.close();
			pstm.close();
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//superior
	public ArrayList<Viagem> viagemPendentes(Usuario usuario){
		String sql = "select  * from viagem join usuario on viagem.usuario_id = usuario.id and usuario.id_superior = ? and viagem.pendente = true and viagem.aprovacao = false;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				String aprovacao = rs.getString("aprovacao");
				int idC = rs.getInt("custo_id");
				int idE = rs.getInt("endereco_id");
				String pendente = rs.getString("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Boolean aprov = Boolean.parseBoolean(aprovacao);
				Boolean pend = Boolean.parseBoolean(pendente);
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(dataSaida);
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			rs.close();
			pstm.close();
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//Propria
	public ArrayList<Viagem> viagemPendentesP(Usuario usuario){
		String sql = "select  * from viagem where usuario_id = ? and aprovacao = false and pendente = true;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				String aprovacao = rs.getString("aprovacao");
				int idC = rs.getInt("custo_id");
				int idE = rs.getInt("endereco_id");
				String pendente = rs.getString("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Boolean aprov = Boolean.parseBoolean(aprovacao);
				Boolean pend = Boolean.parseBoolean(pendente);
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(dataSaida);
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			rs.close();
			pstm.close();
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Viagem viagem){
		
		String sql = "insert into viagem(usuario_id, duracao, custo_id, endereco_id, aprovacao, pendente, dataSaida, dataVolta, motivo, motivoDesc, motivoStatus) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		String sql2 = "SELECT @@IDENTITY AS 'Identity';";

		CustoDAO daoC = new CustoDAO(conexao);
		EnderecoDAO daoE = new EnderecoDAO(conexao);

		int idC = daoC.adiciona(viagem.getCusto()); 

		int idE = daoE.adiciona(viagem.getEndereco());
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			PreparedStatement pstmt1 = conexao.prepareStatement(sql2);
			
			java.sql.Date datS = new java.sql.Date(viagem.getDataSaida().getTimeInMillis());
			java.sql.Date datV = new java.sql.Date(viagem.getDataVolta().getTimeInMillis());
			
			pstmt.setInt(1, viagem.getUsuario().getId());
			pstmt.setInt(2, viagem.getDuracao());
			pstmt.setInt(3, idC);
			pstmt.setInt(4, idE);
			pstmt.setBoolean(5, viagem.getAprovacao());
			pstmt.setBoolean(6, viagem.getPendente());
			pstmt.setDate(7, datS);
			pstmt.setDate(8, datV);
			pstmt.setString(9, viagem.getMotivo());
			pstmt.setString(10, viagem.getMotivoDesc());
			pstmt.setString(11, viagem.getMotivoStatus().getValor());
			
			pstmt.execute();
			
			ResultSet rs = pstmt1.executeQuery();
			
			int idV = 0;
			while(rs.next()){
				String idSv = rs.getString("Identity");
				
				idV = Integer.parseInt(idSv);
				
			}
			
			pstmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void aprovacao(Viagem viagem){
		String sql = "update viagem set aprovacao = ? , pendente = false, motivoStatus = ? where viagem.id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setBoolean(1, viagem.getAprovacao());
			pstm.setString(2, viagem.getMotivoStatus().getValor());
			pstm.setInt(3, viagem.getId());
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> ativaAdm(){
		
		String sql = "select  * from viagem join usuario on viagem.usuario_id = usuario.id and viagem.aprovacao = true and viagem.pendente = false;";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR= new CustoDAO(conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);		

				Status status = Status.valueOf(motivoStatus);

				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> ativa(int idS){
		
		String sql = "select  * from viagem join usuario on (viagem.usuario_id = usuario.id and usuario.id_superior = ?) and viagem.aprovacao = true and viagem.pendente = false;";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idS);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR= new CustoDAO(conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);		
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> concluidaAdm(){
		
		String sql = "select  * from viagem join usuario on viagem.usuario_id = usuario.id and viagem.aprovacao = true and viagem.pendente = true;";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR= new CustoDAO(conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);		
				
				Status status = Status.valueOf(motivoStatus);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> concluida(int idS){
		
		String sql = "select  * from viagem join usuario on (viagem.usuario_id = usuario.id and usuario.id_superior = ?) and viagem.aprovacao = true and viagem.pendente = true;";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idS);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR= new CustoDAO(conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);		
				
				Status status = Status.valueOf(motivoStatus);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensUsuario(int idU){
		
		String sql = "select * from viagem where usuario_id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idU);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int duraca = rs.getInt("duracao");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		String sql="delete from viagem where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Viagem viagem(int id){
		String sql = "select * from viagem where id = ?;";
		
		try{
			PreparedStatement psmst = conexao.prepareStatement(sql);
			psmst.setInt(1, id);
			
			ResultSet rs = psmst.executeQuery();
			Viagem viagem = null;
			
			while(rs.next()){
				viagem = new Viagem();
				
				int duraca = rs.getInt("duracao");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR= new CustoDAO(this.conexao).custo(idCR);

				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
			}
			
			return viagem;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Viagem viagemAtivaU(int idU){
		String sql = "select * from viagem where usuario_id = ? and aprovacao = true and pendente = false;";
		
		try{
			PreparedStatement psmst = conexao.prepareStatement(sql);
			psmst.setInt(1, idU);
			
			ResultSet rs = psmst.executeQuery();
			Viagem viagem = null;
			
			while(rs.next()){
				viagem = new Viagem();
				
				int id = rs.getInt("id");
				int duraca = rs.getInt("duracao");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String stat = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(stat);
				
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
			}
			
			return viagem;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void viagemConclui(int id){
		String sql = "update viagem set aprovacao = true, pendente = true where id = ?; ";
		try{
			PreparedStatement psmt = conexao.prepareStatement(sql);
			psmt.setInt(1, id);
			
			psmt.execute();
			psmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensExist(int idU){
		
		String sql = "select * from viagem where (usuario_id = ? and aprovacao = true and pendente = false ) or (usuario_id = ? and aprovacao = false and pendente = true );";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idU);
			pstm.setInt(2, idU);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int duraca = rs.getInt("duracao");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Viagem viagemAtivaGasto(int idU){
		String sql = "select * from viagem where usuario_id = ? and aprovacao = true and pendente = false;";
		
		try{
			PreparedStatement psmst = conexao.prepareStatement(sql);
			psmst.setInt(1, idU);
			
			ResultSet rs = psmst.executeQuery();
			Viagem viagem = null;
			
			while(rs.next()){
				viagem = new Viagem();
				
				int id = rs.getInt("id");
				int duraca = rs.getInt("duracao");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR = new CustoDAO(this.conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
			}
			
			return viagem;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addCustoNovo(int idV, Custo custoR){
		String sql="update viagens set custoR_id = ? where id = ?;";
		
		CustoDAO dao = new CustoDAO(conexao);
		int c = dao.adiciona(custoR);
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, c);
			pstm.setInt(2, idV);
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensMes(int mes, int idS){
		String sql = "select  * from viagem join usuario on (viagem.usuario_id = usuario.id) and viagem.aprovacao = true and viagem.pendente = true;";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				
				int id = rs.getInt("id");
				int idU = rs.getInt("usuario_id");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				int duraca = rs.getInt("duracao");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR= new CustoDAO(conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);		
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				if((cS.get(Calendar.MONTH) + 1) == mes){
					viagens.add(viagem);
				}
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizarStatus(int id, Status status){
		String sql = "update viagem set motivoStatus = ? where id = ?";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, status.getValor());
			pstmt.setInt(2, id);
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensNegadasG(int idS){
		String sql = "select * from viagem join usuario on usuario_id = usuario.id where pendente = false and aprovacao = false and id_superior = ?";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idS);
			
			ResultSet rs = pstmt.executeQuery();
			
			Viagem viagem = null;
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				viagem = new Viagem();
				
				int id = rs.getInt("viagem.id");
				int idU = rs.getInt("usuario_id");
				int duraca = rs.getInt("duracao");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR = new CustoDAO(this.conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				viagem.setId(id);
				viagem.setUsuario(u);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public ArrayList<Viagem> viagensNegadasA(){
		String sql = "select * from viagem join usuario on usuario_id = usuario.id where pendente = false and aprovacao = false";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			Viagem viagem = null;
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				viagem = new Viagem();
				
				int id = rs.getInt("viagem.id");
				int idU = rs.getInt("usuario_id");
				int duraca = rs.getInt("duracao");
				Date dataSaida = rs.getDate("dataSaida");
				Date dataVolta = rs.getDate("dataVolta");
				Boolean aprov = rs.getBoolean("aprovacao");
				int idC = rs.getInt("custo_id");
				int idCR = rs.getInt("custoR_id");
				int idE = rs.getInt("endereco_id");
				Boolean pend = rs.getBoolean("pendente");
				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("motivoDesc");
				String motivoStatus = rs.getString("motivoStatus");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(conexao).usuario(idU);
				
				Custo c = new Custo();
				c = new CustoDAO(this.conexao).custo(idC);
				
				Custo cR = new Custo();
				cR = new CustoDAO(this.conexao).custo(idCR);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				cS.setTime(dataSaida);
				Calendar cV = Calendar.getInstance();
				cV.setTime(dataVolta);
				
				Status status = Status.valueOf(motivoStatus);
				
				viagem.setId(id);
				viagem.setUsuario(u);
				viagem.setAprovacao(aprov);
				viagem.setCusto(c);
				viagem.setCustoR(cR);
				viagem.setEndereco(e);
				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
				viagem.setMotivoStatus(status);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(pend);
				
				viagens.add(viagem);
			}
			
			return viagens;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
*/

public class ViagemDAO {
	
	private Connection conexao;
	
	public ViagemDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Viagem> viagemPendentesAdm(){
		String sql = "select  * from viagens join funcionarios on viagens.id_funcionario = funcionarios.id and viagens.situacao = 'Pendente';";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
//				System.out.println(motivoStatus);
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));

				viagens.add(viagem);
			}
			
			rs.close();
			pstm.close();
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//superior
	public ArrayList<Viagem> viagemPendentes(Usuario usuario){
		String sql = "select  * from viagens join funcionarios on viagens.id_funcionario = funcionarios.id and funcionarios.id_gestor = ? and viagens.situacao = 'Pendente'";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			rs.close();
			pstm.close();
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//Propria
	public ArrayList<Viagem> viagemPendentesP(Usuario usuario){
		String sql = "select  * from viagens where id_funcionario = ? and situacao='Pendente';";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, usuario.getId());
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			rs.close();
			pstm.close();
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Viagem viagem){
		
//		String sql = "insert into viagens(id_funcionario, qtd_dias, valor_hospedagem, valor_alimentacao, valor_gasolina, valor_outros_gastos, desc_gastos, valor_total, id_endereco, situacao, data, motivo, desc_motivo, status_motivo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		String sql = "insert into viagens(id_funcionario, qtd_dias, valor_hospedagem, valor_alimentacao, valor_gasolina, valor_outros_gastos, desc_gastos, valor_total, id_endereco, situacao, data, desc_motivo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		EnderecoDAO daoE = new EnderecoDAO(conexao);

		int idE = daoE.adiciona(viagem.getEndereco());
		
		try{
			PreparedStatement pstmt = conexao.prepareStatement(sql);
						
			pstmt.setInt(1, viagem.getUsuario().getId());
			pstmt.setInt(2, viagem.getDuracao());
			pstmt.setFloat(3, AdaptadorViagem.valor(viagem.getCusto().getHospedagem()));
			pstmt.setFloat(4, AdaptadorViagem.valor(viagem.getCusto().getAlimentacao()));
			pstmt.setFloat(5, AdaptadorViagem.valor(viagem.getCusto().getCombustivel()));
			pstmt.setFloat(6, AdaptadorViagem.valor(viagem.getCusto().getOutrosGastos()));
			pstmt.setString(7, viagem.getCusto().getDescOG());
			pstmt.setFloat(8, AdaptadorViagem.total(viagem.getCusto().getHospedagem(), viagem.getCusto().getCombustivel(), viagem.getCusto().getAlimentacao(), viagem.getCusto().getOutrosGastos()));
			pstmt.setInt(9, idE);
			pstmt.setString(10, AdaptadorViagem.situacao(viagem.getAprovacao(), viagem.getPendente()));
			pstmt.setString(11, AdaptadorViagem.data(viagem.getDataSaida()));
//			pstmt.setString(12, viagem.getMotivo());
			pstmt.setString(12, viagem.getMotivoDesc());
//			pstmt.setString(14, viagem.getMotivoStatus().getValor());
			
			pstmt.execute();
			
			pstmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void aprovacao(Viagem viagem){
//		String sql = "update viagens set situacao = ?, status_motivo = ? where viagens.id = ?;";
		String sql = "update viagens set situacao = ? where viagens.id = ?;";

		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
		
			pstm.setString(1, AdaptadorViagem.situacao(viagem.getAprovacao(), false));
//			pstm.setString(2, viagem.getMotivoStatus().getValor());
			pstm.setInt(2, viagem.getId());
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> ativaAdm(){
		
		String sql = "select  * from viagens join funcionarios on viagens.id_funcionario = funcionarios.id and viagens.situacao = 'Aprovado';";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> ativa(int idS){
		
		String sql = "select  * from viagens join funcionarios on (viagens.id_funcionario = funcionarios.id and funcionarios.id_gestor = ?) and viagens.situacao = 'Aprovado';";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idS);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> concluidaAdm(){
		
		String sql = "select  * from viagens join funcionarios on viagens.id_funcionario = funcionarios.id and viagens.situacao = 'concluida'";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> concluida(int idS){
		
		String sql = "select  * from viagens join funcionarios on (viagens.id_funcionario = funcionarios.id and funcionarios.id_gestor = ?) and viagens.situacao= = 'Concluida';";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idS);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensUsuario(int idU){
		
		String sql = "select * from viagens where id_funcionario = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idU);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(int id){
		
		String sql="delete from viagens where id = ?;";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Viagem viagem(int id){
		String sql = "select * from viagens where id = ?;";
		
		try{
			PreparedStatement psmst = conexao.prepareStatement(sql);
			psmst.setInt(1, id);
			
			ResultSet rs = psmst.executeQuery();
			Viagem viagem = null;
			
			while(rs.next()){
				viagem = new Viagem();
				
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
			}
			
			return viagem;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Viagem viagemAtivaU(int idU){
		String sql = "select * from viagens where id_funcionario = ? and situacao = 'Aprovado';";
		
		try{
			PreparedStatement psmst = conexao.prepareStatement(sql);
			psmst.setInt(1, idU);
			
			ResultSet rs = psmst.executeQuery();
			Viagem viagem = null;
			
			while(rs.next()){
				viagem = new Viagem();
				
				int id = rs.getInt("id");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
			}
			
			return viagem;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void viagemConclui(int id){
		String sql = "update viagens set situacao = 'Concluida' where id = ?; ";
		try{
			PreparedStatement psmt = conexao.prepareStatement(sql);
			psmt.setInt(1, id);
			
			psmt.execute();
			psmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensExist(int idU){
		
		String sql = "select * from viagens where (id_funcionario = ? and situacao = 'Aprovado' ) or (id_funcionario = ? and situacao = 'Pendente');";
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idU);
			pstm.setInt(2, idU);
			
			ResultSet rs = pstm.executeQuery();
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Viagem viagemAtivaGasto(int idU){
		String sql = "select * from viagens where id_funcionario = ? and situacao = 'Aprovado';";
		
		try{
			PreparedStatement psmst = conexao.prepareStatement(sql);
			psmst.setInt(1, idU);
			
			ResultSet rs = psmst.executeQuery();
			Viagem viagem = null;
			
			while(rs.next()){
				int id = rs.getInt("id");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
			}
			
			return viagem;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addCustoNovo(int idV, Custo custoR){
		String sql="update viagens set valorA_hospedagem = ?, valorA_alimentacao = ?, valorA_gasolina = ?, valorA_outros_gastos = ? where id = ?;";
		
		
		try{
			PreparedStatement pstm = conexao.prepareStatement(sql);
			pstm.setFloat(1, AdaptadorViagem.valor(custoR.getHospedagem()));
			pstm.setFloat(2, AdaptadorViagem.valor(custoR.getAlimentacao()));
			pstm.setFloat(3, AdaptadorViagem.valor(custoR.getCombustivel()));
			pstm.setFloat(4, AdaptadorViagem.valor(custoR.getOutrosGastos()));
			pstm.setInt(5, idV);
			
			pstm.execute();
			
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensMes(int mes, int idS){
		String sql = "select  * from viagens join funcionarios on (viagens.id_funcionario = funcionarios.id) and viagens.situacao = 'Concluida';";
		
		try{
			
			PreparedStatement pstm = conexao.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				Viagem viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				if((cS.get(Calendar.MONTH) + 1) == mes){
					viagens.add(viagem);
				}
			}
			
			return viagens;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizarStatus(int id, Status status){
		String sql = "update viagens set status_motivo = ? where id = ?";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setString(1, status.getValor());
			pstmt.setInt(2, id);
			
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Viagem> viagensNegadasG(int idS){
		String sql = "select * from viagens join funcionarios on id_funcionario = funcionarios.id where situacao = 'Negada' and id_gestor = ?";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			pstmt.setInt(1, idS);
			
			ResultSet rs = pstmt.executeQuery();
			
			Viagem viagem = null;
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public ArrayList<Viagem> viagensNegadasA(){
		String sql = "select * from viagens join funcionarios on id_funcionario = funcionarios.id where situacao = 'Negada'";
		
		try {
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			Viagem viagem = null;
			ArrayList<Viagem> viagens = new ArrayList<Viagem>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				int idU = rs.getInt("id_funcionario");
				String data = rs.getString("data");
				int duraca = rs.getInt("qtd_dias");
				float valor_hospedagem = rs.getFloat("valor_hospedagem");
				float valor_alimentacao = rs.getFloat("valor_alimentacao");
				float valor_gasolina = rs.getFloat("valor_gasolina");
				float valor_outros_gastos = rs.getFloat("valor_outros_gastos");
				float valorA_hospedagem = rs.getFloat("valorA_hospedagem");
				float valorA_alimentacao = rs.getFloat("valorA_alimentacao");
				float valorA_gasolina = rs.getFloat("valorA_gasolina");
				float valorA_outros_gastos = rs.getFloat("valorA_outros_gastos");
				String desc_gastos = rs.getString("desc_gastos");
				int idE = rs.getInt("id_endereco");
//				String motivo = rs.getString("motivo");
				String motivoDesc = rs.getString("desc_motivo");
//				String motivoStatus = rs.getString("status_motivo");
				String situacao = rs.getString("situacao");
				
				Usuario u = new Usuario();
				u = new UsuarioDAO(this.conexao).usuario(idU);
				
				Endereco e = new Endereco();
				e = new EnderecoDAO(this.conexao).endereco(idE);
				
				Calendar cS = Calendar.getInstance();
				Calendar cV = Calendar.getInstance();
				cS.setTime(AdaptadorViagem.dataSaida(data));
				cV.setTime(AdaptadorViagem.dataVolta(data, duraca));
				
//				Status status = Status.valueOf(motivoStatus);
				
				viagem = new Viagem();
				viagem.setId(id);
				viagem.setAprovacao(AdaptadorViagem.getaprovacao(situacao));
				viagem.setCusto(AdaptadorViagem.custo(valor_alimentacao, valor_gasolina, valor_hospedagem, valor_outros_gastos, desc_gastos));
				viagem.setCustoR(AdaptadorViagem.custo(valorA_alimentacao, valorA_gasolina, valorA_hospedagem, valorA_outros_gastos, desc_gastos));
				viagem.setEndereco(e);
//				viagem.setMotivo(motivo);
				viagem.setMotivoDesc(motivoDesc);
//				viagem.setMotivoStatus(status);
				viagem.setUsuario(u);
				viagem.setDataSaida(cS);
				viagem.setDataVolta(cV);
				viagem.setDuracao(duraca);
				viagem.setPendente(AdaptadorViagem.getPendente(situacao));
				
				viagens.add(viagem);
			}
			
			return viagens;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
