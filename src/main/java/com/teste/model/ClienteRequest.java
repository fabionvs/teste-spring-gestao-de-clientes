package com.teste.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.mapping.Array;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteRequest implements Serializable {

	private String nome;

	private String cpf;

	private String cep;

	private String cidade;

	private String bairro;

	private String uf;

	private String complemento;

	private String logradouro;

	private List<EmailRequest> emails;

	private List<TelefoneRequest> telefones;

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public List<EmailRequest> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailRequest> emails) {
		this.emails = emails;
	}

	public List<TelefoneRequest> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneRequest> telefones) {
		this.telefones = telefones;
	}

}