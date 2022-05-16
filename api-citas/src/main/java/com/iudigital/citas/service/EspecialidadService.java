package com.iudigital.citas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.EspecialidadRepository;
import com.iudigital.citas.domain.Especialidad;

@Service
public class EspecialidadService {

	@Autowired
	private EspecialidadRepository especialidadRepository;

	public void createEspecialidad(Especialidad especialidad) {
		especialidadRepository.save(especialidad);

	}
	
	public List<Especialidad> getEspecialidades() {
		List<Especialidad> especialidades = (List<Especialidad>) especialidadRepository.findAll();
		return especialidades;
	}
	
	public void editEspecialidad(int idEspecialidad, Especialidad especialidad) throws Exception {

		Especialidad especialidadUpdate = especialidadRepository.findById(idEspecialidad);

		if (especialidadUpdate != null) {

			especialidadUpdate.setNombre(especialidad.getNombre());


			especialidadRepository.save(especialidadUpdate);
		} else {
			throw new Exception("No existe especialidad");
		}

	}
}
