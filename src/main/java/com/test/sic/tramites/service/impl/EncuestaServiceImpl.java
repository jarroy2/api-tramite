/**
 * 
 */
package com.test.sic.tramites.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.sic.tramites.model.Encuesta;
import com.test.sic.tramites.repository.EncuestaRepository;
import com.test.sic.tramites.service.EncuestaService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Service
public class EncuestaServiceImpl implements EncuestaService {

	@Autowired
	private EncuestaRepository encuentaRepository;

	@Override
	public List<Encuesta> getAll() throws Exception {
		return encuentaRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}

	@Override
	public Encuesta create(Encuesta entity) throws Exception {
		entity.setFechaCreacion(new Timestamp(new Date().getTime()));
		return encuentaRepository.saveAndFlush(entity);

	}

	@Override
	public Encuesta update(Encuesta entity) throws Exception {
		if (entity.getId() != null) {
			Encuesta data = encuentaRepository.getById(entity.getId());
			if (data != null) {
				data.setNombres(entity.getNombres());
				return encuentaRepository.saveAndFlush(data);
			}

			throw new Exception("No se encuentra el ID");
		} else {
			throw new Exception("No se encuentra el ID");
		}

	}

}
