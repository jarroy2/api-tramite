/**
 * 
 */
package com.test.sic.tramites.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sic.tramites.model.Departamento;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	boolean existsByCodigo(String codigo);

}
