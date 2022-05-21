package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.controller.dto.TratamientoDTO;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.domain.Tratamiento;

@Component
public class TratamientoConverter {

	public Tratamiento convertTratamientoDTOToTratamiento(TratamientoDTO tratamientoDTO) {

		Tratamiento tratamiento = new Tratamiento();

		tratamiento.setIdTratamiento(tratamientoDTO.getIdTratamiento());
		tratamiento.setNombre(tratamientoDTO.getNombre());

		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(tratamientoDTO.getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(tratamientoDTO.getEspecialidad().getNombre());
		tratamiento.setEspecialidad(especialidad);

		tratamiento.setDiagnostico(tratamientoDTO.getDiagnostico());
		tratamiento.setIdCita(tratamientoDTO.getIdCita());
		tratamiento.setFechaCreacion(tratamiento.getFechaCreacion());
		tratamiento.setFechaActualizacion(tratamientoDTO.getFechaActualizacion());

		return tratamiento;

	}

	public TratamientoDTO convertTratamientoToTratamientoDTO(Tratamiento tratamiento) {

		TratamientoDTO tratamientoDTO = new TratamientoDTO();

		tratamientoDTO.setIdTratamiento(tratamiento.getIdTratamiento());
		tratamientoDTO.setNombre(tratamiento.getNombre());

		EspecialidadDTO especialidad = new EspecialidadDTO();
		especialidad.setIdEspecialidad(tratamiento.getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(tratamiento.getEspecialidad().getNombre());
		tratamientoDTO.setEspecialidad(especialidad);

		tratamientoDTO.setDiagnostico(tratamiento.getDiagnostico());
		tratamientoDTO.setIdCita(tratamiento.getIdCita());
		tratamientoDTO.setFechaCreacion(tratamiento.getFechaCreacion());
		tratamientoDTO.setFechaActualizacion(tratamiento.getFechaActualizacion());

		return tratamientoDTO;

	}

}
