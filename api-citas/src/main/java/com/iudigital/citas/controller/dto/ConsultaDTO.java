package com.iudigital.citas.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ConsultaDTO {

	@ApiModelProperty(value = "ID de consulta", example = "3")
	private int idConsulta;
	
	@ApiModelProperty(value = "Tipo de cita", example = "Objeto tipo de cita")
	private TipoCitaDTO tipoCita;
	
	@ApiModelProperty(value = "Especialidad", example = "Objeto especialidad")
	private EspecialidadDTO especialidad;
	
	@ApiModelProperty(value = "Valor costo de cita", example = "45000.3")
	private double costo;

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public TipoCitaDTO getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCitaDTO tipoCita) {
		this.tipoCita = tipoCita;
	}

	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

}
