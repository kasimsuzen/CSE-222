package tr.edu.gtu.bilmuh.ksuzen;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class School {
    private ArrayList<AbstractUser> userList;
    private ArrayList<Course> courseList;

    public ArrayList<AbstractUser> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<AbstractUser> userList) {
        this.userList = userList;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public boolean addUser(AbstractUser newUser){
        try{
            if(userList == null)
                userList = new ArrayList<>();
            if(!userList.add(newUser))
                throw new Exception("User could not added");
            return  true;
        }
        catch (Exception e){
            return false;
        }
    }

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

    public boolean addCourse(Course newCourse){
        try{
            if(courseList == null)
                courseList = new ArrayList<>();
            if(!courseList.add(newCourse)){
                throw new Exception("Course could not added");
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

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
