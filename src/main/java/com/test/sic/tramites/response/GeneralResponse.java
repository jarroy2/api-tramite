/**
 * 
 */
package com.test.sic.tramites.response;

import java.io.Serializable;

/**
 * @author Jonathan Arroyo Reina
 * @emai ing.jonathan.arroyo@gmail.com ing.jonathan_arroyo@hotmail.com
 * @celular 3215173946
 *
 */
public class GeneralResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9175755327603400381L;

	private T data;
	private boolean success;
	private String message;

	public GeneralResponse() {
		super();
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
