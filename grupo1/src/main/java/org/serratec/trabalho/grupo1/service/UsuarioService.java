package org.serratec.trabalho.grupo1.service;

import org.serratec.trabalho.grupo1.exception.NotFoundException;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.serratec.trabalho.grupo1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findall(){
        return usuarioRepository.findAll();
    }
    public Usuario findById(Long id) throws NotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            throw new NotFoundException();
        }
        return usuarioOpt.get();
    }

}
