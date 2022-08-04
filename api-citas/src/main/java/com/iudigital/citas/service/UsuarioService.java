package com.iudigital.citas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.UsuarioRepository;
import com.iudigital.citas.data.spec.UsuarioSpecification;
import com.iudigital.citas.domain.Usuario;
import com.iudigital.citas.domain.filter.PaginationInfo;
import com.iudigital.citas.domain.filter.UsuarioFilter;
import com.iudigital.citas.enums.EstadoUsuario;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioSpecification usuarioSpecification;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void createUsuario(Usuario usuario) {
		
		
		String pw = passwordEncoder.encode(usuario.getPass());
		System.out.println(pw);
		usuario.setPass(pw);
		
		usuario.setEstadoUsuario(EstadoUsuario.ACTIVO);
		usuario.setFechaCreacion(LocalDateTime.now());
	
		usuarioRepository.save(usuario);

	}

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		return usuarios;
	}

	public void editUsuario(String numeroDoc, Usuario usuario) throws Exception {

		Usuario usuarioUpdate = usuarioRepository.findBynumeroDoc(numeroDoc);

		if (usuarioUpdate != null) {

			usuarioUpdate.setNombres(usuario.getNombres());
			usuarioUpdate.setApellidos(usuario.getApellidos());
			usuarioUpdate.setTipoDoc(usuario.getTipoDoc());
			usuarioUpdate.setNumeroDoc(usuario.getNumeroDoc());
			usuarioUpdate.setFechaNacimiento(usuario.getFechaNacimiento());
			usuarioUpdate.setTelefono(usuario.getTelefono());
			usuarioUpdate.setCorreo(usuario.getCorreo());
			usuarioUpdate.setPass(usuario.getPass());
			usuarioUpdate.setEstadoUsuario(usuario.getEstadoUsuario());
			usuarioUpdate.setEspecialidad(usuario.getEspecialidad());

			usuarioUpdate.setFechaActualizacion(LocalDateTime.now());

			usuarioRepository.save(usuarioUpdate);
		} else {
			throw new Exception("No existe usuario");
		}

	}

	public Usuario getUsuarioById(int idUsuario) throws Exception {

		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		if (usuario != null) {
			return usuario;
		} else {
			throw new Exception("No existe usuario");
		}

	}
	
	public Usuario getUserByDoc(String documento) throws Exception {
		
		Usuario usuario = usuarioRepository.findBynumeroDoc(documento);
		if (usuario != null) {
			return usuario;
		} else {
			throw new Exception("No existe usuario");
		}
		
	}
	
	

	public List<Usuario> getSpecList(UsuarioFilter request, PaginationInfo paginationInfo) throws Exception{
		Pageable paging = PageRequest.of(paginationInfo.getPageNo() - 1, paginationInfo.getPageSize());
		Page<Usuario> pages = usuarioRepository.findAll(usuarioSpecification.getUsers(request, paginationInfo.getSortBy()), paging);

		return pages.getContent();
//		if (pages.hasContent()) {
//			return pages.getContent();
//		} else {
//			return new ArrayList<Usuario>();
//		}

	}
	
	
	public List<Usuario> getMedicosByConsulta(Integer idEspecialidad) throws Exception {
		
		List<Usuario> usuarios = usuarioRepository.findMedicoByEspecialidad(idEspecialidad);
		return usuarios;
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> optionalUser = usuarioRepository.findByCorreo(username);
		
		if (!optionalUser.isPresent()) { //if (optionalUser.isPresent() == false) {
			
			throw new UsernameNotFoundException("Usuario no existe");
			
		} else {
			
			Usuario user = optionalUser.get();
			
			List<SimpleGrantedAuthority> roles = new ArrayList<>();
			
			roles.add(new SimpleGrantedAuthority("ROLE_"+user.getRol().getIdRol()));
			
			UserDetails userDetails = new org.springframework
					.security.core.userdetails.User(user.getCorreo(), user.getPass(), roles);
			
			return userDetails;
			
		}
		
	}

}
