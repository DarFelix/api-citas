package com.iudigital.citas.controller.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TratamientoDTO {

	@ApiModelProperty(value = "ID de tratamiento", example = "3")
	private int idTratamiento;
	
	@ApiModelProperty(value = "Nombre de tratamiento", example = "Medicación")
	private String nombre;
	
	@ApiModelProperty(value = "Especialidad", example = "Objeto especialidad")
	private EspecialidadDTO especialidad;
	
	@ApiModelProperty(value = "Diagnóstico", example = "Alergia")
	private String diagnostico;
	
	@ApiModelProperty(value = "ID de cita médica", example = "3")
	private int idCita;
	
	@ApiModelProperty(value = "Fecha de creación de cita", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaCreacion;
	
	@ApiModelProperty(value = "Fecha de actualización de cita", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaActualizacion;

	public int getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
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
