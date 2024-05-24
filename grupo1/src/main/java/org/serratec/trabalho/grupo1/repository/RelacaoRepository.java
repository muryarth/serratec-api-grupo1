package org.serratec.trabalho.grupo1.repository;

import org.serratec.trabalho.grupo1.model.Relacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelacaoRepository extends JpaRepository<Relacao, Long> {

    @Query(value = "select r from relacao r where r.seguido_id = :id", nativeQuery=true)
    List<Relacao> findAllFollowersByUserId(Long id);

    @Query(value = "select r from relacao r where r.seguidor_id = :id", nativeQuery=true)
    List<Relacao> findAllFollowingById(Long id);
}
