package Validation;

public class PinCodeValidation 
{

	public boolean isPincodeCorrect(long pincode)
	{
		boolean iscorrect = false;
		if(String.valueOf(pincode).length()==6)
		{
			iscorrect=true;
		}
		return iscorrect;
	}
}
