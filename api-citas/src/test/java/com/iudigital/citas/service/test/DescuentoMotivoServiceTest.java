package com.iudigital.citas.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.iudigital.citas.data.DescuentoMotivoRepository;
import com.iudigital.citas.domain.DescuentoMotivo;
import com.iudigital.citas.domain.Motivo;
import com.iudigital.citas.enums.EstadoDescuento;
import com.iudigital.citas.service.DescuentoMotivoService;

@SpringBootTest
public class DescuentoMotivoServiceTest {

	@InjectMocks
	DescuentoMotivoService descuentoMotivoService;

	@Mock
	DescuentoMotivoService descuentoMotivoServiceMock;

	@Mock
	DescuentoMotivoRepository descuentoMotivoRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createDescuentoMotivo() throws Exception {

		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();
		descuentoMotivo.setIdDescuentoMotivo(1);
		Motivo motivo = new Motivo();
		motivo.setIdMotivo(1);
		motivo.setNombre("CONTROL");
		descuentoMotivo.setMotivo(motivo);
		descuentoMotivo.setFechaCreacion(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		descuentoMotivo.setPorcentaje(30);
		descuentoMotivo.setEstadoDescuento(EstadoDescuento.ACTIVO);

		doNothing().when(descuentoMotivoServiceMock).createDescuentoMotivo(descuentoMotivo);
		descuentoMotivoServiceMock.createDescuentoMotivo(descuentoMotivo);
		verify(descuentoMotivoServiceMock, times(1)).createDescuentoMotivo(descuentoMotivo);

	}

	@Test
	public void listarDescuentosMotivos() throws Exception {

		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();
		descuentoMotivo.setIdDescuentoMotivo(1);
		Motivo motivo = new Motivo();
		motivo.setIdMotivo(1);
		motivo.setNombre("CONTROL");
		descuentoMotivo.setMotivo(motivo);
		descuentoMotivo.setFechaCreacion(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		descuentoMotivo.setPorcentaje(30);
		descuentoMotivo.setEstadoDescuento(EstadoDescuento.ACTIVO);

		List<DescuentoMotivo> list = new ArrayList<>();

		list.add(descuentoMotivo);

		when(descuentoMotivoRepository.findAll()).thenReturn(list);

		List<DescuentoMotivo> descMotivosObtenidos = descuentoMotivoService.getDescuentosMotivos();

		assertEquals(descMotivosObtenidos.size(), list.size());

	}

	@Test
	public void editarDescuentosMotivos() throws Exception {

		DescuentoMotivo descuentoMotivo = new DescuentoMotivo();
		descuentoMotivo.setIdDescuentoMotivo(1);
		Motivo motivo = new Motivo();
		motivo.setIdMotivo(1);
		motivo.setNombre("CONTROL");
		descuentoMotivo.setMotivo(motivo);
		descuentoMotivo.setFechaCreacion(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		descuentoMotivo.setPorcentaje(30);
		descuentoMotivo.setEstadoDescuento(EstadoDescuento.ACTIVO);

		doNothing().when(descuentoMotivoServiceMock).editDescuentoMotivo(1, descuentoMotivo);
		descuentoMotivoServiceMock.editDescuentoMotivo(1, descuentoMotivo);
		verify(descuentoMotivoServiceMock, times(1)).editDescuentoMotivo(1, descuentoMotivo);

	}
}
