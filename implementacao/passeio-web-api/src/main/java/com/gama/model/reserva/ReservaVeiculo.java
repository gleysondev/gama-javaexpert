package com.gama.model.reserva;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gama.model.cadastro.Veiculo;

@Entity
@Table(name = "tab_reserva_veiculo")
public class ReservaVeiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private boolean removido;
	
	@ManyToOne
	@JoinColumn(name = "id_reserva", updatable  = false)
	private Reserva reserva;

	@ManyToOne
	@JoinColumn(name = "id_veiculo", updatable  = false)
	private Veiculo veiculo;

	public boolean isRemovido() {
		return removido;
	}

	public void setRemovido(boolean removido) {
		this.removido = removido;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
}
