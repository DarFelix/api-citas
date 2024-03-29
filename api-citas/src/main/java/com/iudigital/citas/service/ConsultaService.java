package com.iudigital.citas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.citas.data.ConsultaRepository;
import com.iudigital.citas.domain.Consulta;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	public void createConsulta(Consulta consulta) {
		consultaRepository.save(consulta);

	}

	public List<Consulta> getConsultas() {
		List<Consulta> consultas = (List<Consulta>) consultaRepository.findAll();
		return consultas;
	}

	public void editConsulta(int idConsulta, Consulta consulta) throws Exception {

		Consulta consultaUpdate = consultaRepository.findById(idConsulta).orElse(null);

		if (consultaUpdate != null) {

			consultaUpdate.setTipoCita(consulta.getTipoCita());
			consultaUpdate.setEspecialidad(consulta.getEspecialidad());
			consultaUpdate.setCosto(consulta.getCosto());

			consultaRepository.save(consultaUpdate);
		} else {
			throw new Exception("No existe la consulta");
		}

	}

	public Consulta getConsultaById(int idConsulta) throws Exception {

		Consulta consulta = consultaRepository.findById(idConsulta).orElse(null);
		if (consulta != null) {
			return consulta;
		} else {
			throw new Exception("No existe consulta");
		}

	}
}
