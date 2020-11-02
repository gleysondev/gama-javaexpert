package com.gama.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gama.model.enums.TipoCombustivel;
import com.gama.model.enums.VeiculoTipo;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	//@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private VeiculoTipo tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private TipoCombustivel tipoCombustivel;
	
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}
	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}
	
	private boolean disponivel;
	
	private Double preco;
	
	
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Veiculo() {
		this.tipo = VeiculoTipo.C4X4;
	}
	
	private String modelo;
	
	private String placa;
	
	private String cor;
	
	public void setTipo(VeiculoTipo tipo) {
		this.tipo = tipo;
	}
	public VeiculoTipo getTipo() {
		return tipo;
	}
	
	@Column(name="capacidade_tanque")
	private Integer capacidadeTanque;

	public Integer getId() {
		return id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}


	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", cor=" + cor + ", capacidadeTanque="
				+ capacidadeTanque + "]";
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
