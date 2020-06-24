package LMS;


public class CourseCRUD {
	static CourseRepository courseRepository = CourseRepository.getInstance();
	
	//prints all courses from the repository sorted by course ID.
	public static void printAllCourses() {
		courseRepository.printAllCourses();
	}
	
	public static void printAllCoursesByPrice(boolean descending) {
		courseRepository.printAllCoursesByPrice(descending);
	}
	
	//finds the course by courseID.  Returns true if successful.  Returns false if no such course found.
	public static boolean findCourseByID(int courseID) {
		Course course = courseRepository.searchCourse(courseID);
		if(course!=null) {
			System.out.println("Course found! \n" + course);
			return true;
		}
		else {
			System.out.println("Course not found.");
			return false;
		}
	}
	
	//finds the course by name.  Returns true if successful.  Returns false if no such course found.
	public static boolean findCourseByName(String name) {
		Course course = courseRepository.searchCourse(name);
		if(course!=null) {
			System.out.println("Course found! \n" + course);
			return true;
		}
		else {
			System.out.println("Course not found.");
			return false;
		}
	}
	
	//Saves the course passed into the method.  Returns true if successful.  Returns false otherwise.
	public static boolean saveCourse(Course course) {
		int numUpdates = courseRepository.saveCourse(course);
		if(numUpdates==1) {
			Course courseTemp = courseRepository.searchCourse(course.getName());
			System.out.println("Update Sucessful! Course saved.\n" + courseTemp);
			return true;
		}
		else {
			System.out.println("Something went wrong.  See error, try again.");
			return false;
		}
	}
	
	//Updates the course by course ID to the course object passed into the method.  
	//Returns true if successful.  Returns false otherwise.
	public static boolean updateCourse(int courseID, Course course) {
		int numUpdates = courseRepository.updateCourse(courseID, course);
		if(numUpdates==1) {
			Course courseTemp = courseRepository.searchCourse(course.getName());
			System.out.println("Update Sucessful! Course saved.\n" + courseTemp);
			return true;
		}
		else {
			System.out.println("Something went wrong.  See error, try again.");
			return false;
		}
	}
	
	//Deletes the course by course ID.  Returns true if successful.  Returns false otherwise.
	public static boolean deleteCourse(int courseID) {
		Course courseTemp = courseRepository.searchCourse(courseID);
		if(courseTemp == null) {
			System.out.println("No course by that ID in database.");
			return false;
		}
		int numUpdates = courseRepository.deleteCourse(courseID);
		if(numUpdates==1) {
			System.out.println("Update Sucessful! Course deleted.\n" + courseTemp);
			return true;
		}
		else {
			System.out.println("Something went wrong.  See error, try again.");
			return false;
		}
	}
}
