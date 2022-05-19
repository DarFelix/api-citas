package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.DescuentoMotivo;

@Repository
public interface DescuentoMotivoRepository extends CrudRepository<DescuentoMotivo, Integer> {

}
