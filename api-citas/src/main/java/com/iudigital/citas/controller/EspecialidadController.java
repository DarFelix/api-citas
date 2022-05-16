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

import com.iudigital.citas.controller.converter.EspecialidadConverter;
import com.iudigital.citas.controller.dto.EspecialidadDTO;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.service.EspecialidadService;

@RestController
@RequestMapping("/especialidad")
@CrossOrigin("*")
public class EspecialidadController {

	@Autowired
	EspecialidadService especialidadService;

	@Autowired
	EspecialidadConverter especialidadConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createEspecialidad(@RequestBody EspecialidadDTO especialidadDTO) {
		especialidadService.createEspecialidad(especialidadConverter.convertEspecialidadDTOToEspecialidad(especialidadDTO));
	}
	
	@GetMapping
	public List<EspecialidadDTO> getEspecialidades() {
		return especialidadService.getEspecialidades().stream()
				.map(especialidad -> especialidadConverter.convertEspecialidadToEspecialidadDTO(especialidad)).collect(Collectors.toList());
	}

	@PutMapping("/{idEspecialidad}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editEspecialidad(@PathVariable int idEspecialidad, @RequestBody Especialidad especialidad) throws Exception {
		especialidadService.editEspecialidad(idEspecialidad, especialidad);
	}
	
}
