/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.Persona;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface PersonaService {

	public List<Persona> getAll() throws Exception;

	public Persona create(Persona entity) throws Exception;

	public Persona update(Persona entity) throws Exception;
	
	public Persona getByTipoIdentintificacionAndNumeroid(String codigo, Long numeroId) throws Exception;
}
