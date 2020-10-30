package com.gama;

import java.util.List;

import com.gama.model.Campos;
import com.gama.model.Carro;
import com.gama.model.Marca;
import com.gama.repository.CarroJpaRepository;

public class PasseioApp {

	public static void main(String[] args) {
		//jpa();
		//consultaJpa()
		//consultaJpaComParametros();
		salvarCarroComMarca();
		System.exit(0);
	}
	
	public static void consultaJpaComParametros() {
		System.out.println("CONSULTA COM JPA");
		CarroJpaRepository repository = new CarroJpaRepository();
		List<Carro> carros = repository.listarPorMarca("Ford");
		
		
		for(Carro c: carros) {
			System.out.println(c);
		}
		
		carros = repository.listar(Campos.CARRO_CAPACIDADE_TANQUE,200);
		System.out.println("Listagem por modelo");
		
		for(Carro c: carros) {
			System.out.println(c);
		}
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
	public static void salvarCarroComMarca() {
		System.out.println("PERSISTENCIA COM JPA");
		CarroJpaRepository repository = new CarroJpaRepository();
		
		//Marca marca = new Marca();
		//marca.setNome("FORD");
		
		Carro carro = new Carro();
		//carro.setMarca(marca);
		carro.setModelo("Fiesta");
		carro.setCor("Azul");
		carro.setCapacidadeTanque(200);
		
		repository.incluir(carro);
	}
	/*
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
	*/
}
