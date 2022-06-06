package com.iudigital.citas.controller.dto;

import java.time.LocalDateTime;

import com.iudigital.citas.enums.EstadoDescuento;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DescuentoMotivoDTO {

	@ApiModelProperty(value = "ID de descuento-motivo", example = "3")
	private int idDescuentoMotivo;
	
	@ApiModelProperty(value = "Motivo de cita", example = "Objeto motivo")
	private MotivoDTO motivo;
	
	@ApiModelProperty(value = "Porcentaje descuento", example = "97")
	private int porcentaje;
	
	@ApiModelProperty(value = "Estado de descuento", example = "ACTIVO")
	private EstadoDescuento estadoDescuento;
	
	@ApiModelProperty(value = "Fecha de creación", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaCreacion;
	
	@ApiModelProperty(value = "Fecha de actualización", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaActualizacion;

	public int getIdDescuentoMotivo() {
		return idDescuentoMotivo;
	}

	public void setIdDescuentoMotivo(int idDescuentoMotivo) {
		this.idDescuentoMotivo = idDescuentoMotivo;
	}

	public MotivoDTO getMotivo() {
		return motivo;
	}

	public void setMotivo(MotivoDTO motivo) {
		this.motivo = motivo;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public EstadoDescuento getEstadoDescuento() {
		return estadoDescuento;
	}

	public void setEstadoDescuento(EstadoDescuento estadoDescuento) {
		this.estadoDescuento = estadoDescuento;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
