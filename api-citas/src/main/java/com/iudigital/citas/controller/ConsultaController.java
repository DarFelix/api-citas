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

import com.iudigital.citas.controller.converter.ConsultaConverter;
import com.iudigital.citas.controller.dto.ConsultaDTO;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
@CrossOrigin("*")
public class ConsultaController {

	@Autowired
	ConsultaService consultaService;

	@Autowired
	ConsultaConverter consultaConverter;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public void createConsulta(@RequestBody ConsultaDTO consultaDTO) {
		consultaService.createConsulta(consultaConverter.convertConsultaDTOToConsulta(consultaDTO));
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MEDIC')")
	public List<ConsultaDTO> getConsultas() {
		return consultaService.getConsultas().stream()
				.map(consulta -> consultaConverter.convertConsultaToConsultaDTO(consulta)).collect(Collectors.toList());
	}

	@PutMapping("/{idConsulta}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	public void editConsulta(@PathVariable int idConsulta, @RequestBody Consulta consulta) throws Exception {
		consultaService.editConsulta(idConsulta, consulta);
	}
	
	
}
