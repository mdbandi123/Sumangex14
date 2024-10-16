package org.acumen.training.codes.exceptions;

public class ElementDecimalException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message = "Invalid element value:[floating-point]";
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}

}
