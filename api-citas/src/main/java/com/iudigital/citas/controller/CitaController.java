package com.iudigital.citas.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.citas.controller.converter.CitaConverter;
import com.iudigital.citas.controller.dto.CitaDTO;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.filter.CitaFilter;
import com.iudigital.citas.domain.filter.PaginationInfo;
import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;
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

	@GetMapping("/between")
	public List<CitaDTO> getByFechaCitaBetween(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
		return citaService.getByFechaCitaBetween(desde, hasta).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());

	}

	@GetMapping("/estadoPago")
	public List<CitaDTO> getCitasEstadoPago(@RequestParam EstadoPago estadoPago) {
		return citaService.getCitasEstadoPago(estadoPago).stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita))
				.collect(Collectors.toList());
	}

	@GetMapping("/estadoAtencion")
	public List<CitaDTO> getCitasEstadoAtencion(@RequestParam EstadoAtencion estadoAtencion) {
		return citaService.getCitasEstadoAtencion(estadoAtencion).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());
	}

	@PutMapping("/cancelarCita/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelarCita(@PathVariable int idCita) throws Exception {
		citaService.cancelarCita(idCita);
	}

	@PutMapping("/pagarCita/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void pagarCita(@PathVariable int idCita) throws Exception {
		citaService.pagarCita(idCita);
	}

	@GetMapping("/paging")
	public List<CitaDTO> getCitasPaging(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
			@RequestParam String sortBy) {
		return citaService.getAllCitas(pageNo, pageSize, sortBy).stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita))
				.collect(Collectors.toList());
		
	}
	
	@GetMapping("/citasExec")
	public List<CitaDTO> getCitas(@RequestParam CitaFilter filter, @RequestParam PaginationInfo paginationInfo) {

		Page<Cita> page = citaService.getCitas(filter, paginationInfo);

		return page.getContent().stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());

	}

}
