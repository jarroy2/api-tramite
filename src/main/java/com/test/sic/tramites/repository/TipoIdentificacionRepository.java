/**
 * 
 */
package com.test.sic.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.sic.tramites.model.TipoIdentificacion;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long> {
	
	boolean existsByCodigo(String codigo);

}
