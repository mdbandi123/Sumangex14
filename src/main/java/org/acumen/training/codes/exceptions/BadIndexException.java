package org.acumen.training.codes.exceptions;

public class BadIndexException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String message = "Bad index";
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}
}
