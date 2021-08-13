/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.Departamento;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface DepartamentoService {

	public List<Departamento> getAll() throws Exception;

	public Departamento create(Departamento entity) throws Exception;

	public Departamento update(Departamento entity) throws Exception;
}
