package Validation;

public class PasswordValidation 
{

	public boolean isPasswordCorrect(String password)
	{
		boolean isCorrect = false;
		if(password.length()>8)
		{
			isCorrect = true;
		}
		return isCorrect;
	}
}
