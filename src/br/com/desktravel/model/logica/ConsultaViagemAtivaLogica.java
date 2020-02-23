package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Status;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.Viagem;

public class ConsultaViagemAtivaLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		HttpSession httpSession = httpServletRequest.getSession();
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		ViagemDAO dao = new ViagemDAO(conexao);
		Viagem viagem = dao.viagemAtivaU(usuario.getId());
		
		if(viagem == null){
			httpServletRequest.setAttribute("msg", "Não existe viagem aprovada");
			RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/privado/menuFuncionario.jsp");
			rd.forward(httpServletRequest, httpServletResponse);
			return;
		}
		System.out.println(data(viagem.getDataSaida()));
		httpServletRequest.setAttribute("viagem", viagem);
		httpServletRequest.setAttribute("dataSaida", data(viagem.getDataSaida()));
		httpServletRequest.setAttribute("dataVolta", data(viagem.getDataVolta()));
		httpServletRequest.setAttribute("status", status());
		
		RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/privado/consulta/viagemAtivaUsuarioConsulta.jsp");
		rd.forward(httpServletRequest, httpServletResponse);
	}
	
	public String data(Calendar data){
		String ano = data.get(Calendar.YEAR) + "";
		String mes = (data.get(Calendar.MONTH)+1) + "";
		String dia = data.get(Calendar.DAY_OF_MONTH) + "";
		
		Integer m = Integer.parseInt(mes);
		Integer d = Integer.parseInt(dia);
		if(m < 10){
			mes = "0" + (data.get(Calendar.MONTH)+1) + "";
		}
		if(d < 10){
			dia = "0" + data.get(Calendar.DAY_OF_MONTH);
		}
		
		String dat = ano + "-" + mes + "-" + dia;
		return dat;
	}
	
	public ArrayList<Status> status(){
		 ArrayList<Status> status =  new ArrayList<Status>();
		 
		 status.add(Status.Progresso);
		 status.add(Status.concluiu);
		 status.add(Status.falhou);
		
		return status;
	}
}
