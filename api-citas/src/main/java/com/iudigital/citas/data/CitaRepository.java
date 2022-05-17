package com.iudigital.citas.data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.iudigital.citas.domain.Cita;

public interface CitaRepository extends CrudRepository<Cita, Integer> {

	@Query(value = "select * from citas c where c.fecha_cita between date_sub( :fechaHoraCita , interval 19 minute) and date_add( :fechaHoraCita, interval 19 minute) and c.medico_id = :idMedico ", nativeQuery = true)
	public List<Cita> findCitasExistentes(LocalDateTime fechaHoraCita, int idMedico);
	
}
