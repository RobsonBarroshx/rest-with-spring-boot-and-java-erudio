package br.com.segsat.estudo.exceptions.handler;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.segsat.estudo.exceptions.ExceptionResponse;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new  ExceptionResponse
				(new Date(), PAGE_NOT_FOUND_LOG_CATEGORY, PAGE_NOT_FOUND_LOG_CATEGORY);
		
		return null;
	}
	
}
