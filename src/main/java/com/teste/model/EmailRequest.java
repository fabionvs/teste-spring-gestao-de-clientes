package com.teste.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.mapping.Array;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmailRequest {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
