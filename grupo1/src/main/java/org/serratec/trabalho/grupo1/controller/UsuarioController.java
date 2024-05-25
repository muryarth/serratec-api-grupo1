package org.serratec.trabalho.grupo1.controller;

import org.serratec.trabalho.grupo1.dto.RelacaoDTO;
import org.serratec.trabalho.grupo1.dto.UsuarioDTO;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	/* Operações básicas do próprio Usuário */
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar() {
		UserDetails details = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		System.out.println("Login do usuario: " + details.getUsername());
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}
	
	@PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody Usuario usuario) {
        UsuarioDTO usuarioDTO = usuarioService.create(usuario);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioDTO.getId_usuario())
                .toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario novoUsuario) {
        UsuarioDTO usuarioDTO = usuarioService.alterar(id, novoUsuario);
        return ResponseEntity.ok(usuarioDTO);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	/* Operações na tabela de Relações */

	@GetMapping("/{id}/relacoes/seguidores")
	public ResponseEntity<List<RelacaoDTO>> listarTodosSeguidores(@PathVariable Long id){
		return ResponseEntity.ok(usuarioService.findAllFollowersById(id));
	}

	@GetMapping("/{id}/relacoes/seguindo")
	public ResponseEntity<List<RelacaoDTO>> listarTodosSeguindo(@PathVariable Long id){
		return ResponseEntity.ok(usuarioService.findAllFollowingById(id));
	}
}
