package com.bridgelabz.workshopthree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeWage {

	private ArrayList<Employee> employees;

	public EmployeeWage() {
		employees = new ArrayList<>();
	}

	public void addEmployee() {
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Enter the number of employees to add: ");
		int numOfEmployees = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < numOfEmployees; i++) {
			System.out.print("Enter first name: ");
			String firstName = scanner.nextLine();

			// validate first name with regex
			Pattern pattern = Pattern.compile("^[A-Z][a-zA-Z]{2,}$");
			Matcher matcher = pattern.matcher(firstName);
			if (matcher.matches()) {
				employee.setFirstName(firstName);
			} else {
				throw new IllegalArgumentException("Invalid first name format");
			}

			System.out.println("Enter the lastName");
			String lastName = scanner.nextLine();
			employee.setLastName(lastName);

			System.out.println("Enter the date of birth");
			String dob = scanner.nextLine();
			employee.setDob(dob);

			System.out.println("Enter the emailId");
			String email = scanner.nextLine();
			employee.setEmail(email);

			System.out.println("Enter the age");
			int age = scanner.nextInt();
			employee.setAge(age);
			scanner.nextLine();

			employees.add(employee);
		}
	}

	public static boolean validateFirstName(String firstName) {
		String regex="^[A-Z][a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(firstName);
		return matcher.matches();
	}
	
	public void printEmployees() {

		System.out.println("Employees with age greater than 30:");

		employees.stream().filter(employee -> employee.getAge() > 30).forEach(employee -> {
			System.out.println("First Name: " + employee.getFirstName());
			System.out.println("Last Name: " + employee.getLastName());
		});
	}

	public static void main(String[] args) {
		EmployeeWage employeeWage = new EmployeeWage();
		employeeWage.addEmployee();
		employeeWage.printEmployees();
	}
}
