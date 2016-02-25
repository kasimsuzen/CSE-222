package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * This class implemented for courses data holding
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class Course {
    private String courseName;
    private Teacher courseTeacher;
    private Tutor courseTutor;
    private ArrayList<URI> file;
    private ArrayList<Grades> grades;
    private ArrayList<Integer> registeredStudentIDs;
    private ArrayList<Assignment> givenAssignment;
    private ArrayList<SubmittedAssignmentFile> submittedAssignments;
    private boolean isEnded;

    /**
     * This constructor creates a new courses object using given parameters
     * @param name Name of Course as String
     * @param assignedTeacher Assigned teacher as Teacher object
     * @param dateValue Is this class ended as boolean
     */
    public Course(String name, Teacher assignedTeacher, boolean dateValue){
        courseName = name;
        courseTeacher = assignedTeacher;
        isEnded = dateValue;
    }

    /**
     * This constructor creates a new course also added a tutor too
     * @param name Name of course as String
     * @param assignedTeacher Assigned Teacher as Teacher
     * @param assignedTutor Assigned Tutor as Tutor object
     * @param dateValue Is this class ended as boolean
     */
    Course(String name,Teacher assignedTeacher,Tutor assignedTutor,boolean dateValue) {
        this(name,assignedTeacher,dateValue);
        courseTutor = assignedTutor;
    }

    /**
     * Gets submitted assignments list
     * @return SubmittedAssignments as Arraylist of SumittedAssignment objects
     */
    public ArrayList<SubmittedAssignmentFile> getSubmittedAssignments() {
        if(submittedAssignments == null)
            submittedAssignments = new ArrayList<>();
        return submittedAssignments;
    }

    /**
     * Adds SubmittedAssignment
     * @param submittedAssignments New assignment to add
     */
    public void addSubmittedAssignments(SubmittedAssignmentFile submittedAssignments) {
        if(this.submittedAssignments == null)
            this.submittedAssignments = new ArrayList<>();
        this.submittedAssignments.add(submittedAssignments);
    }

    /**
     * Gets all given assignment
     * @return all assignments as ArrayList of Assignment
     */
    public ArrayList<Assignment> getGivenAssignment() {
        return givenAssignment;
    }

    /**
     * Adds new Assignment
     * @param givenAssignment Assignment to give as Asssignment object
     */
    public void addGivenAssignment(Assignment givenAssignment) {
        if(this.givenAssignment == null)
            this.givenAssignment = new ArrayList<>();
        this.givenAssignment.add(givenAssignment);
    }

    /**
     * Gets all grades
     * @return All grades as ArrayList of Grades
     */
    public ArrayList<Grades> getAllGrades(){
        if (grades == null){
            grades = new ArrayList<>();
        }
        return grades;
    }

    /**
     * Gets grade of a student using id
     * @param id Id number of student which whom grade will returns
     * @return Grade of student as int
     */
    public int getGradeByID(int id){
        if(grades == null)
            return -1;

        for (Grades grade : grades) {
            if (grade.getId() == id)
                return grade.getGrade();
        }
        return -1;
    }

    /**
     * Sets grade of a student using id
     * @param grade Grade to give as int
     * @param id id of Student as int
     */
    public void setGradeByID(int grade ,int id){
        if(grades == null)
            grades = new ArrayList<Grades>();
        Student temp = new Student("blank");
        for(int i = 0; i < School.getInstance().getUserList().size(); ++i){
            if(id == School.getInstance().getUserList().get(i).getIDNo()){
                temp = (Student) School.getInstance().getUserList().get(i);
                grades.add(new Grades(temp.getName(),temp.getIDNo(),grade));
            }
        }
    }

    /**
     * Gets courses name
     * @return Name of course as String
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets courses name
     * @param courseName Name of course as String
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets current Teacher
     * @return Current teacher as Teacher object
     */
    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    /**
     * Sets courses Teacher
     * @param courseTeacher New teacher as Teacher object
     */
    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    /**
     * Set ArrayList of file
     * @param file ArrayList Of URI of files
     * @param accessedUser Accessed user as Abstract user to prevent access violation
     */
    public void setFile(ArrayList<URI> file, AbstractUser accessedUser) {
        try {
            if (accessedUser.getIDNo() == courseTeacher.getIDNo())
                this.file = file;

            String temp = courseTeacher.getName();
            temp += "user is not teacher of this class";
            throw new Exception(temp);
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

    /**
     * Gets all files URI
     * @return ArrayList of URI of all files
     */
    public ArrayList<URI> getFile() {
        return file;
    }

    /**
     * Adds new document to course which only can be used by courses teacher
     * @param newFile Path of file as String
     * @param accessedUser Accessed user as AbstractUser
     * @return true on success false on error
     */
    public boolean addFile(String newFile,AbstractUser accessedUser){

        try {
            if(accessedUser.getIDNo() != courseTeacher.getIDNo()) {
                String temp = courseTeacher.getName();
                temp += "user is not teacher of this class";
                throw new Exception(temp);
            }
            if(file == null) {

                file = new ArrayList<URI>();
                file.add(new URI(newFile));
            }
            else{
                file.add(new URI(newFile));
            }
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }
        catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        return true;
    }

    /**
     * Gets courses tutor
     * @return Tutor of this course as Tutor object
     */
    public Tutor getCourseTutor() {
        return courseTutor;
    }

    /**
     * Set Courses tutor
     * @param courseTutor New Tutor to add as Tutor object
     */
    public void setCourseTutor(Tutor courseTutor) {
        this.courseTutor = courseTutor;
    }

    /**
     * Returns info String about this class
     * @return String which includes course name Teachers name and tutors name
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseTeacher=" + courseTeacher +
                ", courseTutor=" + courseTutor +
                ", isEnded=" + isEnded +
                '}';
    }

    /**
     * Gets all registered students ids of this class
     * @return Arraylist of Integer which is student ids
     */
    public ArrayList<Integer> getRegisteredStudentIDs() {
        if (registeredStudentIDs == null)
            registeredStudentIDs = new ArrayList<>();
        return registeredStudentIDs;
    }

    /**
     * Add Student by their id
     * @param id Id of student to add as int
     */
    public void addStudentIDs(int id) {
        if(registeredStudentIDs == null)
            registeredStudentIDs = new ArrayList<>();

        registeredStudentIDs.add(id);
    }
}
