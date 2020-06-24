package LMS;

import java.util.Scanner;

public class lmsTest {

	public static void main(String[] args) {
		int menuChoice = 0;
		boolean on = true;
		System.out.println("Welcome to Prescott LMS.");
		while(on) {
			//main menu
			mainMenu();
			Scanner scanIn = new Scanner(System.in);
			menuChoice = getMenuChoice(scanIn);
			switch(menuChoice) {
				case 0: {
					//Quit
					on = false;
					scanIn.close();
					System.out.println("Bye!  Thank you for using Prescott LMS.");
					break;
				}
				case 1: {
					//create a course
					createCourse(scanIn);
					break;
				}
				case 2: {
					//search for a course menu
					searchMenu();
					menuChoice = getMenuChoice(scanIn);
					switch(menuChoice) {
						case 0: {
							//Quit
							on = false;
							scanIn.close();
							System.out.println("Bye!  Thank you for using Prescott LMS.");
							break;
						}
						case 1: {
							//search by courseid
							System.out.println("This is a demo of searching for Course by its ID number, in this case 100.");
							CourseCRUD.findCourseByID(100);
							break;
						}
						case 2: {
							//search by course name
							System.out.println("This is a demo of searching for Course by its Name, in this case Calculus I");
							CourseCRUD.findCourseByName("Calculus I");
							break;
						}
						case 3: {
							//search by price
							printByPrice(scanIn);
							break;
						}
						case 4: {
							//view all courses
							CourseCRUD.printAllCourses();
							break;
						}
					}
					break;
				}
				case 3: {
					//update a course
					updateCourse(scanIn);
					break;
				}
				case 4: {
					//delete a course
					deleteCourse(scanIn);
					break;
				}
			}
		}

	}
	
	//Prints the Main Menu options.
	public static void mainMenu() {
		System.out.println("Please select from the menu options:");
		System.out.println("1: Create a Course");
		System.out.println("2: Search Courses");
		System.out.println("3: Update a Course");
		System.out.println("4: Delete Course");
		System.out.println("0: Quit");
	}
	
	//Prints the Search Menu options.
	public static void searchMenu() {
		System.out.println("Search for a Course.  Please select from the menu options:");
		System.out.println("1: Search by courseID");
		System.out.println("2: Search by course Name");
		System.out.println("3: View all courses sorted by price");
		System.out.println("4: View all courses sorted by course ID");
		System.out.println("0: Quit");
	}
	
	//Gets the menu selections from user.
	public static int getMenuChoice(Scanner scanIn) {
		int choice = 0;
		while(true) {
			try {
				choice = scanIn.nextInt();
				scanIn.nextLine();
				if(choice>=0 && choice <= 4) {
					break;
				}
			} catch(Exception e) {
				e.printStackTrace();
				break;
			}
		}
		return choice;
	}
	
	public static void printByPrice(Scanner scanIn) {
		System.out.print("Would you like to sort in descending order? (Y/N): ");
		String yesOrNo = scanIn.nextLine();
		if(yesOrNo.equalsIgnoreCase("y")) {
			CourseCRUD.printAllCoursesByPrice(true);
		}
		else if(yesOrNo.equalsIgnoreCase("n")) {
			CourseCRUD.printAllCoursesByPrice(false);
		}
		else {
			System.out.println("You didn't answer the question.");
		}
	}
	
	//Gets the user input to create and save a course in the system.
	public static void createCourse(Scanner scanIn) {
		System.out.print("Enter in the course name: ");
		String name = scanIn.nextLine();
		while (name.contains("'")) {
			System.out.println("Do not use apostrophes please.");
			System.out.print("Enter in the name of the course: ");
			name = scanIn.nextLine();
		}
		System.out.print("Enter in the price of the course: ");
		float price = 0;
		while(!scanIn.hasNextFloat()) {
			System.out.println("Please enter in a number.");
			System.out.print("Enter in the price of the course: ");
			scanIn.nextLine();
		}
		price = scanIn.nextFloat();
		scanIn.nextLine();
		System.out.print("Enter in the description of the course: ");
		String description = scanIn.nextLine();
		while (description.contains("'")) {
			System.out.println("Do not use apostrophes please.");
			System.out.print("Enter in the description of the course: ");
			description = scanIn.nextLine();
		}
		System.out.print("Enter in the capacity of the course: ");
		int capacity = 0;
		while(!scanIn.hasNextInt()) {
			System.out.println("Please enter in a whole number.");
			System.out.print("Enter in the capacity of the course: ");
			scanIn.nextLine();
		}
		capacity = scanIn.nextInt();
		scanIn.nextLine();
		CourseCRUD.saveCourse(new Course(100, name, price, description, capacity));
	}
	
	//Gets user input to update a course by courseID in the system.
	public static void updateCourse(Scanner scanIn) {
		System.out.println("What is the Course ID of the course you would like to change?");
		while(!scanIn.hasNextInt()) {
			System.out.println("Please enter a whole number courseID.");
			System.out.println("What is the Course ID of the course you would like to change?");
			scanIn.nextLine();
		}
		int courseID = scanIn.nextInt();
		scanIn.nextLine();
		System.out.print("Enter in the new course name: ");
		String name = scanIn.nextLine();
		while (name.contains("'")) {
			System.out.println("Do not use apostrophes please.");
			System.out.print("Enter in the new name of the course: ");
			name = scanIn.nextLine();
		}
		System.out.print("Enter in the new price of the course: ");
		float price = 0;
		while(!scanIn.hasNextFloat()) {
			System.out.println("Please enter in a number.");
			System.out.print("Enter in the new price of the course: ");
			scanIn.nextLine();
		}
		price = scanIn.nextFloat();
		scanIn.nextLine();
		System.out.print("Enter in the new description of the course: ");
		String description = scanIn.nextLine();
		while (description.contains("'")) {
			System.out.println("Do not use apostrophes please.");
			System.out.print("Enter in the new description of the course: ");
			description = scanIn.nextLine();
		}
		System.out.print("Enter in the new capacity of the course: ");
		int capacity = 0;
		while(!scanIn.hasNextInt()) {
			System.out.println("Please enter in a whole number.");
			System.out.print("Enter in the new capacity of the course: ");
			scanIn.nextLine();
		}
		capacity = scanIn.nextInt();
		scanIn.nextLine();
		CourseCRUD.updateCourse(courseID, new Course(courseID, name, price, description, capacity));
	}
	
	//gets user input to delete course by courseID in the system.
	public static void deleteCourse(Scanner scanIn) {
		System.out.println("What is the Course ID of the course you would like to delete?");
		while(!scanIn.hasNextInt()) {
			System.out.println("Please enter a whole number courseID.");
			System.out.println("What is the Course ID of the course you would like to delete?");
			scanIn.nextLine();
		}
		int courseID = scanIn.nextInt();
		scanIn.nextLine();
		CourseCRUD.deleteCourse(courseID);
	}
	
	
}
