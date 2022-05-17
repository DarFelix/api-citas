package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.CitaDTO;
import com.iudigital.citas.domain.Cita;

@Component
public class CitaConverter {

	public Cita convertCitaDTOToCita(CitaDTO citaDTO) {

		Cita cita = new Cita();

		cita.setIdCita(citaDTO.getIdCita());
		cita.setFechaCita(citaDTO.getFechaCita());
		cita.setIdUsuario(citaDTO.getIdUsuario());
		cita.setIdMedico(citaDTO.getIdMedico());
		cita.setIdConsulta(citaDTO.getIdConsulta());
		cita.setEstadoAtencion(citaDTO.getEstadoAtencion());
		cita.setEstadoPago(citaDTO.getEstadoPago());
		cita.setIdDescuentoMotivo(citaDTO.getIdDescuentoMotivo());
		cita.setFechaCreacion(citaDTO.getFechaCreacion());
		cita.setFechaActualizacion(citaDTO.getFechaActualizacion());

		return cita;

	}

	public CitaDTO convertCitaToCitaDTO(Cita cita) {

		CitaDTO citaDTO = new CitaDTO();

		citaDTO.setIdCita(cita.getIdCita());
		citaDTO.setFechaCita(cita.getFechaCita());
		citaDTO.setIdUsuario(cita.getIdUsuario());
		citaDTO.setIdMedico(cita.getIdMedico());
		citaDTO.setIdConsulta(cita.getIdConsulta());
		citaDTO.setEstadoAtencion(cita.getEstadoAtencion());
		citaDTO.setEstadoPago(cita.getEstadoPago());
		citaDTO.setIdDescuentoMotivo(cita.getIdDescuentoMotivo());
		citaDTO.setFechaCreacion(cita.getFechaCreacion());
		citaDTO.setFechaActualizacion(cita.getFechaActualizacion());

		return citaDTO;

	}

}
