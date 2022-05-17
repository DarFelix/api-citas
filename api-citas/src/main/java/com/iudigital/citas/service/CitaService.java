package com.iudigital.citas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.CitaRepository;
import com.iudigital.citas.data.UsuarioRepository;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void createCita(Cita cita) throws Exception {

		List<Cita> citasExistentes = citaRepository.findCitasExistentes(cita.getFechaCita(), cita.getIdMedico());
		Usuario medicoNuevaCita = usuarioRepository.findMedicoById(cita.getIdMedico());
		
		if (citasExistentes.isEmpty() && !(medicoNuevaCita == null)) {

			cita.setFechaCreacion(LocalDateTime.now());
			cita.setEstadoPago(EstadoPago.NO_PAGADA);
			cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
			citaRepository.save(cita);

		} else if (!citasExistentes.isEmpty()) {
			throw new Exception("Este espacio ya esta ocupado, escoja otra fecha, hora o médico.");
	
		} else if (medicoNuevaCita == null) {
			throw new Exception("El médico con Id " + cita.getIdMedico() + " no existe.");
		}


	}

	public List<Cita> getCitas() {
		List<Cita> citas = (List<Cita>) citaRepository.findAll();
		return citas;
	}

	public void reprogramarCita(int idCita, Cita citaDeseada) throws Exception {

		Cita citaInconveniente = citaRepository.findById(idCita).orElse(null);
		List<Cita> citasExistentes = citaRepository.findCitasExistentes(citaDeseada.getFechaCita(),
				citaDeseada.getIdMedico());

		Usuario medicoNuevaCita = usuarioRepository.findMedicoById(citaDeseada.getIdMedico());

		LocalDateTime fechaNuevaCita = citaDeseada.getFechaCita();

		if (citasExistentes.isEmpty() && fechaNuevaCita.isAfter(LocalDateTime.now().plusDays(1))
				&& !(medicoNuevaCita == null)) {

			citaInconveniente.setFechaCita(citaDeseada.getFechaCita());
			citaInconveniente.setIdMedico(citaDeseada.getIdMedico());
			citaInconveniente.setEstadoAtencion(EstadoAtencion.PENDIENTE);
			citaInconveniente.setEstadoPago(EstadoPago.NO_PAGADA);
			citaInconveniente.setFechaActualizacion(LocalDateTime.now());

			citaRepository.save(citaInconveniente);
		} else if (!citasExistentes.isEmpty()) {
			throw new Exception("Este espacio ya esta ocupado, escoja otra fecha, hora o médico.");
		} else if (fechaNuevaCita.isAfter(LocalDateTime.now().plusDays(1)) == false) {
			throw new Exception(
					"No se permite reprogramación, debe ser después del " + LocalDateTime.now().plusDays(1) + ".");
		} 
		else if (medicoNuevaCita == null) {
			throw new Exception("El médico con Id " + citaDeseada.getIdMedico() + " no existe.");
		}

	}
}
