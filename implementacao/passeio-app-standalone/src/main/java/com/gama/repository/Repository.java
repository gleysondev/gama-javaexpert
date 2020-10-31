package com.gama.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.gama.model.Carro;

public abstract class Repository <E> implements InterfaceRepository<E> {
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
	public List<E> listar(String campo,Object valor){
		return listar(campo, "=", valor);
	}
	public List<E> listar(String campo,String operador, Object valor){
		String nomeClasse = persistentClass.getName();
		Query query = entityManager.createQuery("SELECT e FROM "+  nomeClasse +" e WHERE e." + campo + " " + operador +" :param1 ");
		
		if(operador.equalsIgnoreCase("LIKE"))
			valor="%"+valor.toString()+"%";
			
			
		query.setParameter("param1",valor );
		return query.getResultList();
	}
	
}
