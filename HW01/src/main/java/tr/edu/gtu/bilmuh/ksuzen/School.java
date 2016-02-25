package tr.edu.gtu.bilmuh.ksuzen;

import java.util.ArrayList;

/**
 * This is singleton class to hold all student and course info simultaneously
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class School {
    private ArrayList<AbstractUser> userList;
    private ArrayList<Course> courseList;
    private static School data;

    /**
     * This is private constructor of this class only getInstance can invoke this
     */
    private School(){
        userList = new ArrayList<>();
        courseList = new ArrayList<>();
    }

    /**
     * This method returns same instance of this class to everyone to make singleton design
     * @return Object of this class
     */
    public static School getInstance(){
        if (data == null)
            data = new School();

        return data;
    }

    /**
     * Gets all users list
     * @return All users list as ArrayList of AbstractUser Object
     */
    public ArrayList<AbstractUser> getUserList() {
        if(userList == null)
            userList = new ArrayList<AbstractUser>();

        return userList;
    }

    /**
     * Sets userlist
     * @param userList List of users to set as ArrayList of AbstractUser object
     */
    public void setUserList(ArrayList<AbstractUser> userList) {
        this.userList = userList;
    }

    /**
     * Get all courses
     * @return All courses of system as ArrayList as Courses
     */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    /**
     * Sets course list
     * @param courseList List of courses as ArrayList of Courses object
     */
    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * Adds user to systen
     * @param newUser New user to add as AbstractUser
     * @return true on success false on error
     */
    public boolean addUser(AbstractUser newUser){
        try{
            if(userList == null)
                userList = new ArrayList<AbstractUser>();
            if(!userList.add(newUser))
                throw new Exception("User could not added");
            return  true;
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * Remove user from system
     * @param obsoloteUser user that will be removed as AbstractUser
     * @return true on success false on error
     */
    public boolean removeUser(AbstractUser obsoloteUser){
        try{
            if(!userList.remove(obsoloteUser)){
                throw new Exception("User could not find");
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * Add course to system
     * @param newCourse New course to add as Course object
     * @return true on success false on error
     */
    public boolean addCourse(Course newCourse){
        try{
            if(courseList == null)
                courseList = new ArrayList<Course>();
            if(!courseList.add(newCourse)){
                throw new Exception("Course could not added");
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * Remove course from list
     * @param obsoloteCourse Course that will be remove
     * @return true on success false on error
     */
    public boolean removeCourse(Course obsoloteCourse){
        try{
            if(!courseList.remove(obsoloteCourse))
                throw new Exception("Course could not remove");
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
