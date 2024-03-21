package com.jsp.spring.pmsm.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	private ErrorStructure<Object> structure;

	public ApplicationExceptionHandler(ErrorStructure<Object> structure) {
		super();
		this.structure = structure;
	}
	
	 @Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			 List<ObjectError>errors=ex.getAllErrors();
				//List<String>messages=new ArrayList<String>();
			 Map<String,String>messages=new HashMap<>();
				errors.forEach(error->{
					//String message=error.getDefaultMessage();
//					messages.add(message);
					FieldError fieldError=(FieldError)error;
					 messages.put(fieldError.getField(),error.getDefaultMessage());
					
					
				});
				return ResponseEntity.badRequest().body(
						structure.setErrorStatuscode(HttpStatus.BAD_REQUEST.value())
						.setErrorMessage("invalid input")
						.setErrorData(messages));

}
	 
	 
	 
}