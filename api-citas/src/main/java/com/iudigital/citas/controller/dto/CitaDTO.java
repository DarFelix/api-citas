package com.iudigital.citas.controller.dto;

import java.time.LocalDateTime;

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CitaDTO {

	private Long idCita;
	
	@ApiModelProperty(value = "Fecha de cita medica", example = "2022-01-31")
	private LocalDateTime fechaCita;
	private UsuarioDTO usuario;
	private UsuarioDTO medico;
	private ConsultaDTO consulta;
	private EstadoAtencion estadoAtencion;
	private EstadoPago estadoPago;
	private DescuentoMotivoDTO descuentoMotivo;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public UsuarioDTO getMedico() {
		return medico;
	}

	public void setMedico(UsuarioDTO medico) {
		this.medico = medico;
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
