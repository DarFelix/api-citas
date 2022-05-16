package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.UsuarioDTO;
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
		usuario.setEstadoUsuario(usuarioDTO.getEstadoUsuario());
		usuario.setIdEspecialidad(usuarioDTO.getIdEspecialidad());
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
		usuarioDTO.setPass(usuario.getPass());
		usuarioDTO.setEstadoUsuario(usuario.getEstadoUsuario());
		usuarioDTO.setIdEspecialidad(usuario.getIdEspecialidad());
		usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
		usuarioDTO.setFechaActualizacion(usuario.getFechaActualizacion());
		
		return usuarioDTO;
	}
	
	
}
