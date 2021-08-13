/**
 * 
 */
package com.test.sic.tramites.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.sic.tramites.model.Persona;
import com.test.sic.tramites.repository.PersonaRepository;
import com.test.sic.tramites.service.PersonaService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> getAll() throws Exception {
		return personaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombres"));
	}

	@Override
	public Persona create(Persona entity) throws Exception {
		
		Persona data = personaRepository.findByTipoIdentificacionAndNumeroIdentificacion(
				entity.getTipoIdentificacion().getCodigo(), entity.getNumeroIdentificacion());
		
		if (data == null) {
			return personaRepository.saveAndFlush(entity);
		}
		
		throw new Exception("La persona con número de identificación ya existe");
	}

	@Override
	public Persona update(Persona entity) throws Exception {
		if (entity.getId() != null) {
			Persona data = personaRepository.getById(entity.getId());
			if (data != null) {
				data.setTipoIdentificacion(entity.getTipoIdentificacion());
				data.setNumeroIdentificacion(entity.getNumeroIdentificacion());
				data.setNombres(entity.getNombres());
				data.setNombres(entity.getNombres());
				data.setApellidos(entity.getApellidos());
				data.setDireccion(entity.getDireccion());
				data.setEmail(entity.getEmail());
				data.setTelefono(entity.getTelefono());
				return personaRepository.saveAndFlush(data);
			}

			throw new Exception("No se encuentra el ID");
		} else {
			throw new Exception("No se encuentra el ID");
		}

	}

	@Override
	public Persona getByTipoIdentintificacionAndNumeroid(String codigo, Long numeroId) throws Exception {
		return personaRepository.findByTipoIdentificacionAndNumeroIdentificacion(codigo, numeroId);
	}

}
