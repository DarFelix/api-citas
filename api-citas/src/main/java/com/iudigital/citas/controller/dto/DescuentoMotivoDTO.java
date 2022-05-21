package com.iudigital.citas.controller.dto;

import java.time.LocalDateTime;

import com.iudigital.citas.enums.EstadoDescuento;

public class DescuentoMotivoDTO {

	private int idDescuentoMotivo;
	private MotivoDTO motivo;
	private int porcentaje;
	private EstadoDescuento estadoDescuento;
	private LocalDateTime fechaCreacion;
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
