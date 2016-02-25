package tr.edu.gtu.bilmuh.ksuzen;

import java.util.ArrayList;

/**
 * Admin this user can <ol>
 *     <li> Assign Teachers on course</li>
 *     <li> Add users</li>
 *     <li> Remove user</li>
 *     <li> Add / remove courses</li>
 * </ol>
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class Admin extends PrivilegedUser {

    public Admin(String newName){
        int tempLength = School.getInstance().getUserList().size();
        if(tempLength != 0)
            setIDNo(School.getInstance().getUserList().get(tempLength - 1).getIDNo() + 1);
        else
            setIDNo(0);
        setName(newName);
    }

    public boolean assignTeacher(String courseName,Teacher newTeacher){
        try{
            ArrayList<Course> temp = School.getInstance().getCourseList();
            temp.stream().filter(aCourse -> aCourse.getCourseName().equals(courseName)).forEach(aCourse -> aCourse.setCourseTeacher(newTeacher));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean addCourse(Course newCourse){
        try{
            School.getInstance().addCourse(newCourse);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean removeCourse(Course obsoloteCourse){
        try{
            School.getInstance().removeCourse(obsoloteCourse);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
