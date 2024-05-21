package org.serratec.trabalho.grupo1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@GetMapping
	public ResponseEntity<String> teste(){
		return ResponseEntity.ok("Teste!");
	}
}
