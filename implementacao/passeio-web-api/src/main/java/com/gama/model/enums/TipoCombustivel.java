package com.gama.model.enums;

/**
 *  Tipos de Combustivel
 *  {@link #G}
 *  {@link #D}
 *  https://www.nurkiewicz.com/2013/06/mapping-enums-done-right-with-convert.html
 */
public enum TipoCombustivel {
	/**
     * GASOLINA
     */
	G("GASOLINA"), //G
	/**
     * DIESEL
     */
	D("DIESEL"); //D
	private String descricao;
	private TipoCombustivel(String descricao) {
		this.descricao=descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
