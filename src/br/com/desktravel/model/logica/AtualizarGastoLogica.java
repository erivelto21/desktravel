package br.com.desktravel.model.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.CustoDAO;
import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Custo;
import br.com.desktravel.model.Viagem;

public class AtualizarGastoLogica implements Logica{
	
	private String msgErro = "O seguinte erro foi encontrado: ";
	
	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
			
			Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
			
			String viagemId = httpServletRequest.getParameter("viagemId");
			String combustivelV = httpServletRequest.getParameter("combustivel");
			String alimentacaoV = httpServletRequest.getParameter("alimentacao");
			String hospedagemV = httpServletRequest.getParameter("hospedagem");
			String descOGV = httpServletRequest.getParameter("descOG");
			String outroGastoV = httpServletRequest.getParameter("outrosGastos");
			
			if(verifica1(outroGastoV, descOGV)){
				httpServletRequest.setAttribute("msgErro", this.msgErro);
				httpServletRequest.setAttribute("desc", descOGV);
				httpServletRequest.setAttribute("viagemId", viagemId);
				httpServletRequest.setAttribute("combustivel", combustivelV);
				httpServletRequest.setAttribute("alimentacao", alimentacaoV);
				httpServletRequest.setAttribute("hospedagem", hospedagemV);
				httpServletRequest.setAttribute("outroGasto", outroGastoV);
				RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/atualizarCustos.jsp");
				rd.forward(httpServletRequest, httpServletResponse);
				return;
			}
			
			if(validaNull(combustivelV, alimentacaoV, hospedagemV, outroGastoV, descOGV)){
				httpServletRequest.setAttribute("msgErro", this.msgErro);
				httpServletRequest.setAttribute("desc", descOGV);
				httpServletRequest.setAttribute("viagemId", viagemId);
				httpServletRequest.setAttribute("combustivel", combustivelV);
				httpServletRequest.setAttribute("alimentacao", alimentacaoV);
				httpServletRequest.setAttribute("hospedagem", hospedagemV);
				httpServletRequest.setAttribute("outroGasto", outroGastoV);
				RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/atualizarCustos.jsp");
				rd.forward(httpServletRequest, httpServletResponse);
				return;
			}
	
			if(outroGastoV.isEmpty()){
				outroGastoV = "0";
			}
			
			if(size(combustivelV, alimentacaoV, hospedagemV, outroGastoV, descOGV)){
				httpServletRequest.setAttribute("msgErro", this.msgErro);
				httpServletRequest.setAttribute("desc", descOGV);
				httpServletRequest.setAttribute("viagemId", viagemId);
				httpServletRequest.setAttribute("combustivel", combustivelV);
				httpServletRequest.setAttribute("alimentacao", alimentacaoV);
				httpServletRequest.setAttribute("hospedagem", hospedagemV);
				httpServletRequest.setAttribute("outroGasto", outroGastoV);
				RequestDispatcher rd = httpServletRequest.getRequestDispatcher("privado/altera/atualizarCustos.jsp");
				rd.forward(httpServletRequest, httpServletResponse);
				return;
			}
			
			double combustivel = Double.parseDouble(combustivelV);
			double alimentacao = Double.parseDouble(alimentacaoV);
			double hospedagem = Double.parseDouble(hospedagemV);
			double outroGasto = Double.parseDouble(outroGastoV);
			
			int idV = Integer.parseInt(viagemId);
			
			ViagemDAO daoV = new ViagemDAO(conexao);
			
			Viagem viagem = daoV.viagem(idV);
			
			Custo custo = new Custo();
			
			
			custo.setCombustivel(combustivel);
			custo.setAlimentacao(alimentacao);
			custo.setHospedagem(hospedagem);
			custo.setDescOG(descOGV);
			custo.setOutrosGastos(outroGasto);		

			if(viagem.getCustoR() == null){
				daoV.addCustoNovo(viagem.getId(), custo);
				return;
			}
			
			custo.setId(viagem.getCustoR().getId());
			viagem.setCustoR(custo);
			CustoDAO daoC = new CustoDAO(conexao);

			daoC.atualiza(viagem.getId(), viagem.getCustoR());
			
			httpServletResponse.sendRedirect("sistema?logica=ConsultaCustoViagemAtiva");
	}
	
	public boolean validaNull(String combustivel, String alimentacao, String hospedagem, String outroGasto, String desc){
		boolean camposNullos = false;
		
		if(combustivel.trim().isEmpty() || combustivel == null){
			camposNullos = true;
		}else if(alimentacao.trim().isEmpty() || alimentacao == null){
			camposNullos = true;
		}else if(hospedagem.trim().isEmpty() || hospedagem == null){
			camposNullos = true;
		}else if(outroGasto.isEmpty() && !(desc.equals(""))){
			camposNullos = true;
		}

		if(camposNullos == true){
			this.msgErro += "<br> - Ha campo(s) nulo(s)";
			return true;
		}
		
		return false;
	}
	
	public boolean size(String combustivel, String alimentacao, String hospeagem, String outroGastoV, String descricaoOG){
		if(combustivel.length() > 6){
			System.out.println(combustivel.length());
			this.msgErro += "<br> - O valor do combustivel esta muito caro";
			return true;
		}if(alimentacao.length() > 6){
			this.msgErro += "<br> - O valor da alimentação esta muito caro";
			return true;
		}if(hospeagem.length() > 6){
			this.msgErro += "<br> - O valor da hospedagem esta muito caro";
			return true;
		}if(!(outroGastoV.isEmpty()) || !(outroGastoV == null)){
			if(outroGastoV.length() > 6){
				this.msgErro += "<br> -O valor do outro custo esta muito alto";
				return true;
			}
		}if(!(descricaoOG.isEmpty()) || !(descricaoOG == null)){
			if(descricaoOG.length() > 44){
				this.msgErro += "<br> - A descrição do outro custo so pode ter no maximo 45 caracteres";
				return true;
			}
		}
		
		return false;
	}
	
	public boolean verifica1(String outroGasto, String Desc){
		if(outroGasto.equals("0.0") || Desc.equals("")){
			if(outroGasto.equals("0.0") && Desc.equals("")){
				
			}else{
				this.msgErro += "<br> -Não existe outro gasto";
				return true;
			}
		}
		
		return false;
	}
}