package com.iudigital.citas.domain.filter;

import io.swagger.annotations.ApiParam;

public class PaginationInfo {

	@ApiParam(value = "Numero de pagina")
	private Integer pageNo;

	@ApiParam(value = "Tamaño de pagina")
	private Integer pageSize;

	@ApiParam(value = "Definir orden, por defecto ascendente", allowableValues = "asc, desc")
	private String sortBy;

	public PaginationInfo() {

	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
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
		return "PaginationInfo [pageNo=" + pageNo + ", pageSize=" + pageSize + ", sortBy=" + sortBy + "]";
	}

}
