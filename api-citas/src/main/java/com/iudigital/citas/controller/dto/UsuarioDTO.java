package com.iudigital.citas.controller.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.iudigital.citas.enums.EstadoUsuario;
import com.iudigital.citas.enums.TipoDocumento;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UsuarioDTO {

	@ApiModelProperty(value = "ID de usuario", example = "3")
	private int idUsuario;
	
	@ApiModelProperty(value = "Nombres de usuario", example = "Milena Camila")
	private String nombres;
	
	@ApiModelProperty(value = "Apellidos de usuario", example = "Ruiz Sanchez")
	private String apellidos;
	
	@ApiModelProperty(value = "Tipo de documento", example = "CC")
	private TipoDocumento tipoDoc;
	
	@ApiModelProperty(value = "Número de documento", example = "20333456")
	private String numeroDoc;
	
	@ApiModelProperty(value = "Fecha de nacimiento", example = "1990-01-31")
	private LocalDate fechaNacimiento;
	
	@ApiModelProperty(value = "Teléfono", example = "3005553377")
	private String telefono;
	
	@ApiModelProperty(value = "Correo electrónico", example = "mileru@gmail.com")
	private String correo;
	
	@ApiModelProperty(value = "Contraseña", example = "clave123+")
	private String pass;
	
	@ApiModelProperty(value = "Rol de usuario", example = "Objeto rol")
	private RolDTO rol;
	
	@ApiModelProperty(value = "Estado de usuario", example = "ACTIVO")
	private EstadoUsuario estadoUsuario;
	
	@ApiModelProperty(value = "Especialidad", example = "Objeto especialidad")
	private EspecialidadDTO especialidad;
	
	@ApiModelProperty(value = "Fecha de creación de cita", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaCreacion;
	
	@ApiModelProperty(value = "Fecha de creación de cita", example = "2022-01-31 06:00:00")
	private LocalDateTime fechaActualizacion;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getNumeroDoc() {
		return numeroDoc;
	}

	public void setNumeroDoc(String numeroDoc) {
		this.numeroDoc = numeroDoc;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	public EstadoUsuario getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
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
