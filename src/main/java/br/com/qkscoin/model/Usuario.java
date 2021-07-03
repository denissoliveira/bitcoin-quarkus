package br.com.qkscoin.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

//Padrão é chamado de Active Records
@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	@Username private String username;
	@Password private String password;
	@Roles private String role;
	
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
		private String nome;
		private String cpf;
		
		//Opcional
		private String username;
		private String password;
		private Long id;
		private String role;
		
		public Builder(String nome, String cpf) {
			this.nome = nome;
			this.cpf = cpf;
		}
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder role(String role) {
			this.role = role;
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
		this.role = builder.role;
	}
	
	public static void adicionar(Usuario usuario) {
		usuario.password = BcryptUtil.bcryptHash(usuario.password);
		usuario.role = validarUsername(usuario.username);
		usuario.persist();
	}
	
	private static String validarUsername(String username) {
		return username.equals("admin")? "admin" : "user";
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
	@JsonbTransient
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
