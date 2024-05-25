package org.serratec.trabalho.grupo1.repository;

import org.serratec.trabalho.grupo1.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}