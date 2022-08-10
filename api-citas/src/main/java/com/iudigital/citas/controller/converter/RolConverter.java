package com.iudigital.citas.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.citas.controller.dto.RolDTO;
import com.iudigital.citas.domain.Rol;

@Component
public class RolConverter {

	public Rol convertRolDTOToRol(RolDTO rolDTO) {

		Rol rol = new Rol();

		rol.setIdRol(rolDTO.getIdRol());
		rol.setNombre(rolDTO.getNombre());

		return rol;

	}

	public RolDTO convertRolToRolDTO(Rol rol) {

		RolDTO rolDTO = new RolDTO();

		rolDTO.setIdRol(rol.getIdRol());
		rolDTO.setNombre(rol.getNombre());

		return rolDTO;

	}

}
