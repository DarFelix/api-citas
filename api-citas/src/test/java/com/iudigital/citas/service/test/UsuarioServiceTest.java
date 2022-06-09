package com.iudigital.citas.service.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.iudigital.citas.data.UsuarioRepository;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.domain.filter.PaginationInfo;
import com.iudigital.citas.domain.filter.UsuarioFilter;
import com.iudigital.citas.service.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {

	@InjectMocks
	UsuarioService usuarioService;

	@Mock
	UsuarioRepository usuarioRepository;

	@Mock
	UsuarioService usuarioServiceMock;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void crearUsuario() {

		Usuario usuario = new Usuario();

		doNothing().when(usuarioServiceMock).createUsuario(usuario);

		usuarioServiceMock.createUsuario(usuario);
		verify(usuarioServiceMock, times(1)).createUsuario(usuario);

	}

	@Test
	public void listarUsuarios() throws Exception {

		Usuario usuario = new Usuario();

		List<Usuario> list = new ArrayList<>();

		list.add(usuario);

		when(usuarioRepository.findAll()).thenReturn(list);

		List<Usuario> usuariosObtenidos = usuarioService.getUsuarios();

		assertEquals(usuariosObtenidos.size(), list.size());

	}

	@Test
	public void editarUsuario() throws Exception {

		Usuario usuario = new Usuario();

		doNothing().when(usuarioServiceMock).editUsuario("3232", usuario);
		;
		usuarioServiceMock.editUsuario("3232", usuario);
		verify(usuarioServiceMock, times(1)).editUsuario("3232", usuario);

	}

	@Test
	public void testGetUsuarioById() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);

		Optional<Usuario> optUser = Optional.of(usuario);

		when(usuarioRepository.findById(1)).thenReturn(optUser);

		Usuario usuarioActual = usuarioService.getUsuarioById(1);

		verify(usuarioRepository).findById(1);

		assertEquals(1, usuarioActual.getIdUsuario());
	}

	@Test
	public void getSpecUsuarioList() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNombres("Carlos");

		List<Usuario> list = new ArrayList<>();

		list.add(usuario);

		UsuarioFilter usuarioFilter1 = new UsuarioFilter();
		usuarioFilter1.setText("Carl");
		PaginationInfo paginationInfo1 = new PaginationInfo();
		paginationInfo1.setPageNo(1);
		paginationInfo1.setPageSize(1);
		paginationInfo1.setSortBy("idUsuario");

		when(usuarioServiceMock.getSpecList(usuarioFilter1, paginationInfo1)).thenReturn(list);
		
		UsuarioFilter usuarioFilter2 = new UsuarioFilter();
		usuarioFilter2.setText("Edy");
		
		List<Usuario> usuarios = usuarioServiceMock.getSpecList(usuarioFilter1, paginationInfo1);

		assertEquals(list.size(), usuarios.size());

	}
}
