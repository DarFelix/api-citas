package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Especialidad;

@Repository
public interface EspecialidadRepository extends CrudRepository<Especialidad, Integer>{

	public Especialidad findById(int idEspecialidad);
}
