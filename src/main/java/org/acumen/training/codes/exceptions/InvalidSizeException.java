package org.acumen.training.codes.exceptions;

public class InvalidSizeException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message = "Invalid size";
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}

}
