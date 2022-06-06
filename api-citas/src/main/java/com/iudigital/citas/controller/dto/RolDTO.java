package com.iudigital.citas.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RolDTO {

	@ApiModelProperty(value = "ID de rol", example = "ADMIN")
	private String idRol;
	
	@ApiModelProperty(value = "Nombre de rol", example = "Administrador")
	private String nombre;

	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
