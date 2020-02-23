package br.com.desktravel.model.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizaCidadeViagemLogica implements Logica{

	@Override
	public void executa(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		PreparaCadastroViagemLogica cadastroViagemLogica = new PreparaCadastroViagemLogica();
		cadastroViagemLogica.executa(httpServletRequest, httpServletResponse);
		return;
	}

}
