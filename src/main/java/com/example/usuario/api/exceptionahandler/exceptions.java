package com.example.usuario.api.exceptionahandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class exceptions extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return handleExceptionInternal(ex, "Faltam dados a preencher", headers, HttpStatus.BAD_REQUEST, request);
		
	}
	
	@ExceptionHandler(DataIntegratedViolationException.class)
	public ResponseEntity<Object> objectNotFoundException (DataIntegratedViolationException e) {
		StandardError error = new StandardError(System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
		return handleExceptionInternal(e, "Usuário não encontrado", null, HttpStatus.BAD_REQUEST, null);
		
	}
	
	
	
}

