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

import com.iudigital.citas.controller.converter.CitaConverter;
import com.iudigital.citas.controller.dto.CitaDTO;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.service.CitaService;

@RestController
@RequestMapping("/cita")
@CrossOrigin("*")
public class CitaController {

	@Autowired
	CitaService citaService;

	@Autowired
	CitaConverter citaConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCita(@RequestBody CitaDTO citaDTO) throws Exception {
		citaService.createCita(citaConverter.convertCitaDTOToCita(citaDTO));
	}

	@GetMapping
	public List<CitaDTO> getCitas() {
		return citaService.getCitas().stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita))
				.collect(Collectors.toList());
	}

	@PutMapping("/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void reprogramarCita(@PathVariable int idCita, @RequestBody Cita cita) throws Exception {
		citaService.reprogramarCita(idCita, cita);
	}
}
