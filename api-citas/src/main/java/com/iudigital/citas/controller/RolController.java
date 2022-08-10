package com.iudigital.citas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.citas.controller.converter.RolConverter;
import com.iudigital.citas.controller.dto.RolDTO;
import com.iudigital.citas.service.RolService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
@Api(value = "Rol", tags = "Rol")
public class RolController {

	@Autowired
	RolService rolService;

	@Autowired
	RolConverter rolConverter;

	@GetMapping
	@PreAuthorize("hasRole('MEDIC') or hasRole('ADMIN') or hasRole('CASHIER')")
	@ApiOperation(value = "Consultar roles", tags = "Rol", notes = "Consultar los roles parametrizados existentes.")
	public List<RolDTO> getRoles() {
		return rolService.getRoles().stream().map(rol -> rolConverter.convertRolToRolDTO(rol))
				.collect(Collectors.toList());
	}

}
