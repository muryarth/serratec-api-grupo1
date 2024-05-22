package org.serratec.trabalho.grupo1.repository;

import org.serratec.trabalho.grupo1.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository <Comentario, Long>{

}
