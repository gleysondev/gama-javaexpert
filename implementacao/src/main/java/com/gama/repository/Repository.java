package com.gama.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Repository <E> {
	protected static EntityManager entityManager ;
	private Class<E> persistentClass;
	public Repository() {
		 this.persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
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
	
	public E buscar(Integer id) {
		return (E) entityManager.find(persistentClass, id);
	}
	
	public List<E> listar() {
		Query query = entityManager.createQuery("SELECT e FROM Carro e "); //JQPL
		return query.getResultList();
	}
	
}
