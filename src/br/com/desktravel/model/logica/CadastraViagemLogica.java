package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Cidade;
import br.com.desktravel.model.Custo;
import br.com.desktravel.model.Endereco;
import br.com.desktravel.model.Estado;
import br.com.desktravel.model.Status;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.Viagem;

public class CadastraViagemLogica implements Logica{

	private String msgErro = "O seguinte erro foi encontrado: ";
	
	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		HttpSession session = httpServletRequest.getSession();
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		ViagemDAO dao = new ViagemDAO(conexao);
		Viagem viagem = new Viagem();
		Custo custo = new Custo();
		Endereco endereco = new Endereco();
		Cidade cidade = new Cidade();
		Estado estado = new Estado();

		String combustivelV = httpServletRequest.getParameter("combustivel");
		String alimentaçãoV = httpServletRequest.getParameter("alimentacao");
		String hospedagemV = httpServletRequest.getParameter("hospedagem");
		String outroGastoV = httpServletRequest.getParameter("outroCusto");
		String descricaoOG = httpServletRequest.getParameter("Desc");
//		String motivo = httpServletRequest.getParameter("motivo");
		String motivoDesc = httpServletRequest.getParameter("motivoDesc");
		
		if(verifica1(outroGastoV, descricaoOG)){
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroViagem");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		if(outroGastoV.isEmpty()){
			outroGastoV = "0";
		}if(descricaoOG.isEmpty()){
			descricaoOG = "";
		}
		
		String duracaoV = httpServletRequest.getParameter("duracao");
		String dataSaidaV = httpServletRequest.getParameter("dataDeSaida");
		String dataVoltaV = httpServletRequest.getParameter("dataVolta");

		String cidadeV = httpServletRequest.getParameter("cidade");
		String estadoV = httpServletRequest.getParameter("estado");
		String ruaV = httpServletRequest.getParameter("rua");
		String numeroV = httpServletRequest.getParameter("numero");

		if (validaNull(estadoV, cidadeV, ruaV, numeroV, combustivelV, alimentaçãoV, hospedagemV, duracaoV, dataSaidaV, dataVoltaV, motivoDesc)) {
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroViagem");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
//		if (validaNull(estadoV, cidadeV, ruaV, numeroV, combustivelV, alimentaçãoV, hospedagemV, duracaoV, dataSaidaV, dataVoltaV, motivo, motivoDesc)) {
//			httpServletRequest.setAttribute("msgErro", this.msgErro);
//			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroViagem");
//			rd.forward(httpServletRequest, httpServletResponse);
//			return;
//		}
		
		if(size(numeroV, ruaV, combustivelV, alimentaçãoV, hospedagemV, duracaoV, outroGastoV, descricaoOG, motivoDesc)){
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroViagem");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		double combustivel = Double.parseDouble(combustivelV);
		double alimentacao = Double.parseDouble(alimentaçãoV);
		double hospedagem = Double.parseDouble(hospedagemV);
		double outroGasto = Double.parseDouble(outroGastoV);

		int duracao = Integer.parseInt(duracaoV);
		int cidadeId = Integer.parseInt(cidadeV);
		int estadoId = Integer.parseInt(estadoV);
		int numeroC = Integer.parseInt(numeroV);

		Calendar dataSaida = data(dataSaidaV);
		Calendar dataVolta = data(dataVoltaV);
		
		custo.setCombustivel(combustivel);
		custo.setAlimentacao(alimentacao);
		custo.setHospedagem(hospedagem);
		custo.setDescOG(descricaoOG);
		custo.setOutrosGastos(outroGasto);

		estado.setId(estadoId);

		cidade.setId(cidadeId);
		cidade.setEstado(estado);

		endereco.setCidade(cidade);
		endereco.setRua(ruaV);
		endereco.setNumero(numeroC);

		viagem.setUsuario(usuario);
		viagem.setCusto(custo);
		viagem.setEndereco(endereco);
		viagem.setDuracao(duracao);
//		viagem.setMotivo(motivo);
		viagem.setMotivoDesc(motivoDesc);
//		viagem.setMotivoStatus(Status.aberto);
		viagem.setPendente(true);
		viagem.setAprovacao(false);
		viagem.setDataSaida(dataSaida);
		viagem.setDataVolta(dataVolta);
		
		if(verificarExistenciaOutrasViagens(usuario, dao)){
			httpServletRequest.setAttribute("msgErro", this.msgErro);
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("sistema?logica=PreparaCadastroViagem");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		
		dao.adiciona(viagem);
		
		httpServletResponse.sendRedirect("sistema?logica=PreparaCadastroViagem");
	}
	
	public Calendar data(String data){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Calendar caln = Calendar.getInstance();
		try {
			caln.setTime(formato.parse(data));
			return caln;
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean validaNull(String estado, String cidade, String rua, String numero, String combustivel, String alimentacao, String hospeagem, String duracao, String dataSaida, String dataVolta, String motivoDesc){
		boolean camposNullos = false;
		
		if(estado.trim().isEmpty() || estado == null){
			camposNullos = true;
		}else if(cidade.trim().isEmpty() || cidade == null){
			camposNullos = true;
		}else if(rua.trim().isEmpty() || rua == null){
			camposNullos = true;
		}else if(numero.trim().isEmpty() || numero == null){
			camposNullos = true;
		}else if(combustivel.trim().isEmpty() || combustivel == null){
			camposNullos = true;
		}else if(hospeagem.trim().isEmpty() || hospeagem == null){
			camposNullos = true;
		}else if(alimentacao.trim().isEmpty() || alimentacao == null){
			camposNullos = true;
		}else if(duracao.trim().isEmpty() || duracao == null){
			camposNullos = true;
		}else if(dataSaida.trim().isEmpty() || dataSaida == null){
			camposNullos = true;
		}else if(dataVolta.trim().isEmpty() || dataVolta == null){
			camposNullos = true;
		}else if(motivoDesc.trim().isEmpty() || motivoDesc == null){
			camposNullos = true;
		}
		
		if(camposNullos == true){
			this.msgErro += "<br> - Ha campo(s) nulo(s)";
			return true;
		}
		
		return false;
	}
	
//	public boolean validaNull(String estado, String cidade, String rua, String numero, String combustivel, String alimentacao, String hospeagem, String duracao, String dataSaida, String dataVolta, String motivo, String motivoDesc){
//		boolean camposNullos = false;
//		
//		if(estado.trim().isEmpty() || estado == null){
//			camposNullos = true;
//		}else if(cidade.trim().isEmpty() || cidade == null){
//			camposNullos = true;
//		}else if(rua.trim().isEmpty() || rua == null){
//			camposNullos = true;
//		}else if(numero.trim().isEmpty() || numero == null){
//			camposNullos = true;
//		}else if(combustivel.trim().isEmpty() || combustivel == null){
//			camposNullos = true;
//		}else if(hospeagem.trim().isEmpty() || hospeagem == null){
//			camposNullos = true;
//		}else if(alimentacao.trim().isEmpty() || alimentacao == null){
//			camposNullos = true;
//		}else if(duracao.trim().isEmpty() || duracao == null){
//			camposNullos = true;
//		}else if(dataSaida.trim().isEmpty() || dataSaida == null){
//			camposNullos = true;
//		}else if(dataVolta.trim().isEmpty() || dataVolta == null){
//			camposNullos = true;
//		}else if(motivo.trim().isEmpty() || motivo == null){
//			camposNullos = true;
//		}else if(motivoDesc.trim().isEmpty() || motivoDesc == null){
//			camposNullos = true;
//		}
//		
//		if(camposNullos == true){
//			this.msgErro += "<br> - Ha campo(s) nulo(s)";
//			return true;
//		}
//		
//		return false;
//	}
	
	public boolean verificarExistenciaOutrasViagens(Usuario usuario, ViagemDAO dao){
		
		ArrayList<Viagem> viagens = dao.viagensExist(usuario.getId());
		
		if(viagens.isEmpty()){
			return false;
		}else{
			this.msgErro += "<br> - Voce ja tem uma viagem cadastrada";
			return true;
		}
	}
	
	public boolean verifica1(String outroGasto, String Desc){
		if(!(outroGasto.isEmpty()) || !(Desc.isEmpty())){
			if(!(outroGasto.isEmpty()) && !(Desc.isEmpty())){
				
			}else{
				this.msgErro += "<br> -Se o campo outro gasto estar preenchido necessariamente o campo Descrição do outroCusto tambem deve estar preenchindo <br> vice versa";
				return true;
			}
		}
		
		return false;
	}
	
	public boolean size(String numero, String rua, String combustivel, String alimentacao, String hospeagem,String duracao, String outroGastoV, String descricaoOG, String motivoDesc){
		if(rua.length() > 125){
			this.msgErro += "<br> -O campo rua so pode ter no max 125 caracteres";
			return true;
		}if(numero.length() > 5){
			this.msgErro += "<br> -O campo numero so pode ter no max 4 digitos";
			return true;
		}if(combustivel.length() > 6){
			this.msgErro += "<br> - O valor do combustivel esta muito caro";
			return true;
		}if(alimentacao.length() > 6){
			this.msgErro += "<br> - O valor da alimentação esta muito caro";
			return true;
		}if(hospeagem.length() > 6){
			this.msgErro += "<br> - O valor da hospedagem esta muito caro";
			return true;
		}if(duracao.length() > 4 || duracao.length() < 1){
			this.msgErro += "<br> - A viagem esta muito longa";
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
		}if(!(motivoDesc.length() > 10)){
			this.msgErro += "<br> - A descrição do motivo tem que ter no minimo 10 caracteres";
			return true;
		}
		return false;
	}
	
//	public boolean size(String numero, String rua, String combustivel, String alimentacao, String hospeagem,String duracao, String outroGastoV, String descricaoOG, String motivo, String motivoDesc){
//		if(rua.length() > 125){
//			this.msgErro += "<br> -O campo rua so pode ter no max 125 caracteres";
//			return true;
//		}if(numero.length() > 5){
//			this.msgErro += "<br> -O campo numero so pode ter no max 4 digitos";
//			return true;
//		}if(combustivel.length() > 6){
//			this.msgErro += "<br> - O valor do combustivel esta muito caro";
//			return true;
//		}if(alimentacao.length() > 6){
//			this.msgErro += "<br> - O valor da alimentação esta muito caro";
//			return true;
//		}if(hospeagem.length() > 6){
//			this.msgErro += "<br> - O valor da hospedagem esta muito caro";
//			return true;
//		}if(duracao.length() > 4 || duracao.length() < 1){
//			this.msgErro += "<br> - A viagem esta muito longa";
//			return true;
//		}if(!(outroGastoV.isEmpty()) || !(outroGastoV == null)){
//			if(outroGastoV.length() > 6){
//				this.msgErro += "<br> -O valor do outro custo esta muito alto";
//				return true;
//			}
//		}if(!(descricaoOG.isEmpty()) || !(descricaoOG == null)){
//			if(descricaoOG.length() > 44){
//				this.msgErro += "<br> - A descrição do outro custo so pode ter no maximo 45 caracteres";
//				return true;
//			}
//		}if(!(motivo.length() > 4 && motivo.length() < 250)){
//			this.msgErro += "<br> - O motivo so pode ter no maximo 250 caracteres e no minimo 4 caracteres";
//			return true;
//		}if(!(motivoDesc.length() > 10)){
//			this.msgErro += "<br> - A descrição do motivo tem que ter no minimo 10 caracteres";
//			return true;
//		}
//		return false;
//	}
	public Calendar dataVolta(Calendar dataSaida, int duracao){
		dataSaida.add(Calendar.DATE, duracao);
		
		return dataSaida;
	}
}
