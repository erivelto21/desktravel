package br.com.desktravel.adaptadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.desktravel.model.Custo;

public class AdaptadorViagem {
	
	public static boolean getPendente(String situacao){
		switch(situacao){
			case "Pendente":
				return true;
			case "Aprovado":
				return false;
			case "Negada":
				return false;
			case "Concluida":
				return true;
		}
		
		return false;
	}
	
	public static boolean getaprovacao(String situacao){
		switch(situacao){
			case "Pendente":
				return false;
			case "Aprovado":
				return true;
			case "Negada":
				return false;
			case "Concluida":
				return true;
			default:
				return false;
		}
		
	}
	
	public static Date dataSaida(String data){
		data = data.replace('/', '-');
		
		SimpleDateFormat dataF = new SimpleDateFormat("dd-MM-yyyy");
		
		Date dataT = null;
		try {
			dataT = dataF.parse(data);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataT;
	}
	
	public static Date dataVolta(String data, int dias){
		data = data.replace('/', '-');

		SimpleDateFormat dataF = new SimpleDateFormat("dd-MM-yyyy");
		Date dataT = null;
		try {
			dataT = dataF.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(dataT);
		c.add(Calendar.DATE, dias);
		
		return c.getTime();
	}
	
	public static Custo custo(float alimentacao, float combustivel, float hospedagem, float outroV, String desc){
		Custo custo = new Custo();
		
		double ali = Fd(alimentacao);
		double com = Fd(combustivel);
		double hos = Fd(hospedagem);
		double ou = Fd(outroV);
		
		custo.setAlimentacao(ali);
		custo.setCombustivel(com);
		custo.setHospedagem(hos);
		custo.setOutrosGastos(ou);
		custo.setDescOG(desc);
		
		return custo;
	}
	
	public static double Fd(float valor){
		String aux = "" + valor;
		return Double.parseDouble(aux);
	}
	
	public static float valor(double valor){
		return (float) valor;
	}
	
	public static float total(double h, double c, double a, double o){
		return (float) (h + c + a + o);
	}
	
	public static String situacao(boolean aprovacao, boolean pendente){
		if(aprovacao == false && pendente == false){
			return "Negada";
		}else if(aprovacao == true && pendente == true){
			return "Concluida";
		}else if(aprovacao == false && pendente == true){
			return "Pendente";
		}else if(aprovacao == true && pendente == false){
			return "Aprovado";
		}
		
		return "";
	}
	
	public static String data(Calendar c){
		Date date = c.getTime();
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		return fmt.format(date);
	}
}
