package com.iudigital.citas.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasRole('CASHIER')")
	public void createCita(@RequestBody CitaDTO citaDTO) throws Exception {
		citaService.createCita(citaConverter.convertCitaDTOToCita(citaDTO));
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	public List<CitaDTO> getCitas() throws Exception{
		try {
		return citaService.getCitas().stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita))
				.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PutMapping("/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('CASHIER')")
	public void reprogramarCita(@PathVariable Long idCita, @RequestBody Cita cita) throws Exception {
		citaService.reprogramarCita(idCita, cita);
	}

	@GetMapping("/between")
	@PreAuthorize("hasRole('CASHIER')")
	public List<CitaDTO> getByFechaCitaBetween(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
		return citaService.getByFechaCitaBetween(desde, hasta).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());

	}

	@GetMapping("/estadoPago")
	@PreAuthorize("hasRole('CASHIER')")
	public List<CitaDTO> getCitasEstadoPago(@RequestParam EstadoPago estadoPago) {
		return citaService.getCitasEstadoPago(estadoPago).stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita))
				.collect(Collectors.toList());
	}

	@GetMapping("/estadoAtencion")
	@PreAuthorize("hasRole('CASHIER')")
	public List<CitaDTO> getCitasEstadoAtencion(@RequestParam EstadoAtencion estadoAtencion) {
		return citaService.getCitasEstadoAtencion(estadoAtencion).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());
	}

	@PutMapping("/cancelarCita/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('CASHIER')")
	public void cancelarCita(@PathVariable Long idCita) throws Exception {
		citaService.cancelarCita(idCita);
	}

	@PutMapping("/pagarCita/{idCita}")
	@PreAuthorize("hasRole('CASHIER')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void pagarCita(@PathVariable Long idCita) throws Exception {
		citaService.pagarCita(idCita);
	}

	@GetMapping("/paging")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	public List<CitaDTO> getCitasPaging(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
			@RequestParam String sortBy) {
		return citaService.getAllCitas(pageNo, pageSize, sortBy).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());

	}

	@PostMapping("/getSpecCitas")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
    public List<CitaDTO> getCitasList(CitaFilter request, PaginationInfo paginationInfo) throws Exception {
		try {
		return citaService.getSpecCitaList(request, paginationInfo).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    }

}
