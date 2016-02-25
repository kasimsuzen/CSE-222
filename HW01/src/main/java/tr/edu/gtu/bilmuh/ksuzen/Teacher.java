package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;
import java.util.ArrayList;

/**
 * Teacher this user can <ol>
 *     <li> Give assignments</li>
 *     <li> Give documents</li>
 *     <li> Add users</li>
 *     <li> Remove user</li>
 *     <li> Can see older courses</li>
 * </ol>
 * @author Kasım Süzen
 * Created by siyah on 21.02.2016.
 */
public class Teacher extends PrivilegedUser {
    /**
     * This constructor create a new Teacher using given name id is created automatically
     * @param name Name of teacher as String
     */
    public Teacher(String name){
        setName(name);

        int tempLength = School.getInstance().getUserList().size();
        if(tempLength != 0)
            setIDNo(School.getInstance().getUserList().get(tempLength -1 ).getIDNo() + 1);
        else
            setIDNo(0);
    }

    /**
     * This method add documents to course
     * @param courseName Name of the course to add cocuments
     * @param filePath Path of digital copy of the file
     */
    public void addDocumentToClass(String courseName,String filePath){
        ArrayList<Course> temp= School.getInstance().getCourseList();
        temp.stream().filter(aCourse -> aCourse.getCourseName().equals(courseName)).forEach(aCourse -> aCourse.addFile(filePath, this));
    }

    /**
     * This method adds assignment to course which name is given
     * @param courseName Name of the course add assignment
     * @param dueDate Deadline of assignment this assignment as String
     * @param lateDate Late date of this assignment as String
     * @param filePath Path to digital copy of this assignment
     * @param assignmentID Id of assignment as int
     */
    public void addAssignment(String courseName,String dueDate,String lateDate,String filePath,int assignmentID){
        ArrayList<Course> temp= School.getInstance().getCourseList();
        for (Course aCourse: temp) {
            if(aCourse.getCourseName().equals(courseName)){
                aCourse.addGivenAssignment(new Assignment(dueDate,lateDate, URI.create(filePath),assignmentID));
            }

        }
    }
}
