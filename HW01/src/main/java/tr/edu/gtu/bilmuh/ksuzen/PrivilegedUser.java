package tr.edu.gtu.bilmuh.ksuzen;

import java.util.ArrayList;

/**
 * Admin and Teacher class and other privileged user of this system must extend from this Abstract Class
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class PrivilegedUser extends AbstractUser {
    /**
     * Prints list of all users registered
     */
    public void listAllUsers(){
        ArrayList<AbstractUser> temp = School.getInstance().getUserList();

        for (AbstractUser aTemp : temp) {
            System.out.printf("%s\n", aTemp);
        }
    }

    /**
     * Adds users to the system
     * @param newUser New user to add as AbstractUser object
     * @return true if add false on error
     */
    public boolean addUser(AbstractUser newUser){
        try{
            return School.getInstance().addUser(newUser);
        }
        catch (Exception e){
            return false;
        }

    }

    /**
     * Removes user from system
     * @param obsoleteUser User to remove from system
     * @return true on success false on error
     */
    public boolean removeUser(AbstractUser obsoleteUser){
        try {
            return School.getInstance().removeUser(obsoleteUser);
        }
        catch (Exception e){
            return false;
        }
    }

    /**
     * Prints all courses registered to the system
     */
    public void listAllCourses(){
        ArrayList<Course> temp = School.getInstance().getCourseList();
        System.out.printf("Course name\t Course Teacher\t Course Tutor\n");
        for (Course aTemp : temp){
            System.out.printf("%s %s %s\n",aTemp.getCourseName(),aTemp.getCourseTeacher(),aTemp.getCourseTutor());
        }
    }
}
