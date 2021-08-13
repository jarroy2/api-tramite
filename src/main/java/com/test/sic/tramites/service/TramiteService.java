/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.Tramite;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface TramiteService {

	public List<Tramite> getAll() throws Exception;

	public Tramite create(Tramite entity) throws Exception;

	public Tramite update(Tramite entity) throws Exception;
}
