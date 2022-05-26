package com.iudigital.citas.controller.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.domain.filter.UsuarioFilter;

@Component
public class UsuarioSpecification {

	public Specification<Usuario> getUsers(UsuarioFilter request, String sortBy) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			
		
			
			if (request.getText() != null && !request.getText().isEmpty()) {
				predicates.add(criteriaBuilder.or(
						criteriaBuilder.like(criteriaBuilder.lower(root.get("nombres")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("apellidos")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("numeroDoc")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("telefono")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("correo")),
								"%" + request.getText().toLowerCase() + "%")
						));
			}
						
			
			if (request.getTipoDoc() != null) {
                predicates.add(criteriaBuilder.equal(root.get("tipoDoc"), request.getTipoDoc()));
            }
			
			
			if (request.getFechaNacimiento() != null) {
                predicates.add(criteriaBuilder.equal(root.get("fechaNacimiento"), request.getFechaNacimiento()));
            }

			query.orderBy(criteriaBuilder.asc(root.get(sortBy)));
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

}



/*
if (request.getNombres() != null && !request.getNombres().isEmpty()) {
	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombres")),
			"%" + request.getNombres().toLowerCase() + "%"));
}
if (request.getApellidos() != null && !request.getApellidos().isEmpty()) {
	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("apellidos")),
			"%" + request.getApellidos().toLowerCase() + "%"));
}

if (request.getEspecialidad() != null && !request.getEspecialidad().isEmpty()) {
	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("especialidad").get("nombre")),
			"%" + request.getEspecialidad().toLowerCase() + "%"));
}
if (request.getNumeroDoc() != null && !request.getNumeroDoc().isEmpty()) {
	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("numeroDoc")),
			"%" + request.getNumeroDoc().toLowerCase() + "%"));
}
if (request.getTelefono() != null && !request.getTelefono().isEmpty()) {
	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("telefono")),
			"%" + request.getTelefono().toLowerCase() + "%"));
}
if (request.getCorreo() != null && !request.getCorreo().isEmpty()) {
	predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("correo")),
			"%" + request.getCorreo().toLowerCase() + "%"));
	
}
*/