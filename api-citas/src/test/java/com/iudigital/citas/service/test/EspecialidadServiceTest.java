package com.iudigital.citas.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.iudigital.citas.data.EspecialidadRepository;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.service.EspecialidadService;

@SpringBootTest
public class EspecialidadServiceTest {

	@InjectMocks
	EspecialidadService especialidadService;

	@Mock
	EspecialidadService especialidadServiceMock;

	@Mock
	EspecialidadRepository especialidadRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createEspecialidad() throws Exception {

		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(1);
		especialidad.setNombre("Oncologia");

		doNothing().when(especialidadServiceMock).createEspecialidad(especialidad);
		especialidadServiceMock.createEspecialidad(especialidad);
		verify(especialidadServiceMock, times(1)).createEspecialidad(especialidad);

	}

	@Test
	public void listarEspecialidades() throws Exception {

		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(1);
		especialidad.setNombre("Oncologia");

		List<Especialidad> list = new ArrayList<>();

		list.add(especialidad);

		when(especialidadRepository.findAll()).thenReturn(list);

		List<Especialidad> especialidadesObtenidas = especialidadService.getEspecialidades();

		assertEquals(especialidadesObtenidas.size(), list.size());

	}

	@Test
	public void editarEspecialidad() throws Exception {

		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(1);
		especialidad.setNombre("Oncologia");

		doNothing().when(especialidadServiceMock).editEspecialidad(1, especialidad);
		especialidadServiceMock.editEspecialidad(1, especialidad);
		verify(especialidadServiceMock, times(1)).editEspecialidad(1, especialidad);

	}
}
