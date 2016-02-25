package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;
import java.util.ArrayList;

/** This is Student this user only can enroll courses and see its grades
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016
 */
public class Student extends AbstractUser {
    /**
     * This constructor creates new student using given name id is given automatically
     * @param name Name of the Student as String
     */
    public Student(String name){
        setName(name);

        int tempLength = School.getInstance().getUserList().size();
        if(tempLength != 0)
            setIDNo(School.getInstance().getUserList().get(tempLength - 1).getIDNo() + 1);
        else
            setIDNo(0);
    }

    /**
     * Gets all grade of his/her and prints them
     */
    public void getAllGrades(){
        ArrayList<Course> temp = School.getInstance().getCourseList();

        for (Course aTemp : temp){
            aTemp.getRegisteredStudentIDs().stream().filter(aStudent -> aStudent == getIDNo()).forEach(aStudent -> System.out.printf("%s %d", aTemp, aTemp.getGradeByID(getIDNo())));
        }
    }

    /**
     * This method registers this student to course that name is given by parameter
     * @param courseName Name of the course to enroll as String
     */
    public void registerToCourse(String courseName){
        ArrayList<Course> temp = School.getInstance().getCourseList();

        temp.stream().filter(aTemp -> aTemp.getCourseName().equals(courseName)).forEach(aTemp -> aTemp.addStudentIDs(getIDNo()));
    }

    /**
     * This method submits assignment
     * @param courseName Name of the course of the assignment as String
     * @param filePath Path of digital copy of the assignment submit
     * @param assignmentID id Of the assignment
     */
    public void submitAssignment(String courseName,String filePath,int assignmentID){
        ArrayList<Course> temp = School.getInstance().getCourseList();

        temp.stream().filter(aCourse -> aCourse.getCourseName().equals(courseName)).forEach(aCourse -> aCourse.addSubmittedAssignments(new SubmittedAssignmentFile(this, URI.create(filePath), assignmentID)));
    }
}
