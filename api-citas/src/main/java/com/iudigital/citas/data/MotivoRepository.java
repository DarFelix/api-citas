package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Motivo;

@Repository
public interface MotivoRepository extends CrudRepository<Motivo, Integer> {

}
