package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.CitaDTO;
import com.iudigital.citas.controller.dto.ConsultaDTO;
import com.iudigital.citas.controller.dto.DescuentoMotivoDTO;
import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.controller.dto.MotivoDTO;
import com.iudigital.citas.controller.dto.TipoCitaDTO;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.domain.DescuentoMotivo;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.domain.Motivo;
import com.iudigital.citas.domain.TipoCita;
import com.iudigital.citas.domain.Usuario;

@Component
public class CitaConverter {

	public Cita convertCitaDTOToCita(CitaDTO citaDTO) {

		Cita cita = new Cita();

		cita.setIdCita(citaDTO.getIdCita());
		cita.setFechaCita(citaDTO.getFechaCita());
		
		Usuario usuario = new Usuario();
		
		cita.setUsuario(citaDTO.getIdUsuario());
		
		
		
		cita.setIdMedico(citaDTO.getIdMedico());
		
		Consulta consulta = new Consulta();
		consulta.setIdConsulta(citaDTO.getConsulta().getIdConsulta());
		TipoCita tipoCita = new TipoCita();
		tipoCita.setIdTipoCita(citaDTO.getConsulta().getTipoCita().getIdTipoCita());
		tipoCita.setNombre(citaDTO.getConsulta().getTipoCita().getNombre());
		consulta.setTipoCita(tipoCita);
		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(citaDTO.getConsulta().getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(citaDTO.getConsulta().getEspecialidad().getNombre());
		consulta.setEspecialidad(especialidad);
		consulta.setCosto(citaDTO.getConsulta().getCosto());
		cita.setConsulta(consulta);
		
		cita.setEstadoAtencion(citaDTO.getEstadoAtencion());
		cita.setEstadoPago(citaDTO.getEstadoPago());
		
		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();
		descuentoMotivo.setIdDescuentoMotivo(citaDTO.getDescuentoMotivo().getIdDescuentoMotivo());
		Motivo motivo = new Motivo();
		motivo.setIdMotivo(citaDTO.getDescuentoMotivo().getMotivo().getIdMotivo());
		motivo.setNombre(citaDTO.getDescuentoMotivo().getMotivo().getNombre());
		descuentoMotivo.setMotivo(motivo);
		descuentoMotivo.setPorcentaje(citaDTO.getDescuentoMotivo().getPorcentaje());
		descuentoMotivo.setEstadoDescuento(citaDTO.getDescuentoMotivo().getEstadoDescuento());
		descuentoMotivo.setFechaCreacion(citaDTO.getDescuentoMotivo().getFechaCreacion());
		descuentoMotivo.setFechaActualizacion(citaDTO.getDescuentoMotivo().getFechaActualizacion());
		
		
		cita.setDescuentoMotivo(descuentoMotivo);
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
		
		ConsultaDTO consulta = new ConsultaDTO();
		consulta.setIdConsulta(cita.getConsulta().getIdConsulta());
		TipoCitaDTO tipoCita = new TipoCitaDTO();
		tipoCita.setIdTipoCita(cita.getConsulta().getTipoCita().getIdTipoCita());
		tipoCita.setNombre(cita.getConsulta().getTipoCita().getNombre());
		consulta.setTipoCita(tipoCita);
		EspecialidadDTO especialidad = new EspecialidadDTO();
		especialidad.setIdEspecialidad(cita.getConsulta().getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(cita.getConsulta().getEspecialidad().getNombre());
		consulta.setEspecialidad(especialidad);
		consulta.setCosto(cita.getConsulta().getCosto());
		citaDTO.setConsulta(consulta);
		
		citaDTO.setEstadoAtencion(cita.getEstadoAtencion());
		citaDTO.setEstadoPago(cita.getEstadoPago());
		
		DescuentoMotivoDTO descuentoMotivoDTO = new DescuentoMotivoDTO();
		descuentoMotivoDTO.setIdDescuentoMotivo(cita.getDescuentoMotivo().getIdDescuentoMotivo());
		MotivoDTO motivo = new MotivoDTO();
		motivo.setIdMotivo(cita.getDescuentoMotivo().getMotivo().getIdMotivo());
		motivo.setNombre(cita.getDescuentoMotivo().getMotivo().getNombre());
		descuentoMotivoDTO.setMotivo(motivo);
		descuentoMotivoDTO.setPorcentaje(cita.getDescuentoMotivo().getPorcentaje());
		descuentoMotivoDTO.setEstadoDescuento(cita.getDescuentoMotivo().getEstadoDescuento());
		descuentoMotivoDTO.setFechaCreacion(cita.getDescuentoMotivo().getFechaCreacion());
		descuentoMotivoDTO.setFechaActualizacion(cita.getDescuentoMotivo().getFechaActualizacion());
		
		citaDTO.setDescuentoMotivo(descuentoMotivoDTO);
		citaDTO.setFechaCreacion(cita.getFechaCreacion());
		citaDTO.setFechaActualizacion(cita.getFechaActualizacion());

		return citaDTO;

	}

}
