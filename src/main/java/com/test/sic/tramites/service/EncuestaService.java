/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.Encuesta;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface EncuestaService {

	public List<Encuesta> getAll() throws Exception;

	public Encuesta create(Encuesta entity) throws Exception;

	public Encuesta update(Encuesta entity) throws Exception;
}
