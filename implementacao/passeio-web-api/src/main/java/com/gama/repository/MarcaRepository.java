package com.gama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gama.model.Marca;

public interface MarcaRepository extends CrudRepository<Marca, Integer> {
	@Query("SELECT e FROM Marca e WHERE e.nome = :p1")
	Marca buscarPorNome(@Param("p1") String nome);
	
	Marca findByNome(String nome);
	
	List<Marca> findByNomeContaining(String nome);
	List<Marca> findByNomeLike(String nome);
	
	List<Marca> findByNomeContainingIgnoreCase(String nome);
	
	//@Query("SELECT true FROM Marca e WHERE e.nome = :nome")
	//boolean existeMarcaPorNome(String nome);
}
