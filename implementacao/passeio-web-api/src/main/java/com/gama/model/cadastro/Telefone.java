package com.gama.model.cadastro;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {
	private Integer ddd;
	private Long numero;
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
}
