/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.Empleado;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface EmpleadoService {

	public List<Empleado> getAll() throws Exception;

	public Empleado create(Empleado entity) throws Exception;

	public Empleado update(Empleado entity) throws Exception;
}
