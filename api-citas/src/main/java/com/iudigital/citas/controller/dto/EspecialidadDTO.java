package com.iudigital.citas.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class EspecialidadDTO {

	@ApiModelProperty(value = "ID de especialidad", example = "3")
	private Integer idEspecialidad;
	
	@ApiModelProperty(value = "Nombre de especialidad", example = "Medicina general")
	private String nombre;

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
