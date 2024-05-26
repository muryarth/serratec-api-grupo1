package org.serratec.trabalho.grupo1.service;

import java.util.Optional;

import org.serratec.trabalho.grupo1.model.Perfil;
import org.serratec.trabalho.grupo1.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public Perfil buscar(Long id) {
		Optional<Perfil> perfilOpt = perfilRepository.findById(id);
		return perfilOpt.get();
	}

}
