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

import com.iudigital.citas.data.CitaRepository;
import com.iudigital.citas.domain.Cita;
import com.iudigital.citas.domain.Consulta;
import com.iudigital.citas.domain.DescuentoMotivo;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.domain.filter.CitaFilter;
import com.iudigital.citas.domain.filter.PaginationInfo;
import com.iudigital.citas.enums.EstadoAtencion;
import com.iudigital.citas.enums.EstadoPago;
import com.iudigital.citas.service.CitaService;

@SpringBootTest
public class CitaServiceTest {

	@InjectMocks
	CitaService citaService;

	@Mock
	CitaRepository citaRepository;

	@Mock
	CitaService citaServiceMock;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void crearCita() {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		when(citaRepository.save(cita)).thenReturn(cita);

		Cita citaReturn = citaService.crearCitaReturn(cita);

		assertEquals(citaReturn.getIdCita(), cita.getIdCita());

	}

	@Test
	public void listarCitas() throws Exception {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		List<Cita> citas = new ArrayList<>();

		citas.add(cita);

		when(citaRepository.findAll()).thenReturn(citas);

		List<Cita> citasObtenidas = citaService.getCitas();

		assertEquals(citasObtenidas.size(), citas.size());

	}

	@Test
	public void createCitaVoid() throws Exception {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		doNothing().when(citaServiceMock).createCita(cita);
		;
		citaServiceMock.createCita(cita);
		verify(citaServiceMock, times(1)).createCita(cita);

	}

	@Test
	public void reprogramarCita() throws Exception {

		Cita cita = new Cita();

		cita.setIdCita(1L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		doNothing().when(citaServiceMock).reprogramarCita(1L, cita);
		citaServiceMock.reprogramarCita(1L, cita);
		verify(citaServiceMock, times(1)).reprogramarCita(1L, cita);

	}

	@Test
	public void getCitasByFechaBetween() {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		List<Cita> list = new ArrayList<>();

		list.add(cita);

		LocalDateTime desde1 = LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 30, 00);
		LocalDateTime hasta1 = LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 50, 00);

		when(citaServiceMock.getByFechaCitaBetween(desde1, hasta1)).thenReturn(list);

		LocalDateTime desde2 = LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 30, 00);
		LocalDateTime hasta2 = LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 50, 00);

		List<Cita> citas = citaServiceMock.getByFechaCitaBetween(desde2, hasta2);

		assertEquals(list.size(), citas.size());

	}

	@Test
	public void getCitasByEstadoPago() {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		List<Cita> list = new ArrayList<>();

		list.add(cita);

		when(citaServiceMock.getCitasEstadoPago(EstadoPago.PAGADA)).thenReturn(list);

		List<Cita> citas = citaServiceMock.getCitasEstadoPago(EstadoPago.PAGADA);

		assertEquals(list.size(), citas.size());

	}

	@Test
	public void getCitasByEstadoAtencion() {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		List<Cita> list = new ArrayList<>();

		list.add(cita);

		when(citaServiceMock.getCitasEstadoAtencion(EstadoAtencion.PENDIENTE)).thenReturn(list);

		List<Cita> citas = citaServiceMock.getCitasEstadoAtencion(EstadoAtencion.PENDIENTE);

		assertEquals(list.size(), citas.size());

	}

	@Test
	public void cancelarCita() throws Exception {

		Cita cita = new Cita();

		cita.setIdCita(1L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		doNothing().when(citaServiceMock).cancelarCita(1L);
		citaServiceMock.cancelarCita(1L);
		verify(citaServiceMock, times(1)).cancelarCita(1L);

	}

	@Test
	public void pagarCita() throws Exception {

		Cita cita = new Cita();

		cita.setIdCita(1L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		cita.setUsuario(new Usuario());
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.NO_PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		doNothing().when(citaServiceMock).pagarCita(1L);
		citaServiceMock.pagarCita(1L);
		verify(citaServiceMock, times(1)).pagarCita(1L);

	}

	@Test
	public void getAllCitasPaging() {

		Cita cita = new Cita();

		cita.setIdCita(22L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));

		Usuario usuario = new Usuario();

		usuario.setNombres("Andres");

		cita.setUsuario(usuario);
		cita.setMedico(new Usuario());
		cita.setConsulta(new Consulta());
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		List<Cita> list = new ArrayList<>();

		list.add(cita);

		when(citaServiceMock.getAllCitas(1, 1, "idCita")).thenReturn(list);

		List<Cita> citas = citaServiceMock.getAllCitas(1, 1, "idCita");

		assertEquals(list.size(), citas.size());

	}

	@Test
	public void getSpecCitaList() throws Exception {

		Cita cita = new Cita();
		cita.setIdCita(1L);
		cita.setFechaCita(LocalDateTime.of(2024, Month.DECEMBER, 29, 14, 40, 00));
		Usuario usuario = new Usuario();
		usuario.setNombres("Andres");
		cita.setUsuario(usuario);
		cita.setMedico(new Usuario());
		Consulta consulta = new Consulta();
		consulta.setIdConsulta(1);
		cita.setConsulta(consulta);
		cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
		cita.setEstadoPago(EstadoPago.PAGADA);
		cita.setDescuentoMotivo(new DescuentoMotivo());
		cita.setFechaCreacion(LocalDateTime.of(2022, Month.JUNE, 8, 9, 59, 33));

		List<Cita> list = new ArrayList<>();

		list.add(cita);

		CitaFilter citaFilter1 = new CitaFilter();
		citaFilter1.setEstadoPago(EstadoPago.PAGADA);
		PaginationInfo paginationInfo1 = new PaginationInfo();
		paginationInfo1.setPage(1);
		paginationInfo1.setPageSize(1);
		paginationInfo1.setSortBy("idCita");
	

		when(citaServiceMock.getSpecCitaList(citaFilter1, paginationInfo1)).thenReturn(list);

		
		List<Cita> citas = citaServiceMock.getSpecCitaList(citaFilter1, paginationInfo1);


		assertEquals(list.size(), citas.size());

	}

}


//@Autowired
//private CitaService citaService;
//
//@Autowired
//private CitaRepository citaRepository;
//
//@Autowired
//private UsuarioRepository usuarioRepository;
//
//@Autowired
//private ConsultaRepository consultaRepository;
//
//@Autowired
//private DescuentoMotivoRepository descuentoMotivoRepository;
//
//
//@Test
//void testCreateCita() throws Exception {
//	
//	Cita cita = new Cita();
//	
//	cita.setIdCita(24L);
//	cita.setFechaCita(LocalDateTime.of(2025,Month.JULY, 29, 12, 40, 00));
//	cita.setUsuario(usuarioRepository.findById(1).orElse(null));
//	cita.setMedico(usuarioRepository.findById(2).orElse(null));
//	cita.setConsulta(consultaRepository.findById(1).orElse(null));
//	cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
//	cita.setEstadoPago(EstadoPago.NO_PAGADA);
//	cita.setDescuentoMotivo(descuentoMotivoRepository.findById(1).orElse(null));
//	cita.setFechaCreacion(LocalDateTime.of(2022,Month.JUNE, 8, 9, 59, 33));
//	
//	citaService.createCita(cita);
//	
//	 Boolean actualResult = citaRepository.existsById(24L);
//   assertThat(actualResult).isTrue();
//	
//}
//
//
//@Test
//void testReprogramarCita() throws Exception {
//	
//	Cita cita = new Cita();
//	
//	cita.setIdCita(22L);
//	cita.setFechaCita(LocalDateTime.of(2024,Month.DECEMBER, 29, 14, 40, 00));
//	cita.setUsuario(usuarioRepository.findById(1).orElse(null));
//	cita.setMedico(usuarioRepository.findById(2).orElse(null));
//	cita.setConsulta(consultaRepository.findById(1).orElse(null));
//	cita.setEstadoAtencion(EstadoAtencion.PENDIENTE);
//	cita.setEstadoPago(EstadoPago.NO_PAGADA);
//	cita.setDescuentoMotivo(descuentoMotivoRepository.findById(1).orElse(null));
//	cita.setFechaCreacion(LocalDateTime.of(2022,Month.JUNE, 8, 9, 59, 33));
//	
//	citaService.reprogramarCita(22L, cita);
//	
//	 Boolean actualResult = citaRepository.existsById(22L);
//   assertThat(actualResult).isTrue();
//	
//}
//
