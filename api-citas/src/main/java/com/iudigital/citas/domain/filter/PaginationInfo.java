package com.iudigital.citas.domain.filter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiParam;

public class PaginationInfo {

	@ApiParam(value = "Numero de pagina")
	private Integer page = 0;

	@Min(value = 0, message = "error.pagination.size.min")
	@Max(value = 9, message = "error.pagination.size.max")
	@ApiParam(value = "Tamaño de pagina")
	private Integer pageSize = 3;

	@ApiParam(value = "Definir orden, por defecto ascendente", allowableValues = "asc, desc")
	private String sortBy = "idCita";

	public PaginationInfo() {

	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public String toString() {
		return "PaginationInfo [page=" + page + ", pageSize=" + pageSize + ", sortBy=" + sortBy + "]";
	}

}
