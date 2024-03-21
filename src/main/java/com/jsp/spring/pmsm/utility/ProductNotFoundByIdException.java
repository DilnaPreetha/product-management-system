package com.jsp.spring.pmsm.utility;

public class ProductNotFoundByIdException  extends RuntimeException{
	private String message;

	public ProductNotFoundByIdException(String message) {
		
		this.message = message;
	}
@Override
	public String getMessage() {
		return message;
	}

	
}
