package com.gama;

import java.util.List;

import com.gama.model.Carro;
import com.gama.repository.CarroJpaRepository;

public class PasseioApp {

	public static void main(String[] args) {
		jpa();
		consultaJpa();
	}
	
	public static void consultaJpa() {
		System.out.println("CONSULTA COM JPA");
		CarroJpaRepository repository = new CarroJpaRepository();
		
		Carro carro = repository.buscar(1);
		
		System.out.println("O carro com id=1 é " + carro.getModelo());
		
		List<Carro>carros = repository.listar();
		
		for(Carro c:carros) {
			System.out.println(c.getMarca() + " Modelo: " + c.getModelo());
		}
		
	}
	public static void jpa() {
		System.out.println("PERSISTENCIA COM JPA");
		CarroJpaRepository repository = new CarroJpaRepository();
		
		Carro carro = new Carro();
		carro.setMarca("Ford");
		carro.setModelo("Fiesta");
		carro.setCor("Azul");
		carro.setCapacidadeTanque(200);
		
		repository.incluir(carro);
		
		carro = new Carro();
		carro.setMarca("Mitsubishi");
		carro.setModelo("L-200");
		carro.setCor("Preata");
		carro.setCapacidadeTanque(250);
		
		repository.incluir(carro);
		
		carro = repository.buscar(1);
		
		if(carro!=null) {
			System.out.println(carro.getModelo());
			carro.setModelo("Novo modelo");
			repository.alterar(carro);
		}
	}
}
