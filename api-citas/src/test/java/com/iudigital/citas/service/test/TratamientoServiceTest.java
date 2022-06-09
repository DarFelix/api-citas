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

import com.iudigital.citas.data.TratamientoRepository;
import com.iudigital.citas.domain.Tratamiento;
import com.iudigital.citas.service.TratamientoService;

@SpringBootTest
public class TratamientoServiceTest {

	@InjectMocks
	TratamientoService tratamientoService;

	@Mock
	TratamientoService tratamientoServiceMock;

	@Mock
	TratamientoRepository tratamientoRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createTratamiento() throws Exception {

		Tratamiento tratamiento = new Tratamiento();
		tratamiento.setIdTratamiento(1);
		tratamiento.setNombre("Medicación");
		tratamiento.setIdCita(1);
		tratamiento.setDiagnostico("Alergia");
		tratamiento.setFechaCreacion(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));

		doNothing().when(tratamientoServiceMock).createTratamiento(tratamiento);
		tratamientoServiceMock.createTratamiento(tratamiento);
		verify(tratamientoServiceMock, times(1)).createTratamiento(tratamiento);

	}

	@Test
	public void listarTratamientos() throws Exception {

		Tratamiento tratamiento = new Tratamiento();
		tratamiento.setIdTratamiento(1);
		tratamiento.setNombre("Medicación");
		tratamiento.setIdCita(1);
		tratamiento.setDiagnostico("Alergia");
		tratamiento.setFechaCreacion(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));

		List<Tratamiento> list = new ArrayList<>();

		list.add(tratamiento);

		when(tratamientoRepository.findAll()).thenReturn(list);

		List<Tratamiento> tratamientosObtenidos = tratamientoService.getTratamientos();

		assertEquals(tratamientosObtenidos.size(), list.size());

	}

	@Test
	public void editarTratamiento() throws Exception {

		Tratamiento tratamiento = new Tratamiento();
		tratamiento.setIdTratamiento(1);
		tratamiento.setNombre("Medicación");
		tratamiento.setIdCita(1);
		tratamiento.setDiagnostico("Alergia");
		tratamiento.setFechaCreacion(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));

		doNothing().when(tratamientoServiceMock).editTratamiento(1, tratamiento);
		tratamientoServiceMock.editTratamiento(1, tratamiento);
		verify(tratamientoServiceMock, times(1)).editTratamiento(1, tratamiento);

	}
}
