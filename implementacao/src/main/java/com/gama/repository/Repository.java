package com.gama.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Repository <E,ID> {
	protected static EntityManager entityManager ;
	
	public static void criarConexao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
		if(entityManager==null)
			entityManager = factory.createEntityManager();
	}
	
	public void incluir(E entidade) {
		entityManager.getTransaction().begin();
		entityManager.persist(entidade); 
		entityManager.getTransaction().commit();
	}
	public void alterar(E entidade) {
		entityManager.getTransaction().begin();
		entityManager.merge(entidade); 
		entityManager.getTransaction().commit();
	}
	
}
