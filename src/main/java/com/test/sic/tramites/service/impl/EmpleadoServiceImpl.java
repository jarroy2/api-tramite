/**
 * 
 */
package com.test.sic.tramites.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.sic.tramites.model.Empleado;
import com.test.sic.tramites.model.Persona;
import com.test.sic.tramites.repository.EmpleadoRepository;
import com.test.sic.tramites.repository.PersonaRepository;
import com.test.sic.tramites.service.EmpleadoService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Empleado> getAll() throws Exception {
		return empleadoRepository.findAll(Sort.by(Sort.Direction.ASC, "persona.nombres"));
	}

	@Override
	public Empleado create(Empleado entity) throws Exception {
		
		Empleado data = empleadoRepository.getByTipoIdentificacionAndNumeroIdentificacion(
				entity.getPersona().getTipoIdentificacion().getId(), entity.getPersona().getNumeroIdentificacion());
		
		if (data == null) {
			Persona persona = personaRepository.
					findByTipoIdentificacionAndNumeroIdentificacion(entity.getPersona().getTipoIdentificacion().getCodigo(), 
							entity.getPersona().getNumeroIdentificacion());
			
			if(persona == null) {
				persona = personaRepository.saveAndFlush(entity.getPersona());
			}
			entity.setFechaIngreso(new Date());
			entity.setPersona(persona);
			return empleadoRepository.saveAndFlush(entity);
		}
		
		throw new Exception("La empleado con número de identificación ya existe");
	}

	@Override
	public Empleado update(Empleado entity) throws Exception {
		if (entity.getId() != null) {
			Empleado data = empleadoRepository.getById(entity.getId());
			if (data != null) {
				data.setDepartamento(entity.getDepartamento());
				return empleadoRepository.saveAndFlush(data);
			}

			throw new Exception("No se encuentra el ID");
		} else {
			throw new Exception("No se encuentra el ID");
		}

	}

}
