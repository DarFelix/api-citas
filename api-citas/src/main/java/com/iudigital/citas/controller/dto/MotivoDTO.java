package com.iudigital.citas.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class MotivoDTO {

	@ApiModelProperty(value = "ID de motivo", example = "3")
	private int idMotivo;
	
	@ApiModelProperty(value = "Nombre de motivo", example = "Control")
	private String nombre;

	public int getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
