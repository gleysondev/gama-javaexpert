package com.gama.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import com.gama.model.Carro;

public class CarroJpaRepository  extends Repository <Carro> {
	public List<Carro> listarPorMarca(String marca){
		return listar("marca", marca);
	}
	
	public List<Carro> listarPorModelo(String modelo){
		return listar("modelo", modelo);
	}
	
	public Carro buscar(String placa){
		Query query = entityManager.createQuery("SELECT e FROM Carro e WHERE e.placa = :placa");
		query.setParameter("placa",placa );
		
		Carro carro = null;
		try {
			carro=(Carro) query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}catch (NonUniqueResultException e) {
			throw new RuntimeException("Desculpe, Mas já temos um veículo com esta placa em nossa base de dados : " + placa);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return (Carro) query.getSingleResult();
	}
	
	
}
