package com.gama.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gama.model.Carro;

public class CarroJpaRepository {
	private EntityManager entityManager ;
	
	public List<Carro> listarPorMarca(String marca){
		return listar("marca", marca);
	}
	
	public List<Carro> listarPorModelo(String modelo){
		return listar("modelo", modelo);
	}
	
	public List<Carro> listar(String campo, Object valor){
		Query query = entityManager.createQuery("SELECT e FROM Carro e WHERE e." + campo + " = :param1 ");
		query.setParameter("param1",valor );
		return query.getResultList();
	}
	
	
	public CarroJpaRepository() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MY_PU");
		entityManager = factory.createEntityManager();
	}
	
	public void incluir(Carro carro) {
		entityManager.getTransaction().begin();
		entityManager.persist(carro); 
		entityManager.getTransaction().commit();
	}
	
	public Carro buscar(Integer id) {
		return entityManager.find(Carro.class,id);
	}
	
	public List<Carro> listar() {
		Query query = entityManager.createQuery("SELECT e FROM Carro e "); //JQPL
		return query.getResultList();
	}

	public void alterar(Carro carro) {
		entityManager.getTransaction().begin();
		entityManager.merge(carro);
		entityManager.getTransaction().commit();
	}
	
	
}
