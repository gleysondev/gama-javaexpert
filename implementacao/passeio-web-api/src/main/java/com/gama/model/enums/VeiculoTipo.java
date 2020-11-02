package com.gama.model.enums;

public enum VeiculoTipo {
	QUADRICICLO (4),
	C4X4 (7),
	MOTOCICLETA (2),
	;
	
	private int lotacao;
	
	private VeiculoTipo(int lotacao) {
		this.lotacao=lotacao;
	}
	public int getLotacao() {
		return lotacao;
	}
	
}
