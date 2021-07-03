package br.com.qkscoin.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preco;
	private String tipo;
	private LocalDate data;
	private String status;
	@Column(name = "user_id") private Long userId;
	
	public Ordem() {}
	
	//Builder
	public static class Builder {
		
		//Requerido
		private Double preco;
		private String tipo;
		private LocalDate data;
		private String status;
		
		//Opcional
		private Long id;
		private Long userId;
		
		public Builder(Double preco, String tipo, LocalDate data, String status) {
			super();
			this.preco = preco;
			this.tipo = tipo;
			this.data = data;
			this.status = status;
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder userId(Long userId) {
			this.userId = userId;
			return this;
		}
		
		public Ordem build() {
			return new Ordem(this);
		}
	}
	
	private Ordem(Builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.preco = builder.preco;
		this.tipo = builder.tipo;
		this.data = builder.data;
		this.status = builder.status;
	}
	
	//Gets and Sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
