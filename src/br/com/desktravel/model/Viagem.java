package br.com.desktravel.model;

import java.util.Calendar;

public class Viagem {
	private int id;
	private Usuario usuario;
	private Calendar dataSaida;
	private Calendar dataVolta;
	private int duracao;
	private boolean aprovacao;
	private boolean pendente;
	private Custo custo;
	private Custo custoR;
	private Endereco endereco;
//	private String motivo;
	private String motivoDesc;
//	private Status motivoStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean getPendente() {
		return pendente;
	}
	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}
	public Calendar getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Calendar getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(Calendar dataVolta) {
		this.dataVolta = dataVolta;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public boolean getAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(boolean aprovacao) {
		this.aprovacao = aprovacao;
	}
	public Custo getCusto() {
		return custo;
	}
	public void setCusto(Custo custo) {
		this.custo = custo;
	}
	public Custo getCustoR() {
		return custoR;
	}
	public void setCustoR(Custo custoR) {
		this.custoR = custoR;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
//	public String getMotivo() {
//		return motivo;
//	}
//	public void setMotivo(String motivo) {
//		this.motivo = motivo;
//	}
	public String getMotivoDesc() {
		return motivoDesc;
	}
	public void setMotivoDesc(String motivoDesc) {
		this.motivoDesc = motivoDesc;
	}
//	public Status getMotivoStatus() {
//		return motivoStatus;
//	}
//	public void setMotivoStatus(Status motivoStaus) {
//		this.motivoStatus = motivoStaus;
//	}
	
}
