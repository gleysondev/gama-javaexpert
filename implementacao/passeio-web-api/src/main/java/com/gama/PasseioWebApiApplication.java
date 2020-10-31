package com.gama;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gama.start.PasseioStart;

@SpringBootApplication
public class PasseioWebApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(PasseioWebApiApplication.class, args);
		//PasseioStart start = run.getBean(PasseioStart.class);
		//start.iniciar();		
	}

}
