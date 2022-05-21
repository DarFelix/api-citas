
package com.iudigital.citas.controller.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.filter.CitaFilter;

@Component
public class CitaSpecification {
	public Specification<Cita> getCitas(CitaFilter request) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (request.getEstadoAtencion() != null && !request.getEstadoAtencion().name().isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("estadoAtencion"), request.getEstadoAtencion()));
			}

			if (request.getEstadoPago() != null && !request.getEstadoPago().name().isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("estadoPago"), request.getEstadoPago()));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
