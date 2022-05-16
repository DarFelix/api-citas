package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.ConsultaDTO;
import com.iudigital.citas.domain.Consulta;

@Component
public class ConsultaConverter {

	public Consulta convertConsultaDTOToConsulta(ConsultaDTO consultaDTO) {

		Consulta consulta = new Consulta();

		consulta.setIdConsulta(consultaDTO.getIdConsulta());
		consulta.setIdTipoCita(consultaDTO.getIdTipoCita());
		consulta.setIdEspecialidad(consultaDTO.getIdEspecialidad());
		consulta.setCosto(consultaDTO.getCosto());

		return consulta;

	}
	
	public ConsultaDTO convertConsultaToConsultaDTO(Consulta consulta) {

		ConsultaDTO consultaDTO = new ConsultaDTO();

		consultaDTO.setIdConsulta(consulta.getIdConsulta());
		consultaDTO.setIdTipoCita(consulta.getIdTipoCita());
		consultaDTO.setIdEspecialidad(consulta.getIdEspecialidad());
		consultaDTO.setCosto(consulta.getCosto());

		return consultaDTO;

	}
}
