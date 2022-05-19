package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Consulta;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {

}
