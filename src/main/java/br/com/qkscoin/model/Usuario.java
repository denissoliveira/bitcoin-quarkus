package br.com.qkscoin.model;

public class Usuario {
	
	private Long id;
	private String nome;
	private String cpf;
	private String username;
	private String password;
	
	public Usuario() {}
	
	public Usuario(Long id, String nome, String cpf, String username, String password) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.password = password;
	}
	
	//Builder
	public static class Builder {
		
		//Requerido
		private Long id;
		private String nome;
		private String cpf;
		
		//Opcional
		private String username;
		private String password;
		
		public Builder(Long id, String nome, String cpf) {
			this.id = id;
			this.nome = nome;
			this.cpf = cpf;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Usuario build() {
			return new Usuario(this);
		}
	}
	
	private Usuario(Builder builder) {
		this.id = builder.id;
		this.nome = builder.nome;
		this.cpf = builder.cpf;
		this.username = builder.username;
		this.password = builder.password;
	}
	
	//Gets and Sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
