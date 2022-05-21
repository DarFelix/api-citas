package com.iudigital.citas.controller.dto;

import java.time.LocalDateTime;

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

public class CitaDTO {

	private int idCita;
	private LocalDateTime fechaCita;
	private int idUsuario;
	private int idMedico;
	private ConsultaDTO consulta;
	private EstadoAtencion estadoAtencion;
	private EstadoPago estadoPago;
	private DescuentoMotivoDTO descuentoMotivo;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public ConsultaDTO getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaDTO consulta) {
		this.consulta = consulta;
	}

	public EstadoAtencion getEstadoAtencion() {
		return estadoAtencion;
	}

	public void setEstadoAtencion(EstadoAtencion estadoAtencion) {
		this.estadoAtencion = estadoAtencion;
	}

	public EstadoPago getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(EstadoPago estadoPago) {
		this.estadoPago = estadoPago;
	}

	public DescuentoMotivoDTO getDescuentoMotivo() {
		return descuentoMotivo;
	}

	public void setDescuentoMotivo(DescuentoMotivoDTO descuentoMotivo) {
		this.descuentoMotivo = descuentoMotivo;
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
