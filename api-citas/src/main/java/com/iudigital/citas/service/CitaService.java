package com.iudigital.citas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.CitaRepository;
import com.iudigital.citas.data.UsuarioRepository;
import com.iudigital.citas.data.spec.CitaSpecification;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.domain.filter.CitaFilter;
import com.iudigital.citas.domain.filter.PaginationInfo;
import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CitaSpecification citaSpecification;

	public void createCita(Cita cita) throws Exception {

		List<Cita> citasExistentes = citaRepository.findCitasExistentes(cita.getFechaCita(),
				cita.getMedico().getIdUsuario());
		Usuario medicoNuevaCita = usuarioRepository.findMedicoById(cita.getMedico().getIdUsuario());

		if (citasExistentes.isEmpty() && medicoNuevaCita != null) {

			cita.setFechaCreacion(LocalDateTime.now());
			cita.setEstadoPago(EstadoPago.NO_PAGADA);
			cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
			citaRepository.save(cita);

		} else if (!citasExistentes.isEmpty()) {
			throw new Exception("Este espacio ya esta ocupado, escoja otra fecha, hora o médico.");

		} else if (medicoNuevaCita == null) {
			throw new Exception("El médico con Id " + cita.getMedico().getIdUsuario() + " no existe.");
		}

	}

	public Cita crearCitaReturn(Cita cita) {
		return citaRepository.save(cita);
	}

	public List<Cita> getCitas() throws Exception {
		List<Cita> citas = (List<Cita>) citaRepository.findAll();
		return citas;
	}

	public void reprogramarCita(Long idCita, Cita citaDeseada) throws Exception {

		Cita citaInconveniente = citaRepository.findById(idCita).orElse(null);
		List<Cita> citasExistentes = citaRepository.findCitasExistentes(citaDeseada.getFechaCita(),
				citaDeseada.getMedico().getIdUsuario());

		Usuario medicoNuevaCita = usuarioRepository.findMedicoById(citaDeseada.getMedico().getIdUsuario());

		LocalDateTime fechaNuevaCita = citaDeseada.getFechaCita();

		if (citasExistentes.isEmpty() && fechaNuevaCita.isAfter(LocalDateTime.now().plusDays(1))
				&& !(medicoNuevaCita == null)) {

			citaInconveniente.setFechaCita(citaDeseada.getFechaCita());
			citaInconveniente.setMedico(citaDeseada.getMedico());
			citaInconveniente.setFechaActualizacion(LocalDateTime.now());

			citaRepository.save(citaInconveniente);
		} else if (!citasExistentes.isEmpty()) {
			throw new Exception("Este espacio ya esta ocupado, escoja otra fecha, hora o médico.");
		} else if (fechaNuevaCita.isAfter(LocalDateTime.now().plusDays(1)) == false) {
			throw new Exception(
					"No se permite reprogramación, debe ser después del " + LocalDateTime.now().plusDays(1) + ".");
		} else if (medicoNuevaCita == null) {
			throw new Exception("El médico con Id " + citaDeseada.getMedico().getIdUsuario() + " no existe.");
		}

	}

	public List<Cita> getByFechaCitaBetween(LocalDateTime desde, LocalDateTime hasta) {
		List<Cita> citas = citaRepository.findByfechaCitaBetween(desde, hasta);
		return citas;
	}

	public List<Cita> getCitasEstadoPago(EstadoPago estadoPago) {
		List<Cita> citas = citaRepository.findByestadoPago(estadoPago);
		return citas;

	}

	public List<Cita> getCitasEstadoAtencion(EstadoAtencion estadoAtencion) {
		List<Cita> citas = citaRepository.findByestadoAtencion(estadoAtencion);
		return citas;

	}

	public void cancelarCita(Long idCita) throws Exception {

		Cita citaUpdate = citaRepository.findById(idCita).orElse(null);

		if (!(citaUpdate == null) && !(citaUpdate.getEstadoPago().equals(EstadoPago.PAGADA))) {

			citaUpdate.setEstadoAtencion(EstadoAtencion.CANCELADA);

			citaRepository.save(citaUpdate);

		} else if (citaUpdate == null) {
			throw new Exception("La cita no existe.");
		} else if (citaUpdate.getEstadoPago().equals(EstadoPago.PAGADA)) {
			throw new Exception("No se puede cancelar una cita ya pagada");
		}

	}

	public void pagarCita(Long idCita) throws Exception {

		Cita citaUpdate = citaRepository.findById(idCita).orElse(null);

		if (!(citaUpdate == null) && !(citaUpdate.getEstadoPago().name().equals("PAGADA"))) {

			citaUpdate.setEstadoPago(EstadoPago.PAGADA);

			citaRepository.save(citaUpdate);

		} else if (citaUpdate == null) {
			throw new Exception("La cita no existe.");
		} else if (citaUpdate.getEstadoPago().name().equals("PAGADA")) {
			throw new Exception("La cita ya fue pagada.");
		}

	}
	
	public Cita getCitaById(Long idCita)throws Exception {
		
		Cita cita = citaRepository.findById(idCita).orElse(null);
		if( cita!= null) {
		return cita;
		} else {
			throw new Exception("La cita con id "+idCita+" no existe.");
		}
		
	}

	public List<Cita> getAllCitas(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<Cita> pagedResult = citaRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cita>();
		}
	}

	public List<Cita> getSpecCitaList(CitaFilter request, PaginationInfo paginationInfo) throws Exception {

		Pageable paging = PageRequest.of(paginationInfo.getPage(), paginationInfo.getPageSize());
		Page<Cita> pages = citaRepository.findAll(citaSpecification.getSpeCitas(request, paginationInfo.getSortBy()),
				paging);
		return pages.getContent();
		/*
		 * if (pages.hasContent()) { return pages.getContent(); } else { return new
		 * ArrayList<Cita>(); }
		 */

	}
	
	
	public ResponseEntity<Map<String, Object>> busquedaCitasSpec(CitaFilter request, PaginationInfo paginationInfo) throws Exception{
		
		List<Cita> cits = new ArrayList<Cita>();
		Pageable paging = PageRequest.of(  paginationInfo.getPage(), paginationInfo.getPageSize());
		Page<Cita> pageCits = citaRepository.findAll(citaSpecification.getSpeCitas(request, paginationInfo.getSortBy()), paging);
		
		cits = pageCits.getContent();
		
		Map<String, Object> response = new HashMap<>();
		response.put("citas", cits);
		response.put("currentPage", pageCits.getNumber());
		response.put("totalItems", pageCits.getTotalElements());
		response.put("totalPages", pageCits.getTotalPages());
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

	public ResponseEntity<Map<String, Object>> getAllCits(int page, int size, String sortBy) {

		try {
			List<Cita> cits = new ArrayList<Cita>();
			Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));

			Page<Cita> pageCits;

			pageCits = citaRepository.findAll(paging);

			cits = pageCits.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("citas", cits);
			response.put("currentPage", pageCits.getNumber());
			response.put("totalItems", pageCits.getTotalElements());
			response.put("totalPages", pageCits.getTotalPages());
			
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	
	public ResponseEntity<Map<String, Object>> getCitasPendientesPac(int page, int size, String documento){
		
		try {
			List<Cita> cits = new ArrayList<Cita>();
			Pageable paging = PageRequest.of(page, size, Sort.by("cita_id"));
			
			Page<Cita> pageCits;
			
			Usuario usuario = usuarioRepository.findBynumeroDoc(documento);
			
			pageCits = citaRepository.findPendientesByIdPaciente(usuario.getIdUsuario(), paging);
			
			cits = pageCits.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("citas", cits);
			response.put("currentPage", pageCits.getNumber());
			response.put("totalItems", pageCits.getTotalElements());
			response.put("totalPages", pageCits.getTotalPages());
			
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
