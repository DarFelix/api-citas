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

import com.iudigital.citas.controller.converter.DescuentoMotivoConverter;
import com.iudigital.citas.controller.dto.DescuentoMotivoDTO;
import com.iudigital.citas.domain.DescuentoMotivo;
import com.iudigital.citas.service.DescuentoMotivoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/descuentoMotivo")
@CrossOrigin("*")
@Api(value = "Descuento", tags = "Descuento")
public class DescuentoMotivoController {

	@Autowired
	DescuentoMotivoService descuentoMotivoService;

	@Autowired
	DescuentoMotivoConverter descuentoMotivoConverter;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Crear descuentos-motivos", tags = "Descuento", notes = "Crear descuentos y motivos que sirvan como parámetros.")
	public void createDescuentoMotivo(@RequestBody DescuentoMotivoDTO descuentoMotivoDTO) {
		descuentoMotivoService.createDescuentoMotivo(
				descuentoMotivoConverter.convertDescuentoMotivoDTOToDescuentoMotivo(descuentoMotivoDTO));
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('CASHIER')")
	@ApiOperation(value = "Obtener lista de descuentos", tags = "Descuento", notes = "Consultar los descuentos parametrizados en el sistema.")
	public List<DescuentoMotivoDTO> getDescuentosMotivos() {
		return descuentoMotivoService.getDescuentosMotivos().stream().map(
				descuentoMotivo -> descuentoMotivoConverter.convertDescuentoMotivoToDescuentoMotivoDTO(descuentoMotivo))
				.collect(Collectors.toList());
	}

	@PutMapping("/{idDescuentoMotivo}")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Editar descuentos y motivos", tags = "Descuento", notes = "Modificar los descuentos y motivos existentes.")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editDescuentoMotivo(@PathVariable int idDescuentoMotivo, @RequestBody DescuentoMotivo descuentoMotivo)
			throws Exception {
		descuentoMotivoService.editDescuentoMotivo(idDescuentoMotivo, descuentoMotivo);
	}
}
