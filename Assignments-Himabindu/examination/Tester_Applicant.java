
package com.workfusion.examination;

public class Tester_Applicant {
	public static void main(String[] args){
		Applicant applicant=new Applicant();
		Validator v=new Validator();
		
		applicant.setName("Jenny");
		applicant.setJobProfile("Clerk");
		applicant.setAge(25);
		try {
			v.validate(applicant);
			if(v.validateName(applicant.getName())&&v.validateJobProfile(applicant.getJobProfile())&&v.validateAge(applicant.getAge())) {
				System.out.println("Application submitted successfully!");
			}
		}
		catch(InvalidNameException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidJobProfileException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
			
	
		
	}

}
