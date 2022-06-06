package com.iudigital.citas.controller.dto;

import java.time.LocalDateTime;

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CitaDTO {

	@ApiModelProperty(value = "ID de cita médica", example = "3")
	private Long idCita;
	
	@ApiModelProperty(value = "Fecha de cita medica", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaCita;
	
	@ApiModelProperty(value = "Usuario de cita", example = "Objeto usuario")
	private UsuarioDTO usuario;
	
	@ApiModelProperty(value = "Médico que atiende cita", example = "Objeto usuario")
	private UsuarioDTO medico;
	
	@ApiModelProperty(value = "Consulta de cita", example = "Objeto consulta")
	private ConsultaDTO consulta;
	
	@ApiModelProperty(value = "Estado de atención", example = "ATENDIDA")
	private EstadoAtencion estadoAtencion;
	
	@ApiModelProperty(value = "Estado de pago", example = "NO_PAGADA")
	private EstadoPago estadoPago;
	
	@ApiModelProperty(value = "Descuento de cita", example = "Objeto descuento")
	private DescuentoMotivoDTO descuentoMotivo;
	
	@ApiModelProperty(value = "Fecha de creación de cita", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaCreacion;
	
	@ApiModelProperty(value = "Fecha de actualización de cita", example = "2022-01-31 06:00:00")
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
