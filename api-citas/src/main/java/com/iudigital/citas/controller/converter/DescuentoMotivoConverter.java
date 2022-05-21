package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.DescuentoMotivoDTO;
import com.iudigital.citas.controller.dto.MotivoDTO;
import com.iudigital.citas.domain.DescuentoMotivo;
import com.iudigital.citas.domain.Motivo;

@Component
public class DescuentoMotivoConverter {

	public DescuentoMotivo convertDescuentoMotivoDTOToDescuentoMotivo(DescuentoMotivoDTO descuentoMotivoDTO) {

		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();

		descuentoMotivo.setIdDescuentoMotivo(descuentoMotivoDTO.getIdDescuentoMotivo());
		
		Motivo motivo = new Motivo();
		motivo.setIdMotivo(descuentoMotivoDTO.getMotivo().getIdMotivo());
		motivo.setNombre(descuentoMotivoDTO.getMotivo().getNombre());
		descuentoMotivo.setMotivo(motivo);
		
		descuentoMotivo.setPorcentaje(descuentoMotivoDTO.getPorcentaje());
		descuentoMotivo.setEstadoDescuento(descuentoMotivoDTO.getEstadoDescuento());
		descuentoMotivo.setFechaCreacion(descuentoMotivoDTO.getFechaCreacion());
		descuentoMotivo.setFechaActualizacion(descuentoMotivoDTO.getFechaActualizacion());

		return descuentoMotivo;

	}
	
	public DescuentoMotivoDTO convertDescuentoMotivoToDescuentoMotivoDTO(DescuentoMotivo descuentoMotivo) {

		DescuentoMotivoDTO descuentoMotivoDTO = new DescuentoMotivoDTO();

		descuentoMotivoDTO.setIdDescuentoMotivo(descuentoMotivo.getIdDescuentoMotivo());
		
		MotivoDTO motivo = new MotivoDTO();
		motivo.setIdMotivo(descuentoMotivo.getMotivo().getIdMotivo());
		motivo.setNombre(descuentoMotivo.getMotivo().getNombre());
		descuentoMotivoDTO.setMotivo(motivo);
		
		descuentoMotivoDTO.setPorcentaje(descuentoMotivo.getPorcentaje());
		descuentoMotivoDTO.setEstadoDescuento(descuentoMotivo.getEstadoDescuento());
		descuentoMotivoDTO.setFechaCreacion(descuentoMotivo.getFechaCreacion());
		descuentoMotivoDTO.setFechaActualizacion(descuentoMotivo.getFechaActualizacion());

		return descuentoMotivoDTO;

	}
	
}
