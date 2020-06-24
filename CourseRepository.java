package LMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseRepository {
	
	private static class CourseRepositorySingletonInstance {
		static final CourseRepository courseRepositoryInstance = new CourseRepository();
	}
	
	private CourseRepository() {
		
	}
	
	public static CourseRepository getInstance() {
		return CourseRepositorySingletonInstance.courseRepositoryInstance;
	}
	
	//A function to search the database for a course based on its unique courseID
	public Course searchCourse(int courseID) {
		Course course = null;
		try {
			//Make Connection to db
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
				
			//Create the statement
				Statement statement = connection.createStatement();
				//Fetch the results by executing the query
				ResultSet resultSet = statement.executeQuery("select * from courses where course_id = " + courseID + ";");
				//Iterate the resultSet
				if(resultSet.next() && resultSet.isLast()) {
					course = new Course(resultSet.getInt("course_id"),
								resultSet.getString("course_name"),
								resultSet.getInt("price"),
								resultSet.getString("course_description"),
								resultSet.getInt("capacity"));
				}
				
				//Close all streams
				resultSet.close();
				statement.close();
				connection.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return course;
	}
	
	public Course searchCourse(String name) {
		Course course = null;
		try {
			//Make Connection to db
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
				
			//Create the statement
				Statement statement = connection.createStatement();
				//Fetch the results by executing the query
				ResultSet resultSet = statement.executeQuery("select * from courses where course_name = '" + name + "';");
				//Iterate the resultSet
				if(resultSet.next() && resultSet.isLast()) {
					course = new Course(resultSet.getInt("course_id"),
								resultSet.getString("course_name"),
								resultSet.getInt("price"),
								resultSet.getString("course_description"),
								resultSet.getInt("capacity"));
				}
				
				//Close all streams
				resultSet.close();
				statement.close();
				connection.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return course;
	}
	
	public int saveCourse(Course course) {
		int numUpdates = 0;
		
		try {
			//Make Connection to db
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
				
			//Create the statement
				Statement statement = connection.createStatement();
				//Fetch the results by executing the query
				numUpdates = statement.executeUpdate("insert into courses(course_name, price, course_description, capacity) " + 
						"values ('" + course.getName() +"', " + course.getPrice() + ", '" + course.getDescription() + "', " + course.getCapacity() + ");");
				
				
				statement.close();
				connection.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return numUpdates;
	}
	
	public int updateCourse(int courseID, Course course) {
		int numUpdates = 0;
		
		try {
			//Make Connection to db
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
				
			//Create the statement
				Statement statement = connection.createStatement();
				//Fetch the results by executing the query
				numUpdates = statement.executeUpdate("update courses set course_name = '" + course.getName() +"', price = " + course.getPrice() + ", course_description = '" + course.getDescription() + "', capacity = " + course.getCapacity() + " where course_id = " + courseID + ";");
				
				
				statement.close();
				connection.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return numUpdates;
	}
	
	public int deleteCourse(int courseID) {
		int numUpdates = 0;
		
		try {
			//Make Connection to db
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
				
			//Create the statement
				Statement statement = connection.createStatement();
				//Fetch the results by executing the query
				numUpdates = statement.executeUpdate("delete from courses where course_id = " + courseID + ";");
				
				
				statement.close();
				connection.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return numUpdates;
	}
	
	public void printAllCourses() {
		try {
		//Make Connection to db
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
			
		//Create the statement
			Statement statement = connection.createStatement();
			//Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from courses;");
			//Iterate the resultSet
			while(resultSet.next()) {
				System.out.println(new Course(resultSet.getInt("course_id"),
							resultSet.getString("course_name"),
							resultSet.getInt("price"),
							resultSet.getString("course_description"),
							resultSet.getInt("capacity")));
			}
			
			//Close all streams
			resultSet.close();
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printAllCoursesByPrice(boolean descending) {
		try {
		//Make Connection to db
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","root");
			
		//Create the statement
			Statement statement = connection.createStatement();
			//Fetch the results by executing the query
			ResultSet resultSet = null;
			if(descending) {
				resultSet = statement.executeQuery("select * from courses order by price desc;");
			}
			else {
				resultSet = statement.executeQuery("select * from courses order by price asc;");
			}
			//Iterate the resultSet
			while(resultSet.next()) {
				System.out.println(new Course(resultSet.getInt("course_id"),
							resultSet.getString("course_name"),
							resultSet.getInt("price"),
							resultSet.getString("course_description"),
							resultSet.getInt("capacity")));
			}
			
			//Close all streams
			resultSet.close();
			statement.close();
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
