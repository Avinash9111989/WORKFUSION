package com.workfusion.examination;

public class Validator{
	public boolean validateName(String name)
	{
		if((name==null)||(name==" ")){
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean validateJobProfile(String jobProfile)
	{
		if((jobProfile=="Associate")||(jobProfile=="Clerk")||(jobProfile=="Executive")||((jobProfile=="Officer"))) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean validateAge(int age)
	{
		if((age>=18)&&(age<=30)) {
			return true;
		}
		else {
			return false;
		}
	}
	public void validate(Applicant applicant) throws InvalidNameException, InvalidJobProfileException, InvalidAgeException 
	{
		Validator v=new Validator();
		if(!v.validateName(applicant.getName())) {
			throw new InvalidNameException("Invalid Name");
		}
		if(!v.validateJobProfile(applicant.getJobProfile())) {
			throw new InvalidJobProfileException("Invalid JobProfile");
		}
		if(!v.validateAge(applicant.getAge())) {
			throw new InvalidAgeException("Invalid Age");
		}
		
	}
}
