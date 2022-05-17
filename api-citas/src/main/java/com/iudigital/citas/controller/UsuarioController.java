package com.iudigital.citas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.citas.controller.converter.UsuarioConverter;
import com.iudigital.citas.controller.dto.UsuarioDTO;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	UsuarioConverter usuarioConverter;

	@PostMapping("/crearMedico")
	@ResponseStatus(HttpStatus.CREATED)
	public void createMedico(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.createUsuario(usuarioConverter.convertUsuarioDTOToUsuario(usuarioDTO));
	}

	@GetMapping
	public List<UsuarioDTO> getUsuarios() {
		return usuarioService.getUsuarios().stream()
				.map(usuario -> usuarioConverter.convertUsuarioToUsuarioDTO(usuario)).collect(Collectors.toList());
	}

	@PutMapping("/{numeroDoc}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editUsuario(@PathVariable String numeroDoc, @RequestBody Usuario usuario) throws Exception {
		usuarioService.editUsuario(numeroDoc, usuario);
	}
	
	@PostMapping("/crearUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioDTO.setIdEspecialidad(null);
		usuarioService.createUsuario(usuarioConverter.convertUsuarioDTOToUsuario(usuarioDTO));
	}
	
	
}
