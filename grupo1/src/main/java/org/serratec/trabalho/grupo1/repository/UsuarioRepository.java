package org.serratec.trabalho.grupo1.repository;

import org.serratec.trabalho.grupo1.dto.FollowDTO;
import org.serratec.trabalho.grupo1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);

	@Query(value = "SELECT"
			+ "    seguidor.id_usuario as id_seguidor,"
			+ "    seguidor.nome_usuario as nome_seguidor,"
			+ "    seguido.id_usuario as id_seguido,"
			+ "    seguido.nome_usuario as nome_seguido"
			+ " FROM"
			+ " Usuario seguidor"
			+ " JOIN"
			+ " Relacao r ON r.seguidor_id = seguidor.id_usuario"
			+ " JOIN"
			+ " Usuario seguido ON r.seguido_id = seguido.id_usuario"
			+ " WHERE seguido.id_usuario = 1;", nativeQuery = true )
	List<Object[]> findAllFollowers(Long id);

	@Query(value = "SELECT"
			+ "    seguidor.id_usuario as id_seguidor,"
			+ "    seguidor.nome_usuario as nome_seguidor,"
			+ "    seguido.id_usuario as id_seguido,"
			+ "    seguido.nome_usuario as nome_seguido"
			+ " FROM"
			+ " Usuario seguidor"
			+ " JOIN"
			+ " Relacao r ON r.seguidor_id = seguidor.id_usuario"
			+ " JOIN"
			+ " Usuario seguido ON r.seguido_id = seguido.id_usuario"
			+ " WHERE seguido.id_usuario = 1;", nativeQuery = true )
	List<FollowDTO> findAllFollowersById(Long id);
}
