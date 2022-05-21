package com.iudigital.citas.controller.dto;

public class ConsultaDTO {

	private int idConsulta;
	private TipoCitaDTO tipoCita;
	private EspecialidadDTO especialidad;
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
