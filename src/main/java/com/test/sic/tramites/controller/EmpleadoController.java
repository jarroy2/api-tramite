/**
 * 
 */
package com.test.sic.tramites.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sic.tramites.model.Empleado;
import com.test.sic.tramites.response.GeneralResponse;
import com.test.sic.tramites.service.EmpleadoService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping
	public ResponseEntity<GeneralResponse<List<Empleado>>> getAll(){
		
		GeneralResponse<List<Empleado>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<Empleado> data = null;
		
		try {
			
			data = empleadoService.getAll();
			response.setData(data);
			response.setSuccess(true);
			response.setMessage("");
			status = HttpStatus.OK;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setData(null);
			response.setSuccess(true);
			response.setMessage(ex.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<>(response, status);
	}
	
	@PostMapping("")
	public ResponseEntity<GeneralResponse<Empleado>> create(@RequestBody Empleado entity){
		
		GeneralResponse<Empleado> response = new GeneralResponse<>();
		HttpStatus status = null;
		Empleado data = null;
		
		try {
			
			data =empleadoService.create(entity);
			response.setData(data);
			response.setSuccess(true);
			response.setMessage("Registro creado exitosamente");
			status = HttpStatus.OK;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setData(null);
			response.setSuccess(true);
			response.setMessage(ex.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(response, status);
	}
	
	@PutMapping("")
	public ResponseEntity<GeneralResponse<Empleado>> update(@RequestBody Empleado entity){
		
		GeneralResponse<Empleado> response = new GeneralResponse<>();
		HttpStatus status = null;
		Empleado data = null;
		
		try {
			
			data =empleadoService.update(entity);
			response.setData(data);
			response.setSuccess(true);
			response.setMessage("Registro actualizado exitosamente");
			status = HttpStatus.OK;
			
		} catch (Exception ex) {
			ex.printStackTrace();
			response.setData(null);
			response.setSuccess(true);
			response.setMessage(ex.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(response, status);
	}
	
}
