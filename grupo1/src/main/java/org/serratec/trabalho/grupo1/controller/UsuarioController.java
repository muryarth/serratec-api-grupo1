package org.serratec.trabalho.grupo1.controller;

import org.serratec.trabalho.grupo1.dto.UsuarioDTO;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar(){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}
}
