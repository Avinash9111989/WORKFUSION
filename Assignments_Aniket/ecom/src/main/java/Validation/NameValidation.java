package Validation;

public class NameValidation 
{

	public boolean isNameCorrect(String name)
	{
		boolean isCorrect = false;
		if(name.length()>2 && Character.isUpperCase(name.charAt(0)))
		{
			isCorrect = true;
		}
		return isCorrect;
	}
}
