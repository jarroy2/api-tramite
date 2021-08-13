/**
 * 
 */
package com.test.sic.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.sic.tramites.model.Persona;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	@Query("SELECT a FROM Persona a WHERE a.tipoIdentificacion.codigo = :codigo AND a.numeroIdentificacion = :numeroIdentificacion")
	Persona findByTipoIdentificacionAndNumeroIdentificacion(String codigo, Long numeroIdentificacion);

}
