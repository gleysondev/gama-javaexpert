package com.gama.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gama.model.Marca;
import com.gama.repository.MarcaRepository;


@RestController
@RequestMapping("/marcas")
public class MarcaController {
	@Autowired
	private MarcaRepository repository;
	
	@GetMapping
	public Iterable<Marca> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/filter")
	public Iterable<Marca> listar(@RequestParam("nome") String nome) {
		return repository.findByNomeContaining(nome);
	}
	
	@GetMapping("/{id}")
	public Marca buscar(@PathVariable(value="id") Integer id) {
		Optional<Marca> opt = repository.findById(id);
		return opt.get() ;
	}
	
	@PostMapping
	public void save(@RequestBody Marca marca) {
		repository.save(marca);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Integer id) {
		repository.deleteById(id);
	}
	
	@PutMapping
	public void update(Marca marca) {
		repository.save(marca);
	}
	
}
