package org.serratec.trabalho.grupo1.repository;

import jakarta.transaction.Transactional;
import org.serratec.trabalho.grupo1.model.Relacao;
import org.serratec.trabalho.grupo1.model.RelacaoPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RelacaoRepository extends JpaRepository<Relacao, RelacaoPK> {

    @Query(value = "SELECT * FROM relacao WHERE seguido_id = :id", nativeQuery = true)
    Page<Relacao> findAllFollowersByUserId(Long id, Pageable pageable);

    @Query(value = "SELECT * FROM relacao WHERE seguidor_id = :id", nativeQuery = true)
    Page<Relacao> findAllFollowingByUserId(Long id, Pageable pageable);

    @Query(value = "SELECT * FROM relacao WHERE seguido_id = :id", nativeQuery = true)
    List<Relacao> findAllFollowersByUserId(Long id);

    @Query(value = "SELECT * FROM relacao WHERE seguidor_id = :id", nativeQuery = true)
    List<Relacao> findAllFollowingByUserId(Long id);

    @Query(value = "SELECT * FROM relacao WHERE seguido_id = :primaryId and seguidor_id = :secondaryId", nativeQuery = true)
    Optional<Relacao> findByCompositeId(Long primaryId, Long secondaryId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM relacao WHERE seguido_id = :primaryId AND seguidor_id = :secondaryId", nativeQuery = true)
    void deleteByCompositeId(Long primaryId, Long secondaryId);
}
