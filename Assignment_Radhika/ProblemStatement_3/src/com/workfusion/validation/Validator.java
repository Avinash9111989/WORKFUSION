package com.workfusion.validation;

public class Validator {
   public boolean validateName(String name) {
	   if(!name.equals("null"))
		   return true;
	   else
		   return false;
	   
   }
 public boolean validateJobProfile(String jobProfile) {
	 if(jobProfile.equals("Associate") || jobProfile.equals("Clerk")|| jobProfile.equals("Executive") || jobProfile.equals("Officer"))
		 return true;
	 else
		 return false;
	 
	   
   }
 public boolean validateAge(int age) {
	 if(age>=18 && age<=30)
		 return true;
	 else
		 return false;
	   
 }
 public void validate(Applicant applicant) throws InvalidNameException, InvalidJobException, InvalidAgeException {
	 if(!validateName(applicant.getName()))
		 throw new InvalidNameException("Invalid name");
	 if(!validateJobProfile(applicant.getJobProfile()))
		 throw new InvalidJobException("Invalid Job profile");
	 if(!validateAge(applicant.getAge()))
		 throw new InvalidAgeException("Invalid age");
	 System.out.println("Application submitted successfully!");
		 
		 
			 
	 
	 
 }
 
}
