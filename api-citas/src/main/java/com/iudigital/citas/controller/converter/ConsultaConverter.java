package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.ConsultaDTO;
import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.controller.dto.TipoCitaDTO;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.domain.TipoCita;

@Component
public class ConsultaConverter {

	public Consulta convertConsultaDTOToConsulta(ConsultaDTO consultaDTO) {

		Consulta consulta = new Consulta();

		consulta.setIdConsulta(consultaDTO.getIdConsulta());

		TipoCita tipoCita = new TipoCita();
		tipoCita.setIdTipoCita(consultaDTO.getTipoCita().getIdTipoCita());
		tipoCita.setNombre(consultaDTO.getTipoCita().getNombre());
		consulta.setTipoCita(tipoCita);

		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(consultaDTO.getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(consultaDTO.getEspecialidad().getNombre());
		consulta.setEspecialidad(especialidad);

		consulta.setCosto(consultaDTO.getCosto());

		return consulta;

	}

	public ConsultaDTO convertConsultaToConsultaDTO(Consulta consulta) {

		ConsultaDTO consultaDTO = new ConsultaDTO();

		consultaDTO.setIdConsulta(consulta.getIdConsulta());

		TipoCitaDTO tipoCita = new TipoCitaDTO();
		tipoCita.setIdTipoCita(consulta.getTipoCita().getIdTipoCita());
		tipoCita.setNombre(consulta.getTipoCita().getNombre());
		consultaDTO.setTipoCita(tipoCita);

		EspecialidadDTO especialidad = new EspecialidadDTO();
		especialidad.setIdEspecialidad(consulta.getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(consulta.getEspecialidad().getNombre());
		consultaDTO.setEspecialidad(especialidad);

		consultaDTO.setCosto(consulta.getCosto());

		return consultaDTO;

	}
}
