package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.CitaDTO;
import com.iudigital.citas.controller.dto.ConsultaDTO;
import com.iudigital.citas.controller.dto.DescuentoMotivoDTO;
import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.controller.dto.MotivoDTO;
import com.iudigital.citas.controller.dto.TipoCitaDTO;
import com.iudigital.citas.controller.dto.UsuarioDTO;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.domain.DescuentoMotivo;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.domain.Motivo;
import com.iudigital.citas.domain.TipoCita;
import com.iudigital.citas.domain.Usuario;

@Component
public class CitaConverter {

	public Cita convertCitaDTOToCita(CitaDTO citaDTO) {

		Cita cita = new Cita();

		cita.setIdCita(citaDTO.getIdCita());
		cita.setFechaCita(citaDTO.getFechaCita());

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(citaDTO.getUsuario().getIdUsuario());
		usuario.setNombres(citaDTO.getUsuario().getNombres());
		usuario.setApellidos(citaDTO.getUsuario().getApellidos());
		usuario.setTipoDoc(citaDTO.getUsuario().getTipoDoc());
		usuario.setNumeroDoc(citaDTO.getUsuario().getNumeroDoc());
		usuario.setFechaNacimiento(citaDTO.getUsuario().getFechaNacimiento());
		usuario.setTelefono(citaDTO.getUsuario().getTelefono());
		usuario.setCorreo(citaDTO.getUsuario().getCorreo());
		usuario.setPass(citaDTO.getUsuario().getPass());
		usuario.setEstadoUsuario(citaDTO.getUsuario().getEstadoUsuario());

		if (citaDTO.getUsuario().getEspecialidad() != null) {
			Especialidad especialidad = new Especialidad();
			especialidad.setIdEspecialidad(citaDTO.getUsuario().getEspecialidad().getIdEspecialidad());
			especialidad.setNombre(citaDTO.getUsuario().getEspecialidad().getNombre());
			usuario.setEspecialidad(especialidad);
		}

		usuario.setFechaCreacion(citaDTO.getUsuario().getFechaCreacion());
		usuario.setFechaActualizacion(citaDTO.getUsuario().getFechaActualizacion());
		cita.setUsuario(usuario);

		Usuario medico = new Usuario();
		medico.setIdUsuario(citaDTO.getMedico().getIdUsuario());
		medico.setNombres(citaDTO.getMedico().getNombres());
		medico.setApellidos(citaDTO.getMedico().getApellidos());
		medico.setTipoDoc(citaDTO.getMedico().getTipoDoc());
		medico.setNumeroDoc(citaDTO.getMedico().getNumeroDoc());
		medico.setFechaNacimiento(citaDTO.getMedico().getFechaNacimiento());
		medico.setTelefono(citaDTO.getMedico().getTelefono());
		medico.setCorreo(citaDTO.getMedico().getCorreo());
		medico.setPass(citaDTO.getMedico().getPass());
		medico.setEstadoUsuario(citaDTO.getMedico().getEstadoUsuario());

		if (citaDTO.getMedico().getEspecialidad() != null) {
			Especialidad especialidadMedico = new Especialidad();
			especialidadMedico.setIdEspecialidad(citaDTO.getMedico().getEspecialidad().getIdEspecialidad());
			especialidadMedico.setNombre(citaDTO.getMedico().getEspecialidad().getNombre());
			medico.setEspecialidad(especialidadMedico);
		}
		medico.setFechaCreacion(citaDTO.getMedico().getFechaCreacion());
		medico.setFechaActualizacion(citaDTO.getMedico().getFechaActualizacion());
		cita.setMedico(medico);

		Consulta consulta = new Consulta();
		consulta.setIdConsulta(citaDTO.getConsulta().getIdConsulta());
		TipoCita tipoCita = new TipoCita();
		tipoCita.setIdTipoCita(citaDTO.getConsulta().getTipoCita().getIdTipoCita());
		tipoCita.setNombre(citaDTO.getConsulta().getTipoCita().getNombre());
		consulta.setTipoCita(tipoCita);

		if (citaDTO.getConsulta().getEspecialidad() != null) {
			Especialidad especialidad = new Especialidad();
			especialidad.setIdEspecialidad(citaDTO.getConsulta().getEspecialidad().getIdEspecialidad());
			especialidad.setNombre(citaDTO.getConsulta().getEspecialidad().getNombre());
			consulta.setEspecialidad(especialidad);
		}
		consulta.setCosto(citaDTO.getConsulta().getCosto());
		cita.setConsulta(consulta);

		cita.setEstadoAtencion(citaDTO.getEstadoAtencion());
		cita.setEstadoPago(citaDTO.getEstadoPago());

		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();
		descuentoMotivo.setIdDescuentoMotivo(citaDTO.getDescuentoMotivo().getIdDescuentoMotivo());
		Motivo motivo = new Motivo();
		motivo.setIdMotivo(citaDTO.getDescuentoMotivo().getMotivo().getIdMotivo());
		motivo.setNombre(citaDTO.getDescuentoMotivo().getMotivo().getNombre());
		descuentoMotivo.setMotivo(motivo);
		descuentoMotivo.setPorcentaje(citaDTO.getDescuentoMotivo().getPorcentaje());
		descuentoMotivo.setEstadoDescuento(citaDTO.getDescuentoMotivo().getEstadoDescuento());
		descuentoMotivo.setFechaCreacion(citaDTO.getDescuentoMotivo().getFechaCreacion());
		descuentoMotivo.setFechaActualizacion(citaDTO.getDescuentoMotivo().getFechaActualizacion());

		cita.setDescuentoMotivo(descuentoMotivo);
		cita.setFechaCreacion(citaDTO.getFechaCreacion());
		cita.setFechaActualizacion(citaDTO.getFechaActualizacion());

		return cita;

	}

	public CitaDTO convertCitaToCitaDTO(Cita cita) {

		CitaDTO citaDTO = new CitaDTO();

		citaDTO.setIdCita(cita.getIdCita());
		citaDTO.setFechaCita(cita.getFechaCita());

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setIdUsuario(cita.getUsuario().getIdUsuario());
		usuarioDTO.setNombres(cita.getUsuario().getNombres());
		usuarioDTO.setApellidos(cita.getUsuario().getApellidos());
		usuarioDTO.setTipoDoc(cita.getUsuario().getTipoDoc());
		usuarioDTO.setNumeroDoc(cita.getUsuario().getNumeroDoc());
		usuarioDTO.setFechaNacimiento(cita.getUsuario().getFechaNacimiento());
		usuarioDTO.setTelefono(cita.getUsuario().getTelefono());
		usuarioDTO.setCorreo(cita.getUsuario().getCorreo());
		usuarioDTO.setPass(cita.getUsuario().getPass());
		usuarioDTO.setEstadoUsuario(cita.getUsuario().getEstadoUsuario());

		if (cita.getUsuario().getEspecialidad() != null) {
			EspecialidadDTO especialidad = new EspecialidadDTO();
			especialidad.setIdEspecialidad(cita.getUsuario().getEspecialidad().getIdEspecialidad());
			especialidad.setNombre(cita.getUsuario().getEspecialidad().getNombre());
			usuarioDTO.setEspecialidad(especialidad);
		}

		usuarioDTO.setFechaCreacion(cita.getUsuario().getFechaCreacion());
		usuarioDTO.setFechaActualizacion(cita.getUsuario().getFechaActualizacion());
		citaDTO.setUsuario(usuarioDTO);

		UsuarioDTO medicoDTO = new UsuarioDTO();
		medicoDTO.setIdUsuario(cita.getMedico().getIdUsuario());
		medicoDTO.setNombres(cita.getMedico().getNombres());
		medicoDTO.setApellidos(cita.getMedico().getApellidos());
		medicoDTO.setTipoDoc(cita.getMedico().getTipoDoc());
		medicoDTO.setNumeroDoc(cita.getMedico().getNumeroDoc());
		medicoDTO.setFechaNacimiento(cita.getMedico().getFechaNacimiento());
		medicoDTO.setTelefono(cita.getMedico().getTelefono());
		medicoDTO.setCorreo(cita.getMedico().getCorreo());
		medicoDTO.setPass(cita.getMedico().getPass());
		medicoDTO.setEstadoUsuario(cita.getMedico().getEstadoUsuario());

		if (cita.getMedico().getEspecialidad() != null) {
			EspecialidadDTO especialidadMedico = new EspecialidadDTO();
			especialidadMedico.setIdEspecialidad(cita.getMedico().getEspecialidad().getIdEspecialidad());
			especialidadMedico.setNombre(cita.getMedico().getEspecialidad().getNombre());
			medicoDTO.setEspecialidad(especialidadMedico);
		}

		medicoDTO.setFechaCreacion(cita.getMedico().getFechaCreacion());
		medicoDTO.setFechaActualizacion(cita.getMedico().getFechaActualizacion());
		citaDTO.setMedico(medicoDTO);

		ConsultaDTO consulta = new ConsultaDTO();
		consulta.setIdConsulta(cita.getConsulta().getIdConsulta());
		TipoCitaDTO tipoCita = new TipoCitaDTO();
		tipoCita.setIdTipoCita(cita.getConsulta().getTipoCita().getIdTipoCita());
		tipoCita.setNombre(cita.getConsulta().getTipoCita().getNombre());
		consulta.setTipoCita(tipoCita);

		if (cita.getConsulta().getEspecialidad() != null) {
			EspecialidadDTO especialidad = new EspecialidadDTO();
			especialidad.setIdEspecialidad(cita.getConsulta().getEspecialidad().getIdEspecialidad());
			especialidad.setNombre(cita.getConsulta().getEspecialidad().getNombre());
			consulta.setEspecialidad(especialidad);
		}

		consulta.setCosto(cita.getConsulta().getCosto());
		citaDTO.setConsulta(consulta);

		citaDTO.setEstadoAtencion(cita.getEstadoAtencion());
		citaDTO.setEstadoPago(cita.getEstadoPago());

		DescuentoMotivoDTO descuentoMotivoDTO = new DescuentoMotivoDTO();
		descuentoMotivoDTO.setIdDescuentoMotivo(cita.getDescuentoMotivo().getIdDescuentoMotivo());
		MotivoDTO motivo = new MotivoDTO();
		motivo.setIdMotivo(cita.getDescuentoMotivo().getMotivo().getIdMotivo());
		motivo.setNombre(cita.getDescuentoMotivo().getMotivo().getNombre());
		descuentoMotivoDTO.setMotivo(motivo);
		descuentoMotivoDTO.setPorcentaje(cita.getDescuentoMotivo().getPorcentaje());
		descuentoMotivoDTO.setEstadoDescuento(cita.getDescuentoMotivo().getEstadoDescuento());
		descuentoMotivoDTO.setFechaCreacion(cita.getDescuentoMotivo().getFechaCreacion());
		descuentoMotivoDTO.setFechaActualizacion(cita.getDescuentoMotivo().getFechaActualizacion());

		citaDTO.setDescuentoMotivo(descuentoMotivoDTO);
		citaDTO.setFechaCreacion(cita.getFechaCreacion());
		citaDTO.setFechaActualizacion(cita.getFechaActualizacion());

		return citaDTO;

	}

}
