package com.iudigital.citas.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TipoCitaDTO {

	@ApiModelProperty(value = "ID de tipo de cita", example = "3")
	private int idTipoCita;
	
	@ApiModelProperty(value = "Nombre de tipo de cita", example = "Especialista")
	private String nombre;

	public int getIdTipoCita() {
		return idTipoCita;
	}

	public void setIdTipoCita(int idTipoCita) {
		this.idTipoCita = idTipoCita;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
