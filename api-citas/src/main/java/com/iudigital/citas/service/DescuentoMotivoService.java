package com.iudigital.citas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.DescuentoMotivoRepository;
import com.iudigital.citas.domain.DescuentoMotivo;

@Service
public class DescuentoMotivoService {

	@Autowired
	private DescuentoMotivoRepository descuentoMotivoRepository;

	public void createDescuentoMotivo(DescuentoMotivo descuentoMotivo) {
		descuentoMotivo.setFechaCreacion(LocalDateTime.now());
		descuentoMotivoRepository.save(descuentoMotivo);

	}

	public List<DescuentoMotivo> getDescuentosMotivos() {
		List<DescuentoMotivo> descuentosMotivos = (List<DescuentoMotivo>) descuentoMotivoRepository.findAll();
		return descuentosMotivos;
	}

	public void editDescuentoMotivo(int idDescuentoMotivo, DescuentoMotivo descuentoMotivo) throws Exception {

		DescuentoMotivo descuentoMotivoUpdate = descuentoMotivoRepository.findById(idDescuentoMotivo).orElse(null);

		if (descuentoMotivoUpdate != null) {

			descuentoMotivoUpdate.setIdMotivo(descuentoMotivo.getIdMotivo());
			descuentoMotivoUpdate.setPorcentaje(descuentoMotivo.getPorcentaje());
			descuentoMotivoUpdate.setEstadoDescuento(descuentoMotivo.getEstadoDescuento());
			descuentoMotivoUpdate.setFechaActualizacion(LocalDateTime.now());

			descuentoMotivoRepository.save(descuentoMotivoUpdate);
		} else {
			throw new Exception("No existe el descuento-motivo");
		}

	}
}
