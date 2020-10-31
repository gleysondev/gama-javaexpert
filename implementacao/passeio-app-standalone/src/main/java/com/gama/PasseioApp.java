package com.gama;

import java.util.List;

import com.gama.model.Campos;
import com.gama.model.Carro;
import com.gama.model.CarroTipo;
import com.gama.model.Marca;
import com.gama.repository.CarroJpaRepository;
import com.gama.repository.MarcaJpaRepository;
import com.gama.repository.Repository;

public class PasseioApp {

	public static void main(String[] args) {
		Repository.criarConexao();
		//jpa();
		//consultaJpa()
		//consultaJpaComParametros();
		
		try {
			listarAsMarcas();
			salvarCarroComMarca();
		}catch (Exception e) {
			System.err.println("Algum erro aconteceu");
			e.printStackTrace();
		}finally {
			System.out.println("O finally executou");
			System.exit(0);
		}
		
	}
	public static void listarAsMarcas() {
		System.out.println("CONSULTANDO MARCAS");
		MarcaJpaRepository repository = new MarcaJpaRepository();
		
		
		List<Marca> marcas = repository.listar("nome", "LIKE", "FORD");
		
		for(Marca marca:marcas) {
			System.out.println(marca.getNome());
		}
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
		
		MarcaJpaRepository marcaRepository = new MarcaJpaRepository();
		
		Marca marca = marcaRepository.buscar(1);
		if(marca==null) {
			marca= new Marca();
			marca.setNome("FORD");
			marcaRepository.incluir(marca);
		}
		
		//marcaRepository.incluir(marca);
		
		System.out.println("PERSISTENCIA COM JPA");
		CarroJpaRepository repository = new CarroJpaRepository();
		
		String placa = "ABC-5678";
		
		Carro carro =  repository.buscar(placa);
		if(carro==null) {
			carro = new Carro();
			carro.setMarca(marca);
			carro.setModelo("Fiesta ABC");
			carro.setCor("Azul");
			carro.setPlaca(placa);
			carro.setCapacidadeTanque(200);
			repository.incluir(carro);
			
			System.out.println("Inclusao do Carro");
		}else {
			if(carro.getTipo()==null)
				carro.setTipo(CarroTipo.C4X4);
			System.out.println("O tipo do meu carro é " + carro.getTipo() + " Com a lotacao " + carro.getTipo().getLotacao());
			carro.setCor("Azul Marinho");
			carro.setTipo(CarroTipo.MOTOCICLETA);
			repository.alterar(carro);
			System.out.println("Alteracao do Carro");
		}
		
		
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
