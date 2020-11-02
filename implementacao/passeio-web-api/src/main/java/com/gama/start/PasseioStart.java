package com.gama.start;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gama.model.cadastro.Cliente;
import com.gama.model.cadastro.Marca;
import com.gama.model.cadastro.Telefone;
import com.gama.model.cadastro.Veiculo;
import com.gama.repository.ClienteRepository;
import com.gama.repository.MarcaRepository;
import com.gama.repository.VeiculoRepository;


@Component
public class PasseioStart {
	private static int contator = 0;
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private VeiculoRepository carroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Value("${meunome}")
	private String nome;
	
	
	public void salvarCliente() {
		Cliente gleyson = new Cliente();
		gleyson.setNome("GLEYSON SAMPAIO");
		gleyson.setCpf("123123");
		gleyson.setDataNascimento(new Date());
		gleyson.setEmail("gleysodev@gmail.com");
		gleyson.setNumeroCnh("123123");
		
		Telefone celular = new Telefone();
		celular.setDdd(11);
		celular.setNumero(958940362L);
		
		Telefone whatsapp = new Telefone();
		whatsapp.setDdd(11);
		whatsapp.setNumero(958940362L);
		
		gleyson.setCelular(celular);
		gleyson.setWhatsapp(whatsapp);
		
		//clienteRepository.save(gleyson);
		
		Optional<Cliente> cliente = clienteRepository.findById(1);
		
		System.out.println(cliente.get());
		
	}
	
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
		
		
		Veiculo carro = new Veiculo();
		carro.setCapacidadeTanque(100);
		carro.setCor("PRETA");
		
		//localizar a marca e incluir no novo carro
		
		//carro.setMarca(marca);
		carro.setModelo("HB-20");
		
		
	}
}
