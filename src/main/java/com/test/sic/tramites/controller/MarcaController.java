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

import com.test.sic.tramites.model.Marca;
import com.test.sic.tramites.response.GeneralResponse;
import com.test.sic.tramites.service.MarcaService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
	
	@GetMapping
	public ResponseEntity<GeneralResponse<List<Marca>>> getAll(){
		
		GeneralResponse<List<Marca>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<Marca> data = null;
		
		try {
			
			data = marcaService.getAll();
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
	public ResponseEntity<GeneralResponse<Marca>> create(@RequestBody Marca entity){
		
		GeneralResponse<Marca> response = new GeneralResponse<>();
		HttpStatus status = null;
		Marca data = null;
		
		try {
			
			data = marcaService.create(entity);
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
	public ResponseEntity<GeneralResponse<Marca>> update(@RequestBody Marca entity){
		
		GeneralResponse<Marca> response = new GeneralResponse<>();
		HttpStatus status = null;
		Marca data = null;
		
		try {
			
			data = marcaService.update(entity);
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
