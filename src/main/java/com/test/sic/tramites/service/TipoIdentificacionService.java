/**
 * 
 */
package com.test.sic.tramites.service;

import java.util.List;

import com.test.sic.tramites.model.TipoIdentificacion;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface TipoIdentificacionService {

	public List<TipoIdentificacion> getAll() throws Exception;

	public TipoIdentificacion create(TipoIdentificacion entity) throws Exception;

	public TipoIdentificacion update(TipoIdentificacion entity) throws Exception;
}
