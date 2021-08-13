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

import com.test.sic.tramites.model.TipoIdentificacion;
import com.test.sic.tramites.response.GeneralResponse;
import com.test.sic.tramites.service.TipoIdentificacionService;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipo-identificacion")
public class TipoIdentificacionController {

	@Autowired
	private TipoIdentificacionService tipoIdeService;
	
	@GetMapping
	public ResponseEntity<GeneralResponse<List<TipoIdentificacion>>> getAll(){
		
		GeneralResponse<List<TipoIdentificacion>> response = new GeneralResponse<>();
		HttpStatus status = null;
		List<TipoIdentificacion> data = null;
		
		try {
			
			data = tipoIdeService.getAll();
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
	public ResponseEntity<GeneralResponse<TipoIdentificacion>> create(@RequestBody TipoIdentificacion entity){
		
		GeneralResponse<TipoIdentificacion> response = new GeneralResponse<>();
		HttpStatus status = null;
		TipoIdentificacion data = null;
		
		try {
			
			data = tipoIdeService.create(entity);
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
	public ResponseEntity<GeneralResponse<TipoIdentificacion>> update(@RequestBody TipoIdentificacion entity){
		
		GeneralResponse<TipoIdentificacion> response = new GeneralResponse<>();
		HttpStatus status = null;
		TipoIdentificacion data = null;
		
		try {
			
			data = tipoIdeService.update(entity);
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
