package org.serratec.trabalho.grupo1.repository;

import org.serratec.trabalho.grupo1.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}