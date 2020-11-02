package com.gama.repository;

import org.springframework.data.repository.CrudRepository;

import com.gama.model.cadastro.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
