package com.gama.repository;

import java.util.List;

import javax.persistence.Query;

import com.gama.model.Marca;

public class MarcaJpaRepository extends Repository <Marca> {
	
	public List<Marca> listar() {
		Query query = entityManager.createQuery("SELECT e FROM Marca e "); //JQPL
		return query.getResultList();
	}	
}
