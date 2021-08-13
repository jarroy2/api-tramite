/**
 * 
 */
package com.test.sic.tramites.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.sic.tramites.model.Tramite;
import com.test.sic.tramites.repository.TramiteRepository;
import com.test.sic.tramites.service.TramiteService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Service
public class TramiteServiceImpl implements TramiteService {

	@Autowired
	private TramiteRepository tramiteRepository;

	@Override
	public List<Tramite> getAll() throws Exception {
		return tramiteRepository.findAll(Sort.by(Sort.Direction.ASC, "numero"));
	}

	@Override
	public Tramite create(Tramite entity) throws Exception {
		entity.setNumero((long) ((int)(Math.random()*1000000+1)));
		Calendar now = Calendar.getInstance();
		entity.setAno(now.get(Calendar.YEAR));
		return tramiteRepository.saveAndFlush(entity);

	}

	@Override
	public Tramite update(Tramite entity) throws Exception {
		if (entity.getId() != null) {
			Tramite data = tramiteRepository.getById(entity.getId());
			if (data != null) {
				data.setEmpleado(entity.getEmpleado());
				data.setPersona(entity.getPersona());
				data.setDescripcion(entity.getDescripcion());
				data.setNombre(entity.getNombre());
				return tramiteRepository.saveAndFlush(data);
			}

			throw new Exception("No se encuentra el ID");
		} else {
			throw new Exception("No se encuentra el ID");
		}

	}

}
