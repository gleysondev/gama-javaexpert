package com.gama.repository;

import java.util.List;

public interface InterfaceRepository <E> {
	public void incluir(E contato);
	public void alterar(E contato);
	public E buscar(Integer id);
	public List<E> listar();
	
	//public List<E> listar(String campo, Object valor);
}
