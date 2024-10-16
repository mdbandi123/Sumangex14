package org.acumen.training.codes.exceptions;

public class ElementCharException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ElementCharException(String word) {
		setMessage(word);
	}
	
	private String message = "";
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}
	
	private void setMessage(String word) {
		if (word.length() <= 1) {
			this.message = "Invalid element value: [character]";
		} else if (word.length() > 1) {
			this.message = "Invalid element value: [String]";
		}
	}
}
