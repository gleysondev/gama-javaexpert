package com.gama;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gama.config.AppConfig;
import com.gama.model.Carro;

public class PasseioApp {
	public static void main(String[] args) {
		springComAnotacao();
		//springComXml();
	}
	
	private static void springComAnotacao() {
		System.out.println("Iniciando o Spring com Anota��o");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//Carro carro = ctx.getBean(Carro.class); //erro
		
				Carro fiesta = ctx.getBean("fiesta",Carro.class);
				System.out.println(fiesta);
				fiesta.setCombustivel(120);
				fiesta.setCor("AZUL");
				//fiesta.setMarca("FORD");
				//fiesta.setModelo("FISTA");
				
				System.out.println(fiesta);
				
				fiesta = ctx.getBean("fiesta",Carro.class);
				
				System.out.println(fiesta);
				//Carro l200 = ctx.getBean("l200",Carro.class);
				
				System.out.println(fiesta!=null);
				
				//System.out.println(l200!=null);
		
		
	}
	private static void springComXml() {
		System.out.println("Iniciando o Spring com Xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "beans.xml" );
	       
		//Carro carro = ctx.getBean(Carro.class); //erro
		
		Carro fiesta = ctx.getBean("fiesta",Carro.class);
		System.out.println(fiesta);
		fiesta.setCombustivel(120);
		fiesta.setCor("AZUL");
		//fiesta.setMarca("FORD");
		//fiesta.setModelo("FISTA");
		
		System.out.println(fiesta);
		
		fiesta = ctx.getBean("fiesta",Carro.class);
		
		System.out.println(fiesta);
		Carro l200 = ctx.getBean("l200",Carro.class);
		
		System.out.println(fiesta!=null);
		
		System.out.println(l200!=null);
	}
	
}
