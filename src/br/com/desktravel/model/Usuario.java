package br.com.desktravel.model;

public class Usuario{
	private int id;
	private String login;
	private String senha;
	private String nome;
	private int cod_funcionario;
	private Tipo tipo;
	private int id_superior;
	private String email;
	private String telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCod_funcionario() {
		return cod_funcionario;
	}
	public void setCod_funcionario(int cod_funcionario) {
		this.cod_funcionario = cod_funcionario;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public int getId_superior() {
		return id_superior;
	}
	public void setId_superior(int id_superior) {
		this.id_superior = id_superior;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public boolean verificarNome(){
		System.out.println(getNome());
		System.out.println(getNome().matches("[0-9]+"));
		return getNome().matches("[0-9]+");
	}
}
