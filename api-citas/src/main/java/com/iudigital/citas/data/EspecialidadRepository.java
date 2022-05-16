package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;

import com.iudigital.citas.domain.Especialidad;

public interface EspecialidadRepository extends CrudRepository<Especialidad, Integer>{

	public Especialidad findById(int idEspecialidad);
}
