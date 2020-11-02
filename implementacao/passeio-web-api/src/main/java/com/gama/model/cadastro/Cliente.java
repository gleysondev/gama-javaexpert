package com.gama.model.cadastro;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	@Column(name = "numero_cnh", length = 30)
	private String numeroCnh;
	private String cpf;
	private String email;
	
	@Embedded
	private Telefone celular;
	
	@Embedded
	 @AttributeOverrides({
	    @AttributeOverride(name="ddd",column=@Column(name="whats_ddd")),
	    @AttributeOverride(name="numero",column=@Column(name="whats_numero"))
	  })
	private Telefone whatsapp;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroCnh() {
		return numeroCnh;
	}
	public void setNumeroCnh(String numeroCnh) {
		this.numeroCnh = numeroCnh;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Telefone getCelular() {
		return celular;
	}
	public void setCelular(Telefone celular) {
		this.celular = celular;
	}
	public Telefone getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(Telefone whatsapp) {
		this.whatsapp = whatsapp;
	}
	
}
