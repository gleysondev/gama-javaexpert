package com.gama.repository;

import java.util.List;

import javax.persistence.Query;

import com.gama.model.Marca;

public class MarcaJpaRepository extends Repository {
	
	
	public void incluir(Marca marca) {
		entityManager.getTransaction().begin();
		entityManager.persist(marca); 
		entityManager.getTransaction().commit();
	}
	
	public Marca buscar(Integer id) {
		return entityManager.find(Marca.class,id);
	}
	
	public List<Marca> listar() {
		Query query = entityManager.createQuery("SELECT e FROM Marca e "); //JQPL
		return query.getResultList();
	}

	public void alterar(Marca marca) {
		entityManager.getTransaction().begin();
		entityManager.merge(marca);
		entityManager.getTransaction().commit();
	}
	
	
}
