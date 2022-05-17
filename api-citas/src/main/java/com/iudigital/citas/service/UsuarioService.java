package com.iudigital.citas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.UsuarioRepository;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.enums.EstadoUsuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void createUsuario(Usuario usuario) {
		usuario.setFechaCreacion(LocalDateTime.now());
		usuario.setEstadoUsuario(EstadoUsuario.ACTIVO);

		usuarioRepository.save(usuario);

	}

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		return usuarios;
	}

	public void editUsuario(String numeroDoc, Usuario usuario) throws Exception {

		Usuario usuarioUpdate = usuarioRepository.findBynumeroDoc(numeroDoc);

		if (usuarioUpdate != null) {

			usuarioUpdate.setNombres(usuario.getNombres());
			usuarioUpdate.setApellidos(usuario.getApellidos());
			usuarioUpdate.setTipoDoc(usuario.getTipoDoc());
			usuarioUpdate.setNumeroDoc(usuario.getNumeroDoc());
			usuarioUpdate.setFechaNacimiento(usuario.getFechaNacimiento());
			usuarioUpdate.setTelefono(usuario.getTelefono());
			usuarioUpdate.setCorreo(usuario.getCorreo());
			usuarioUpdate.setPass(usuario.getPass());
			usuarioUpdate.setEstadoUsuario(usuario.getEstadoUsuario());
			usuarioUpdate.setIdEspecialidad(usuario.getIdEspecialidad());

			usuarioUpdate.setFechaActualizacion(LocalDateTime.now());

			usuarioRepository.save(usuarioUpdate);
		} else {
			throw new Exception("No existe usuario");
		}

	}

}
