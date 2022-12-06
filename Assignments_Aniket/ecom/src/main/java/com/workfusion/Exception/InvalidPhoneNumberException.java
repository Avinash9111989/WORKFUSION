package com.workfusion.Exception;

public class InvalidPhoneNumberException extends Exception
{

	private static final long serialVersionUID = 1L;
	public InvalidPhoneNumberException(String msg)
	{
		super(msg);
	}
}
