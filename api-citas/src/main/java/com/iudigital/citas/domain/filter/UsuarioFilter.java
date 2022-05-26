package com.iudigital.citas.domain.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.iudigital.citas.enums.TipoDocumento;

public class UsuarioFilter {

	private String text;

	private TipoDocumento tipoDoc;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaNacimiento;

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
