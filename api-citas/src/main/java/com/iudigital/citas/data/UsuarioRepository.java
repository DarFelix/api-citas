package com.iudigital.citas.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>,
		PagingAndSortingRepository<Usuario, Integer>, JpaSpecificationExecutor<Usuario> {

	public Usuario findBynumeroDoc(String numeroDoc);

	@Query(value = "select * from usuarios u where u.usuario_id = :idUsuario and u.especialidad_id is not null ", nativeQuery = true)
	public Usuario findMedicoById(int idUsuario);
	
	public Optional<Usuario> findByCorreo(String correo);
	
	@Query(value = "select * from usuarios u where u.especialidad_id = :idEspecialidad", nativeQuery = true)
	public List<Usuario> findMedicoByEspecialidad(Integer idEspecialidad);

}
