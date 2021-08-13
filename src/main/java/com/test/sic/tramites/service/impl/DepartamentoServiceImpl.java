/**
 * 
 */
package com.test.sic.tramites.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.sic.tramites.model.Departamento;
import com.test.sic.tramites.repository.DepartamentoRepository;
import com.test.sic.tramites.service.DepartamentoService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository tipoIdeRepository;

	@Override
	public List<Departamento> getAll() throws Exception {
		return tipoIdeRepository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}

	@Override
	public Departamento create(Departamento entity) throws Exception {
		if (!tipoIdeRepository.existsByCodigo(entity.getCodigo())) {
			return tipoIdeRepository.saveAndFlush(entity);
		} else {
			throw new Exception("Ya existe el código");
		}
	}

	@Override
	public Departamento update(Departamento entity) throws Exception {
		if (entity.getId() != null) {
			Departamento data = tipoIdeRepository.getById(entity.getId());
			if(data != null) {
				data.setCodigo(entity.getCodigo());
				data.setNombre(entity.getNombre());
				return tipoIdeRepository.saveAndFlush(data);	
			}
			
			throw new Exception("No se encuentra el ID");
		} else {
			throw new Exception("No se encuentra el ID");
		}

	}

}
