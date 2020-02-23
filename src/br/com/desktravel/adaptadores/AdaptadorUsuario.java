package br.com.desktravel.adaptadores;

import br.com.desktravel.model.Tipo;

public class AdaptadorUsuario {

	public static Tipo getTipoUsuario(String tipo){
		switch(tipo){
			case"ADM":
				Tipo tipo1 = new Tipo();
				tipo1.setId(1);
				tipo1.setGenero("adm");
				return tipo1;
			case "Gestor":
				Tipo tipo2 = new Tipo();
				tipo2.setId(2);
				tipo2.setGenero("gestor");
				return tipo2;
			case "Colaborador":
				Tipo tipo3 = new Tipo();
				tipo3.setId(3);
				tipo3.setGenero("gestor");
				return tipo3;
			default:
				return null;
		}
	}
	
	public static String getTipo_funcionario(Tipo tipo){
		switch(tipo.getId()){
			case 1:
				return "ADM";
			case 2:
				return "Gestor";
			case 3:
				return "Colaborador";
			default :
				return "";
		}
	}
}
