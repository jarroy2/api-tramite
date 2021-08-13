/**
 * 
 */
package com.test.sic.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.sic.tramites.model.Empleado;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Query("SELECT e FROM Empleado e WHERE e.persona.tipoIdentificacion.id = :id AND e.persona.numeroIdentificacion = :numeroIdentificacion")
	Empleado getByTipoIdentificacionAndNumeroIdentificacion(@Param("id") Long tipoIdentificacion,
			@Param("numeroIdentificacion") Long numeroIdentificacion);

}
