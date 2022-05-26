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

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

@Entity
@Table(name = "citas")
public class Cita  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cita_id")
	private Long idCita;

	@Column(name = "fecha_cita")
	private LocalDateTime fechaCita;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id")
	private Usuario medico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consulta_id")
	private Consulta consulta;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_atencion")
	private EstadoAtencion estadoAtencion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_pago")
	private EstadoPago estadoPago;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "descuento_motivo_id")
	private DescuentoMotivo descuentoMotivo;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getMedico() {
		return medico;
	}

	public void setMedico(Usuario medico) {
		this.medico = medico;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
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

	public DescuentoMotivo getDescuentoMotivo() {
		return descuentoMotivo;
	}

	public void setDescuentoMotivo(DescuentoMotivo descuentoMotivo) {
		this.descuentoMotivo = descuentoMotivo;
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
