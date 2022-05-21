package com.iudigital.citas.controller.converter;

import com.iudigital.citas.controller.dto.MotivoDTO;
import com.iudigital.citas.domain.Motivo;

public class MotivoConverter {

	public Motivo convertMotivoDTOToMotivo(MotivoDTO motivoDTO) {

		Motivo motivo = new Motivo();

		motivo.setIdMotivo(motivoDTO.getIdMotivo());
		motivo.setNombre(motivoDTO.getNombre());

		return motivo;

	}

	public MotivoDTO convertMotivoToMotivoDTO(Motivo motivo) {

		MotivoDTO motivoDTO = new MotivoDTO();

		motivoDTO.setIdMotivo(motivo.getIdMotivo());
		motivoDTO.setNombre(motivo.getNombre());

		return motivoDTO;

	}

}
