package com.teste.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_telefones")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "numero")
	private String numero;
	
	@Column(name = "tipo")
	private String tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente.id")
	@JsonIgnore
	private Clientes cliente;


	public Telefone(String numero, String tipo, Clientes cliente) {
		this.numero = numero;
		this.tipo = tipo;
		this.cliente = cliente;
	}
	
	public Telefone() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
