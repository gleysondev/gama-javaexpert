package com.gama.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CarroJpaRepository {
	private EntityManager entityManager ;
	
	public CarroJpaRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
		entityManager = factory.createEntityManager();
	}
}
