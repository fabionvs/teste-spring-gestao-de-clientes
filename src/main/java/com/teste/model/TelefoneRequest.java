package com.teste.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.mapping.Array;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TelefoneRequest {
	private String numero;
	private String tipo;
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
