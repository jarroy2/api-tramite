/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.Marca;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface MarcaService {

	public List<Marca> getAll() throws Exception;

	public Marca create(Marca entity) throws Exception;

	public Marca update(Marca entity) throws Exception;
}
