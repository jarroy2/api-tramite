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

import com.test.sic.tramites.model.Departamento;
import com.test.sic.tramites.response.GeneralResponse;
import com.test.sic.tramites.service.DepartamentoService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	public ResponseEntity<GeneralResponse<List<Departamento>>> getAll(){
		
		GeneralResponse<List<Departamento>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<Departamento> data = null;
		
		try {
			
			data = departamentoService.getAll();
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
	public ResponseEntity<GeneralResponse<Departamento>> create(@RequestBody Departamento entity){
		
		GeneralResponse<Departamento> response = new GeneralResponse<>();
		HttpStatus status = null;
		Departamento data = null;
		
		try {
			
			data = departamentoService.create(entity);
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
	public ResponseEntity<GeneralResponse<Departamento>> update(@RequestBody Departamento entity){
		
		GeneralResponse<Departamento> response = new GeneralResponse<>();
		HttpStatus status = null;
		Departamento data = null;
		
		try {
			
			data = departamentoService.update(entity);
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
