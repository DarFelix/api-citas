package com.iudigital.citas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_cita")
public class TipoCita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_cita_id")
	private int idTipoCita;

	@Column(name = "nombre")
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
