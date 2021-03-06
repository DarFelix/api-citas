package com.iudigital.citas.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.iudigital.citas.enums.EstadoDescuento;

@Entity
@Table(name = "descuentos_motivos")
public class DescuentoMotivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "descuento_motivo_id")
	private int idDescuentoMotivo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "motivo_id")
	private Motivo motivo;

	@Column(name = "porcentaje")
	private int porcentaje;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoDescuento estadoDescuento;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	public int getIdDescuentoMotivo() {
		return idDescuentoMotivo;
	}

	public void setIdDescuentoMotivo(int idDescuentoMotivo) {
		this.idDescuentoMotivo = idDescuentoMotivo;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public EstadoDescuento getEstadoDescuento() {
		return estadoDescuento;
	}

	public void setEstadoDescuento(EstadoDescuento estadoDescuento) {
		this.estadoDescuento = estadoDescuento;
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
