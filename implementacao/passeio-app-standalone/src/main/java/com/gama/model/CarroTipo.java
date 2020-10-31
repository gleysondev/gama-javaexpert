package com.gama.model;

public enum CarroTipo {
	QUADRICICLO (4),
	C4X4 (7),
	MOTOCICLETA (2),
	;
	
	private int lotacao;
	
	private CarroTipo(int lotacao) {
		this.lotacao=lotacao;
	}
	public int getLotacao() {
		return lotacao;
	}
	
}
