package org.acumen.training.codes.exceptions;

public class LetterSizeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String message = "Array size cannot be negative";
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}

}
