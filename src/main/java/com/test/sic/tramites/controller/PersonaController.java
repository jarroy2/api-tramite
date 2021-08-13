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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.sic.tramites.model.Persona;
import com.test.sic.tramites.response.GeneralResponse;
import com.test.sic.tramites.service.PersonaService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public ResponseEntity<GeneralResponse<List<Persona>>> getAll(){
		
		GeneralResponse<List<Persona>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<Persona> data = null;
		
		try {
			
			data = personaService.getAll();
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
	
	@GetMapping("/identificacion/{codigo}/numero/{numeroId}")
	public ResponseEntity<GeneralResponse<Persona>> getTipoAndNumero(
			@PathVariable(name = "codigo", required = true) String codigo, 
			@PathVariable(name = "numeroId", required = true) Long numeroId){
		
		GeneralResponse<Persona> response = new GeneralResponse<>();
		HttpStatus status = null;
		Persona data = null;
		
		try {
			
			data = personaService.getByTipoIdentintificacionAndNumeroid(codigo, numeroId);
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
	public ResponseEntity<GeneralResponse<Persona>> create(@RequestBody Persona entity){
		
		GeneralResponse<Persona> response = new GeneralResponse<>();
		HttpStatus status = null;
		Persona data = null;
		
		try {
			
			data = personaService.create(entity);
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
	public ResponseEntity<GeneralResponse<Persona>> update(@RequestBody Persona entity){
		
		GeneralResponse<Persona> response = new GeneralResponse<>();
		HttpStatus status = null;
		Persona data = null;
		
		try {
			
			data = personaService.update(entity);
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
