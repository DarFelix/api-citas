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

import com.iudigital.citas.controller.converter.TratamientoConverter;
import com.iudigital.citas.controller.dto.TratamientoDTO;
import com.iudigital.citas.domain.Tratamiento;
import com.iudigital.citas.service.TratamientoService;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin("*")
public class TratamientoController {

	@Autowired
	TratamientoService tratamientoService;

	@Autowired
	TratamientoConverter tratamientoConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('MEDIC')")
	public void createTratamiento(@RequestBody TratamientoDTO tratamientoDTO) {
		tratamientoService.createTratamiento(tratamientoConverter.convertTratamientoDTOToTratamiento(tratamientoDTO));
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public List<TratamientoDTO> getTratamientos() {
		return tratamientoService.getTratamientos().stream()
				.map(tratamiento -> tratamientoConverter.convertTratamientoToTratamientoDTO(tratamiento))
				.collect(Collectors.toList());
	}

	@PutMapping("/{idTratamiento}")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editTratamiento(@PathVariable int idTratamiento, @RequestBody Tratamiento tratamiento)
			throws Exception {
		tratamientoService.editTratamiento(idTratamiento, tratamiento);
	}
}
