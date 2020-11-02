package com.gama.model.reserva;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataCheckin;
	private Date dataCheckout;
	private Double taxaReserva;
	private Double valorLocacao;
	private String numeroReserva;
	private Integer numeroDias;
	
	@OneToMany(mappedBy = "reserva")
	private List<ReservaVeiculo> veiculos;
	
	public List<ReservaVeiculo> getVeiculos() {
		return veiculos;
	}
	
	public void setVeiculos(List<ReservaVeiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataCheckin() {
		return dataCheckin;
	}
	public void setDataCheckin(Date dataCheckin) {
		this.dataCheckin = dataCheckin;
	}
	public Date getDataCheckout() {
		return dataCheckout;
	}
	public void setDataCheckout(Date dataCheckout) {
		this.dataCheckout = dataCheckout;
	}
	public Double getTaxaReserva() {
		return taxaReserva;
	}
	public void setTaxaReserva(Double taxaReserva) {
		this.taxaReserva = taxaReserva;
	}
	public Double getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(Double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	public String getNumeroReserva() {
		return numeroReserva;
	}
	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	public Integer getNumeroDias() {
		return numeroDias;
	}
	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}
	
	
	
}
