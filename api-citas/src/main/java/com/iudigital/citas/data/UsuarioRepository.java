package com.iudigital.citas.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findBynumeroDoc(String numeroDoc);
	
	@Query(value = "select * from usuarios u where u.usuario_id = :idUsuario and u.especialidad_id is not null ", nativeQuery = true)
	public Usuario findMedicoById (int idUsuario);
	
}
