package com.gama.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gama.model.Carro;

@Configuration
public class AppConfig {
	@Bean(name = "fiesta")
	@Scope("prototype")
	public Carro fiesta(){
		Carro carro = new Carro();
		carro.setMarca("FORD");
		carro.setModelo("FIESTA");
        return carro;
    }
	
}
