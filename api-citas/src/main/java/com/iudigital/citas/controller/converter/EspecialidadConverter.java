package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.domain.Especialidad;

@Component
public class EspecialidadConverter {

	public Especialidad convertEspecialidadDTOToEspecialidad(EspecialidadDTO especialidadDTO) {

		Especialidad especialidad = new Especialidad();

		especialidad.setIdEspecialidad(especialidadDTO.getIdEspecialidad());
		especialidad.setNombre(especialidadDTO.getNombre());
		return especialidad;
	}
	
	public EspecialidadDTO convertEspecialidadToEspecialidadDTO(Especialidad especialidad) {

		EspecialidadDTO especialidadDTO = new EspecialidadDTO();

		especialidadDTO.setIdEspecialidad(especialidad.getIdEspecialidad());
		especialidadDTO.setNombre(especialidad.getNombre());
		return especialidadDTO;
	}

}
