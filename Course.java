package LMS;
/**
 * @author Lindsay Prescott
 */
public class Course {
    private int courseID;
    private String name;
    private float price;
    private String description;
    private int capacity;
    
    //Constructor
    public Course(int courseID, String name, float price, String description, int capacity) {
        this.courseID = courseID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.capacity = capacity;
    }
    
    /**
     * @return the courseID
     */
    public int getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public String toString() {
    	String string = "Course id: " + courseID + "\nName: " + name + "\nPrice: " + price + "\nDescription: " + description + "\nCapacity: " + capacity + "\n";
    	return string;
    }
}
