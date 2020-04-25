package com.portafolio.util.rest.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
	
	public static ResponseEntity<Object> reponseUtil(Object response, HttpStatus httpStatus) {
		return ResponseEntity.status(httpStatus).body(response);
	}

}
