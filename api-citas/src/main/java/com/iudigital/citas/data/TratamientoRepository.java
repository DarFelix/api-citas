package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Tratamiento;

@Repository
public interface TratamientoRepository extends CrudRepository<Tratamiento, Integer> {

}
