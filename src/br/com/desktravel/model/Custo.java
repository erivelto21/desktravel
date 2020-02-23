package br.com.desktravel.model;

import java.text.DecimalFormat;

public class Custo {
	private int id;
	private double combustivel;
	private double hospedagem;
	private double alimentacao;
	private double outrosGastos;
	private String descOG;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(double combustivel) {
		this.combustivel = combustivel;
	}
	public double getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(double hospedagem) {
		this.hospedagem = hospedagem;
	}
	public double getAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(double alimentacao) {
		this.alimentacao = alimentacao;
	}
	public double getOutrosGastos() {
		return outrosGastos;
	}
	public void setOutrosGastos(double outrosGastos) {
		this.outrosGastos = outrosGastos;
	}
	public String getTotal(){
		double resultado = this.alimentacao + this.combustivel + this.hospedagem + this.outrosGastos;
		DecimalFormat dx = new DecimalFormat("0.##");
		
		return dx.format(resultado);
	}
	public String getDescOG() {
		return descOG;
	}
	public void setDescOG(String descOG) {
		this.descOG = descOG;
	}
	
}
