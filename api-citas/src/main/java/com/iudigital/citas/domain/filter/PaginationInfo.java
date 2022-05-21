package com.iudigital.citas.domain.filter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PaginationInfo {

	private Integer from = 0;
	@Min(value = 0, message = "error.pagination.size.min")
	@Max(value = 3, message = "error.pagination.size.max")
	private Integer size = 5;
	private String sortBy;
	private String sortOrder;

	public PaginationInfo() {

	}

	public PaginationInfo(Integer from, Integer size) {
		this.from = from;
		this.size = size;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}
