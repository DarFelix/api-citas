package com.iudigital.citas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iudigital.citas.data.TratamientoRepository;
import com.iudigital.citas.domain.Tratamiento;

@Service
public class TratamientoService {

	@Autowired
	private TratamientoRepository tratamientoRepository;

	public void createTratamiento(Tratamiento tratamiento) {
		
		tratamiento.setFechaCreacion(LocalDateTime.now());
		tratamientoRepository.save(tratamiento);

	}

	public List<Tratamiento> getTratamientos() {
		List<Tratamiento> tratamientos = (List<Tratamiento>) tratamientoRepository.findAll();
		return tratamientos;
	}

	public void editTratamiento(int idTratamiento, Tratamiento tratamiento) throws Exception {

		Tratamiento tratamientoUpdate = tratamientoRepository.findById(idTratamiento).orElse(null);

		if (tratamientoUpdate != null) {

			tratamientoUpdate.setNombre(tratamiento.getNombre());
			tratamientoUpdate.setIdEspecialidad(tratamiento.getIdEspecialidad());
			tratamientoUpdate.setDiagnostico(tratamiento.getDiagnostico());
			tratamientoUpdate.setIdCita(tratamiento.getIdCita());
			tratamientoUpdate.setFechaActualizacion(LocalDateTime.now());

			tratamientoRepository.save(tratamientoUpdate);
		} else {
			throw new Exception("No existe el tratamiento");
		}

	}
}
