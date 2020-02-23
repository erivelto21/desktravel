package br.com.desktravel.model.logica;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desktravel.dao.UsuarioDAO;
import br.com.desktravel.dao.ViagemDAO;
import br.com.desktravel.model.Usuario;
import br.com.desktravel.model.Viagem;

public class RemoveUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		
		Connection conexao = (Connection) httpServletRequest.getAttribute("conexao");
		
		String idUsuarioRemoveS =  httpServletRequest.getParameter("idF");
		int idUsuarioRemove = Integer.parseInt(idUsuarioRemoveS);

		UsuarioDAO dao = new UsuarioDAO(conexao);
		
		removerSubordinados(idUsuarioRemove, dao, conexao);
		
		dao.remove(idUsuarioRemove);
		
		PreparaRemoveUsuarioLogica pru = new PreparaRemoveUsuarioLogica();
		pru.executa(httpServletRequest, httpServletResponse);
	}
	
	public void removerSubordinados(int id, UsuarioDAO dao, Connection conexao){
		ArrayList<Usuario> subordinados = dao.subordinadosG(id);
		
		if(!subordinados.isEmpty()){
			for(Usuario u : subordinados){
				removerViagens(u.getId(), conexao);
				dao.remove(u.getId());
			}
		}else{
			removerViagens(id, conexao);
		}
	}

	public void removerViagens(int id, Connection conexao){
		ViagemDAO dao = new ViagemDAO(conexao);
		
		ArrayList<Viagem> viagens = dao.viagensUsuario(id);

		for(Viagem v : viagens){
			dao.remove(v.getId());
		}
	}
}
