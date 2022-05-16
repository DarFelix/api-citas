package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;

import com.iudigital.citas.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findBynumeroDoc(String numeroDoc);
}
