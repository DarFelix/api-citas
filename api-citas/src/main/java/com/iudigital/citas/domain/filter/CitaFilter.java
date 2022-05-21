package com.iudigital.citas.domain.filter;

import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;

public class CitaFilter {

	private EstadoAtencion estadoAtencion;
	private EstadoPago estadoPago;
	
	public EstadoAtencion getEstadoAtencion() {
		return estadoAtencion;
	}
	public void setEstadoAtencion(EstadoAtencion estadoAtencion) {
		this.estadoAtencion = estadoAtencion;
	}
	public EstadoPago getEstadoPago() {
		return estadoPago;
	}
	public void setEstadoPago(EstadoPago estadoPago) {
		this.estadoPago = estadoPago;
	}
	
	public static class CitaFilterBuilder{
		
		private CitaFilter filter;
		
		public CitaFilterBuilder() {
			
			filter = new CitaFilter();
		}
		
		public CitaFilterBuilder setEstadoAtencion(EstadoAtencion estadoAtencion) {
			filter.estadoAtencion = estadoAtencion;
			return this;
		}
		
		public CitaFilterBuilder setEstadoPago(EstadoPago estadoPago) {
			filter.estadoPago = estadoPago;
			return this;
		}
		
		public CitaFilter build() {
			return filter;
		}
		
	}

	
}
