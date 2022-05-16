package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.DescuentoMotivoDTO;
import com.iudigital.citas.domain.DescuentoMotivo;

@Component
public class DescuentoMotivoConverter {

	public DescuentoMotivo convertDescuentoMotivoDTOToDescuentoMotivo(DescuentoMotivoDTO descuentoMotivoDTO) {

		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();

		descuentoMotivo.setIdDescuentoMotivo(descuentoMotivoDTO.getIdDescuentoMotivo());
		descuentoMotivo.setIdMotivo(descuentoMotivoDTO.getIdMotivo());
		descuentoMotivo.setPorcentaje(descuentoMotivoDTO.getPorcentaje());
		descuentoMotivo.setEstadoDescuento(descuentoMotivoDTO.getEstadoDescuento());
		descuentoMotivo.setFechaCreacion(descuentoMotivoDTO.getFechaCreacion());
		descuentoMotivo.setFechaActualizacion(descuentoMotivoDTO.getFechaActualizacion());

		return descuentoMotivo;

	}
	
	public DescuentoMotivoDTO convertDescuentoMotivoToDescuentoMotivoDTO(DescuentoMotivo descuentoMotivo) {

		DescuentoMotivoDTO descuentoMotivoDTO = new DescuentoMotivoDTO();

		descuentoMotivoDTO.setIdDescuentoMotivo(descuentoMotivo.getIdDescuentoMotivo());
		descuentoMotivoDTO.setIdMotivo(descuentoMotivo.getIdMotivo());
		descuentoMotivoDTO.setPorcentaje(descuentoMotivo.getPorcentaje());
		descuentoMotivoDTO.setEstadoDescuento(descuentoMotivo.getEstadoDescuento());
		descuentoMotivoDTO.setFechaCreacion(descuentoMotivo.getFechaCreacion());
		descuentoMotivoDTO.setFechaActualizacion(descuentoMotivo.getFechaActualizacion());

		return descuentoMotivoDTO;

	}
	
}
