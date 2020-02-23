package br.com.desktravel.model;

public enum Status {
	aberto("aberto"), concluiu("concluiu"), falhou("falhou"), negado("negado"), Progresso("Progresso");
	
	public String valor;
	
	Status(String valor){
		this.valor = valor;
	}

	public String getValor(){
		return valor;
	}
}
