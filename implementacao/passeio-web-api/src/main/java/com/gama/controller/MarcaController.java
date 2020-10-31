package com.gama.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/marcas")
public class MarcaController {
	@GetMapping("/marcas")
	public String hello() {
		return "Ola Marcas";
	}
}
