package com.workfusion.validation;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter name, job profile, age");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		String jobProfile=sc.next();
		int age=sc.nextInt();
		Applicant applicant=new Applicant();
				
		applicant.setName(name);
		applicant.setJobProfile(jobProfile);
		applicant.setAge(age);
		Validator validator=new Validator();
		try {
			validator.validate(applicant);
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		catch (InvalidJobException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
