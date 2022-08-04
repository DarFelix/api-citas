package com.iudigital.citas.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cita")
@CrossOrigin("*")
@Api(value = "Cita", tags = "Cita")
public class CitaController {

	@Autowired
	CitaService citaService;

	@Autowired
	CitaConverter citaConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Crear cita", tags = "Cita", notes = "Crear nueva cita")
	public void createCita(@RequestBody CitaDTO citaDTO) throws Exception {
		try {
		citaService.createCita(citaConverter.convertCitaDTOToCita(citaDTO));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Obtener listado de citas", tags = "Cita", notes = "Listar citas")
	public List<CitaDTO> getCitas() throws Exception {
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
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Reprogramar cita", tags = "Cita", notes = "Cambiar fecha cita")
	public void reprogramarCita(@PathVariable Long idCita, @RequestBody Cita cita) throws Exception {
		citaService.reprogramarCita(idCita, cita);
	}

	@GetMapping("/between")
	@PreAuthorize("hasRole('CASHIER')")
	@ApiOperation(value = "Obtener citas entre dos fechas", tags = "Cita", notes = "Citas de ? a ?")
	public List<CitaDTO> getByFechaCitaBetween(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
		return citaService.getByFechaCitaBetween(desde, hasta).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());

	}

	@GetMapping("/estadoPago")
	@PreAuthorize("hasRole('CASHIER')")
	@ApiOperation(value = "Obtener lista de citas según estado de pago", tags = "Cita", notes = "Búsqueda por estado de pago")
	public List<CitaDTO> getCitasEstadoPago(@RequestParam EstadoPago estadoPago) {
		return citaService.getCitasEstadoPago(estadoPago).stream().map(cita -> citaConverter.convertCitaToCitaDTO(cita))
				.collect(Collectors.toList());
	}

	@GetMapping("/estadoAtencion")
	@PreAuthorize("hasRole('CASHIER')")
	@ApiOperation(value = "Obtener citas por estado de atención", tags = "Cita", notes = "Búsqueda por estado de atención")
	public List<CitaDTO> getCitasEstadoAtencion(@RequestParam EstadoAtencion estadoAtencion) {
		return citaService.getCitasEstadoAtencion(estadoAtencion).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());
	}

	@PutMapping("/cancelarCita/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Cancelar cita médica", tags = "Cita", notes = "Cancelación de cita")
	public void cancelarCita(@PathVariable Long idCita) throws Exception {
		citaService.cancelarCita(idCita);
	}

	@PutMapping("/pay/{idCita}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Pagar cita médica", tags = "Cita", notes = "Pago de cita")
	public void pagarCita(@PathVariable Long idCita) throws Exception {
		try {
		citaService.pagarCita(idCita);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@GetMapping("/{idCita}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Búsqueda de cita por id", tags = "Cita", notes = "JSON de cita según id")
	public CitaDTO getCitaById(@PathVariable Long idCita) throws Exception {
		return citaConverter.convertCitaToCitaDTO(citaService.getCitaById(idCita));
	}

	@GetMapping("/paging")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Búsqueda de citas y paginación de resultados", tags = "Cita", notes = "Lista de cita paginadas")
	public List<CitaDTO> getCitasPaging(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
			@RequestParam String sortBy) {
		return citaService.getAllCitas(pageNo, pageSize, sortBy).stream()
				.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());

	}

	@PostMapping("/getSpecCitas")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Lista de cita mediante especificación y paginación", tags = "Cita", notes = "Citas por especificación")
	public List<CitaDTO> getCitasList(CitaFilter request, PaginationInfo paginationInfo) throws Exception {
		
		try {
			return citaService.getSpecCitaList(request, paginationInfo).stream()
					.map(cita -> citaConverter.convertCitaToCitaDTO(cita)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@PostMapping("/search")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Lista de cita mediante especificación y paginación en el servidor", tags = "Cita", notes = "Citas por especificación")
	public ResponseEntity<Map<String, Object>> getCitasSearch(CitaFilter request, PaginationInfo paginationInfo) throws Exception {
		
		try {
			return citaService.busquedaCitasSpec(request, paginationInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	@GetMapping("/cits")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Lista de cita mediante filtro y paginación", tags = "Cita", notes = "Citas paginadas")
	public ResponseEntity<Map<String, Object>> getAllCits( 
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size,
			String sortBy) {
		
		return citaService.getAllCits( page, size, sortBy);
		
	}
	
	@GetMapping("/citasXpacPendientesPag")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Lista de cita mediante filtro y paginación", tags = "Cita", notes = "Citas paginadas")
	public ResponseEntity<Map<String, Object>> getCitasPendPac(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size,
			@RequestParam String documento){
		return citaService.getCitasPendientesPac(page, size, documento);
	}
	
	
	
	

}
