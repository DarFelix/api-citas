package com.iudigital.citas.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.DescuentoMotivo;

@Repository
public interface DescuentoMotivoRepository extends CrudRepository<DescuentoMotivo, Integer> {

	@Query(value = "select * from descuentos_motivos as d where d.estado = 'ACTIVO'", nativeQuery = true)
	public List<DescuentoMotivo> findDescuentosActivos();
	
	
}
