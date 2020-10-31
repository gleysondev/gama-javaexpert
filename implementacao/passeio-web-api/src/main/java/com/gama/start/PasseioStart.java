package com.gama.start;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gama.model.Carro;
import com.gama.model.Marca;
import com.gama.repository.CarroRepository;
import com.gama.repository.MarcaRepository;


@Component
public class PasseioStart {
	private static int contator = 0;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
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
		//garantir que só haja uma marca HYUNDAY no banco de dados
		String nome= "HYUNDAY";
		
		//boolean existe = marcaRepository.existeMarcaPorNome(nome);
		//List<Marca> marcas = marcaRepository.findByNomeContaining(nome);
		String comecaCom = nome+"%";
		List<Marca> marcas = marcaRepository.findByNomeLike(comecaCom);
		marcas = marcaRepository.findByNomeContainingIgnoreCase("hyunday");
		
		Marca marca =marcaRepository.findByNome(nome);
		if(marca==null) {
			marca= new Marca();
			marca.setNome(nome);
			
			marcaRepository.save(marca);
		}
	}
	private void gerenciarCarros() {
		
		//cadastrar 1 carro com a PLAXA ABC-1234
		
		
		Carro carro = new Carro();
		carro.setCapacidadeTanque(100);
		carro.setCor("PRETA");
		
		//localizar a marca e incluir no novo carro
		
		//carro.setMarca(marca);
		carro.setModelo("HB-20");
		
		
	}
}
