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

import com.iudigital.citas.data.ConsultaRepository;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.domain.Especialidad;
import com.iudigital.citas.domain.TipoCita;
import com.iudigital.citas.service.ConsultaService;

@SpringBootTest
public class ConsultaServiceTest {

	@InjectMocks
	ConsultaService consultaService;
	
	@Mock
	ConsultaService consultaServiceMock;
	
	@Mock
	ConsultaRepository consultaRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createConsulta() throws Exception {

		Consulta consulta = new Consulta();
		consulta.setIdConsulta(1);
		TipoCita tipoCita = new TipoCita();
		tipoCita.setIdTipoCita(1);
		tipoCita.setNombre("General");
		consulta.setTipoCita(tipoCita);
		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(1);
		especialidad.setNombre("Medicina interna");
		consulta.setEspecialidad(especialidad);
		consulta.setCosto(40000.2);

		doNothing().when(consultaServiceMock).createConsulta(consulta);
		consultaServiceMock.createConsulta(consulta);
		verify(consultaServiceMock, times(1)).createConsulta(consulta);

	}
	
	@Test
	public void listarConsultas() throws Exception {

		Consulta consulta = new Consulta();
		consulta.setIdConsulta(1);
		TipoCita tipoCita = new TipoCita();
		tipoCita.setIdTipoCita(1);
		tipoCita.setNombre("General");
		consulta.setTipoCita(tipoCita);
		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(1);
		especialidad.setNombre("Medicina interna");
		consulta.setEspecialidad(especialidad);
		consulta.setCosto(40000.2);

		List<Consulta> list = new ArrayList<>();

		list.add(consulta);

		when(consultaRepository.findAll()).thenReturn(list);

		List<Consulta> consultasObtenidas = consultaService.getConsultas();

		assertEquals(consultasObtenidas.size(), list.size());

	}
	
	@Test
	public void editarConsulta() throws Exception {

		Consulta consulta = new Consulta();
		consulta.setIdConsulta(1);
		TipoCita tipoCita = new TipoCita();
		tipoCita.setIdTipoCita(1);
		tipoCita.setNombre("General");
		consulta.setTipoCita(tipoCita);
		Especialidad especialidad = new Especialidad();
		especialidad.setIdEspecialidad(1);
		especialidad.setNombre("Medicina interna");
		consulta.setEspecialidad(especialidad);
		consulta.setCosto(40000.2);


		doNothing().when(consultaServiceMock).editConsulta(1, consulta);
		consultaServiceMock.editConsulta(1, consulta);
		verify(consultaServiceMock, times(1)).editConsulta(1, consulta);

	}

}
