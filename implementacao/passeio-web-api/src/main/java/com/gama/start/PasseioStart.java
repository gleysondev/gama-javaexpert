package com.gama.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gama.model.Carro;
import com.gama.model.Marca;
import com.gama.repository.MarcaRepository;


@Component
public class PasseioStart {
	private static int contator = 0;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Value("${meunome}")
	private String nome;
	
	public PasseioStart() {
		//System.out.println("Nova classe passeio");
		contator++;
		//System.out.println("Numero de Instancias " + contator);
	}
	public void iniciar() {
		System.out.println("NOME É " + nome);
		System.out.println("Iniciando um compenente Spring ");
		gerenciarMarcas();
	}
	private void gerenciarMarcas() {
	
		Marca marca = new Marca();
		marca.setNome("HYUNDAY");
		
		marcaRepository.save(marca);
	}
	private void gerenciarCarros() {
		Carro carro = new Carro();
		carro.setCapacidadeTanque(100);
		carro.setCor("PRETA");
		//carro.setMarca(marca);
		carro.setModelo("HB-20");
		
		//CarroRepository carroRepository = ctx.getBean();
	}
}
