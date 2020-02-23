package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.CustoDAO;
import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Status;
import br.com.desktravel.model.Viagem;

public class DecidirViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		Connection conexao = (Connection)httpServletRequest.getAttribute("conexao");
		
		String idViagemString = httpServletRequest.getParameter("idViagem");
		String aprovacao = httpServletRequest.getParameter("decisao");
		
		int idViagem = Integer.parseInt(idViagemString);
		Boolean aprovacaoViagem = Boolean.parseBoolean(aprovacao);
		
		ViagemDAO dao = new ViagemDAO(conexao);
		Viagem viagem = dao.viagem(idViagem);
		viagem.setAprovacao(aprovacaoViagem);
//		viagem.setMotivoStatus((alterarStatus(aprovacaoViagem)));
		atualizarTrabalhos(viagem.getId(), conexao, aprovacaoViagem);
		
		dao.aprovacao(viagem);
		
		if(viagem.getAprovacao() == true){
			dao.addCustoNovo(viagem.getId(), viagem.getCusto());
		}
		
		new ConsultaViagemPendentesLogica().executa(httpServletRequest, httpServletResponse);
	}
	
	public Status alterarStatus(boolean aprovacao){
		
		if(aprovacao == true){
			return Status.Progresso;
		}else{
			return Status.negado;
		}
	}
	
	public void atualizarTrabalhos(int idViagem, Connection conexao, boolean aprovacao){
		ViagemDAO dao = new ViagemDAO(conexao);
		
		if(aprovacao == true){
			dao.atualizarStatus(idViagem, Status.Progresso);
		}else{
			dao.atualizarStatus(idViagem, Status.negado);
		}
	}
}
