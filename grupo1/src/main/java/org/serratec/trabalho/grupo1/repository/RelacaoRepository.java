package org.serratec.trabalho.grupo1.repository;

import org.serratec.trabalho.grupo1.model.Relacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacaoRepository extends JpaRepository<Relacao, Long> {
}
