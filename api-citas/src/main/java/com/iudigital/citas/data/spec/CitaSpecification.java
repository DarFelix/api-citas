package com.iudigital.citas.data.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.domain.filter.CitaFilter;

@Component
public class CitaSpecification {

	public Specification<Cita> getSpeCitas(CitaFilter request, String sortBy) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (request.getFechaCita() != null) {
				predicates.add(criteriaBuilder.equal(root.get("fechaCita"), request.getFechaCita()));
			}

			if (request.getText() != null && !request.getText().isEmpty()) {
				predicates.add(criteriaBuilder.or(
						criteriaBuilder.like(criteriaBuilder.lower(root.get("usuario").get("nombres")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("usuario").get("apellidos")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("medico").get("nombres")),
								"%" + request.getText().toLowerCase() + "%"),
						criteriaBuilder.like(criteriaBuilder.lower(root.get("medico").get("apellidos")),
								"%" + request.getText().toLowerCase() + "%")));
			}

			if (request.getEstadoAtencion() != null) {
				predicates.add(criteriaBuilder.equal(root.get("estadoAtencion"), request.getEstadoAtencion()));
			}

			if (request.getEstadoPago() != null) {
				predicates.add(criteriaBuilder.equal(root.get("estadoPago"), request.getEstadoPago()));
			}
			
			if (request.getConsultasIds() != null && !request.getConsultasIds().isEmpty()) {
				Join<Cita, Consulta> consultas = root.join("consulta");
				predicates.add(consultas.in(request.getConsultasIds()));
			}

			query.orderBy(criteriaBuilder.asc(root.get(sortBy)));
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

}





/*
 * if (request.getNombreUsuario() != null &&
 * !request.getNombreUsuario().isEmpty()) {
 * predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("usuario")
 * .get("nombres")), "%" + request.getNombreUsuario().toLowerCase() + "%")); }
 * if (request.getApellidoUsuario() != null &&
 * !request.getApellidoUsuario().isEmpty()) {
 * predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("usuario")
 * .get("apellidos")), "%" + request.getApellidoUsuario().toLowerCase() + "%"));
 * }
 * 
 * if (request.getNombreMedico() != null &&
 * !request.getNombreMedico().isEmpty()) {
 * predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("medico").
 * get("nombres")), "%" + request.getNombreMedico().toLowerCase() + "%")); } if
 * (request.getApellidoMedico() != null &&
 * !request.getApellidoMedico().isEmpty()) {
 * predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("medico").
 * get("apellidos")), "%" + request.getApellidoMedico().toLowerCase() + "%")); }
 * 
 * if (request.getNombreEspecialidad() != null &&
 * !request.getNombreEspecialidad().isEmpty()) {
 * predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("consulta"
 * ).get("especialidad").get("nombre")), "%" +
 * request.getNombreEspecialidad().toLowerCase() + "%"));
 * 
 * }
 */