package tr.edu.gtu.bilmuh.ksuzen;

/**
 * This class implemented to hold grade info
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class Grades {
    private String studentName = "";
    private int id = -1;
    private int grade = 0;

    /**
     * This constructor create a new object using given parameter
     * @param name Name of student as String
     * @param newID if of student as int
     * @param newGrade grade of student as int
     */
    Grades(String name,int newID, int newGrade){
        studentName = name;
        id = newID;
        grade = newGrade;
    }

    /**
     * This method gets student name
     * @return Student's name as String
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets students name
     * @param studentName New name of Student as String
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets id of student
     * @return id of student as int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of student
     * @param id New id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets grade of student
     * @return Grade of student as int
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets grade of student
     * @param grade New grade of student as int
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }
}
