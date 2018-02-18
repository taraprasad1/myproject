package com.rest.exceptions;

public class SimpleException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleException(String message)
	{
		super(message);
	}
}
