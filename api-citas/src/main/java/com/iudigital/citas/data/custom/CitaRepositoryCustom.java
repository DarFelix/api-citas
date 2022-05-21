package com.iudigital.citas.data.custom;

import org.springframework.data.domain.Page;

import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.filter.CitaFilter;
import com.iudigital.citas.domain.filter.PaginationInfo;

public interface CitaRepositoryCustom {

	Page<Cita> getCitas(CitaFilter filter, PaginationInfo paginationInfo);
}
