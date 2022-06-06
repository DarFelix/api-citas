package com.iudigital.citas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.iudigital.citas.domain.filter.PaginationInfo;
import com.iudigital.citas.domain.filter.UsuarioFilter;
import com.iudigital.citas.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
@Api(value = "Usuario", tags = "Usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	UsuarioConverter usuarioConverter;

	@PostMapping("/crearMedico")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Crear médico", tags = "Usuario", notes = "Crear usuario para médico en el sistema.")
	public void createMedico(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.createUsuario(usuarioConverter.convertUsuarioDTOToUsuario(usuarioDTO));
	}

	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MEDIC')")
	@ApiOperation(value = "Consultar usuarios", tags = "Usuario", notes = "Consultar los usuarios existentes sin importar el rol.")
	public List<UsuarioDTO> getUsuarios() {
		return usuarioService.getUsuarios().stream()
				.map(usuario -> usuarioConverter.convertUsuarioToUsuarioDTO(usuario)).collect(Collectors.toList());
	}

	@PutMapping("/{numeroDoc}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Modificar usuario", tags = "Usuario", notes = "Modificar usuario en el sistema.")
	public void editUsuario(@PathVariable String numeroDoc, @RequestBody Usuario usuario) throws Exception {
		usuarioService.editUsuario(numeroDoc, usuario);
	}

	@PostMapping("/crearUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Crear cliente.", tags = "Usuario", notes = "Crear usuario cliente en el sistema")
	public void createUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
		
		try {
		usuarioDTO.setEspecialidad(null);
		usuarioService.createUsuario(usuarioConverter.convertUsuarioDTOToUsuario(usuarioDTO));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping("/{idUsuario}")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Consultar usuario por id.", tags = "Usuario", notes = "Consultar usuario por id en el sistema.")
	public UsuarioDTO getUsuario(@PathVariable int idUsuario) throws Exception {
		
		try {
		return usuarioConverter.convertUsuarioToUsuarioDTO(usuarioService.getUsuarioById(idUsuario));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@PostMapping("/getSpecUsuarios")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MEDIC')")
	@ApiOperation(value = "Consultar usuarios mediante especificaciones.", tags = "Usuario", notes = "Consultar usuarios por diferentes criterios de búsqueda.")
    public List<UsuarioDTO> getUsersList(UsuarioFilter request, PaginationInfo paginationInfo) throws Exception {
		try {
		return usuarioService.getSpecList(request, paginationInfo).stream()
				.map(usuario -> usuarioConverter.convertUsuarioToUsuarioDTO(usuario)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

}
