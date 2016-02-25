package tr.edu.gtu.bilmuh.ksuzen;

import java.util.ArrayList;

/**
 * This user is tutor it can <ol>
 *     <li> Can see courses materials and courses</li>
 * </ol>
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class Tutor extends AbstractUser {
    /**
     * This constructor create a new tutor from given name id number is assigned automatically
     * @param name Name of the tutor
     */
    public Tutor(String name){
        setName(name);
        int tempLength = School.getInstance().getUserList().size();
        if(tempLength != 0)
            setIDNo(School.getInstance().getUserList().get(tempLength -1).getIDNo() + 1);
        else
            setIDNo(0);
    }

    /**
     * Prints all Courses that registered to system
     */
    public void listAllCourses(){
        ArrayList<Course> temp = School.getInstance().getCourseList();
        System.out.printf("Course name\t Course Teacher\t Course Tutor\n");
        for (Course aTemp : temp){
            System.out.printf("%s %s %s\n",aTemp.getCourseName(),aTemp.getCourseTeacher(),aTemp.getCourseTutor());
        }
    }
}
