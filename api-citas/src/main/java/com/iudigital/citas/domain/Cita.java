package com.iudigital.citas.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

@Entity
@Table(name = "citas")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cita_id")
	private int idCita;

	@Column(name = "fecha_cita")
	private LocalDateTime fechaCita;

	@Column(name = "usuario_id")
	private int idUsuario;

	@Column(name = "medico_id")
	private int idMedico;

	@Column(name = "consulta_id")
	private int idConsulta;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_atencion")
	private EstadoAtencion estadoAtencion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_pago")
	private EstadoPago estadoPago;

	@Column(name = "descuento_motivo_id")
	private int idDescuentoMotivo;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
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

	public int getIdDescuentoMotivo() {
		return idDescuentoMotivo;
	}

	public void setIdDescuentoMotivo(int idDescuentoMotivo) {
		this.idDescuentoMotivo = idDescuentoMotivo;
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

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fechaCita=" + fechaCita + ", idUsuario=" + idUsuario + ", idMedico="
				+ idMedico + ", idConsulta=" + idConsulta + ", estadoAtencion=" + estadoAtencion + ", estadoPago="
				+ estadoPago + ", idDescuentoMotivo=" + idDescuentoMotivo + ", fechaCreacion=" + fechaCreacion
				+ ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
