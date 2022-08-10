package com.iudigital.citas.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.citas.domain.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer> {

}
