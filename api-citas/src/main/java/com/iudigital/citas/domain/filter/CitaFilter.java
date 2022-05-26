package com.iudigital.citas.domain.filter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

public class CitaFilter {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaCita;
	private String text;
	private List<Integer> consultasIds;
	private EstadoAtencion estadoAtencion;
	private EstadoPago estadoPago;

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Integer> getConsultasIds() {
		return consultasIds;
	}

	public void setConsultasIds(List<Integer> consultasIds) {
		this.consultasIds = consultasIds;
	}

}
