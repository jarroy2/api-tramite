/**
 * 
 */
package com.test.sic.tramites.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.sic.tramites.model.Marca;
import com.test.sic.tramites.repository.MarcaRepository;
import com.test.sic.tramites.service.MarcaService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository tipoIdeRepository;

	@Override
	public List<Marca> getAll() throws Exception {
		return tipoIdeRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}

	@Override
	public Marca create(Marca entity) throws Exception {
		if (!tipoIdeRepository.existsByNombre(entity.getNombre())) {
			return tipoIdeRepository.saveAndFlush(entity);
		} else {
			throw new Exception("Ya existe el nombre");
		}
	}

	@Override
	public Marca update(Marca entity) throws Exception {
		if (entity.getId() != null) {
			Marca data = tipoIdeRepository.getById(entity.getId());
			if(data != null) {
				data.setNombre(entity.getNombre());
				return tipoIdeRepository.saveAndFlush(data);	
			}
			
			throw new Exception("No se encuentra el ID");
		} else {
			throw new Exception("No se encuentra el ID");
		}

	}

}
