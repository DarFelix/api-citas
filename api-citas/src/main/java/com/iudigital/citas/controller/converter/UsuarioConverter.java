package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.controller.dto.RolDTO;
import com.iudigital.citas.controller.dto.UsuarioDTO;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.domain.Rol;
import com.iudigital.citas.domain.Usuario;


@Component
public class UsuarioConverter {

	public Usuario convertUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();

		usuario.setIdUsuario(usuarioDTO.getIdUsuario());
		usuario.setNombres(usuarioDTO.getNombres());
		usuario.setApellidos(usuarioDTO.getApellidos());
		usuario.setTipoDoc(usuarioDTO.getTipoDoc());
		usuario.setNumeroDoc(usuarioDTO.getNumeroDoc());
		usuario.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
		usuario.setTelefono(usuarioDTO.getTelefono());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setPass(usuarioDTO.getPass());
		
		Rol rol = new Rol();
		rol.setIdRol(usuarioDTO.getRol().getIdRol());
		rol.setNombre(usuarioDTO.getRol().getNombre());
		usuario.setRol(rol);	
		
		usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());

		if(usuarioDTO.getEspecialidad()!= null) {
		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(usuarioDTO.getEspecialidad().getIdEspecialidad());
		especialidad.setNombre(usuarioDTO.getEspecialidad().getNombre());
		usuario.setEspecialidad(especialidad);
		}
		
		usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
		usuario.setFechaActualizacion(usuarioDTO.getFechaActualizacion());

		return usuario;
	}

	public UsuarioDTO convertUsuarioToUsuarioDTO(Usuario usuario) {

		UsuarioDTO usuarioDTO = new UsuarioDTO();

		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setNombres(usuario.getNombres());
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setTipoDoc(usuario.getTipoDoc());
		usuarioDTO.setNumeroDoc(usuario.getNumeroDoc());
		usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioDTO.setTelefono(usuario.getTelefono());
		usuarioDTO.setCorreo(usuario.getCorreo());
		
		String pass = usuario.getPass();
		if(pass != null) {
		usuarioDTO.setPass(pass);
		}
	
		RolDTO rol = new RolDTO();
		rol.setIdRol(usuario.getRol().getIdRol());
		rol.setNombre(usuario.getRol().getNombre());
		usuarioDTO.setRol(rol);	
		
		
		usuarioDTO.setEstadoUsuario(usuario.getEstadoUsuario());
		
		
		
		
		if(usuario.getEspecialidad()!= null) {
			EspecialidadDTO especialidad = new EspecialidadDTO();
			especialidad.setIdEspecialidad(usuario.getEspecialidad().getIdEspecialidad());
			especialidad.setNombre(usuario.getEspecialidad().getNombre());	
			usuarioDTO.setEspecialidad(especialidad);
			
		}
		
		
		
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setFechaActualizacion(usuario.getFechaActualizacion());

		return usuarioDTO;
	}

}
