import org.junit.Test;
import tr.edu.gtu.bilmuh.ksuzen.*;

import java.net.URI;

import static org.junit.Assert.*;

/**
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class CourseTest {
    Teacher testTeacher = new Teacher("testTeacher");
    Course test = new Course("testCourse",testTeacher,false);
    @Test
    public void testGetSubmittedAssignments() throws Exception {
        Student testStudent = new Student("teststudnet");
        SubmittedAssignmentFile sub = new SubmittedAssignmentFile(testStudent, URI.create("testPath"),1);
        test.addSubmittedAssignments(sub);

        assertTrue(test.getSubmittedAssignments().get((test.getSubmittedAssignments().size()) - 1).equals(sub));
    }

    @Test
    public void testAddSubmittedAssignments() throws Exception {
        int last = test.getSubmittedAssignments().size();
        Student testStudent = new Student("teststudnet");
        SubmittedAssignmentFile sub = new SubmittedAssignmentFile(testStudent, URI.create("testPath"),1);
        test.addSubmittedAssignments(sub);
        assertTrue(test.getSubmittedAssignments().size() - 1 == last);
    }

    @Test
    public void testGetGivenAssignment() throws Exception {
        Assignment tempAss = new Assignment("23","25",URI.create("testPAth"),1);
        test.addGivenAssignment(tempAss);
        int len = test.getGivenAssignment().size();

        assertTrue(test.getGivenAssignment().get(len - 1).equals(tempAss));
    }

    @Test
    public void testAddGivenAssignment() throws Exception {

        Assignment tempAss = new Assignment("23","25",URI.create("testPAth"),1);
        test.addGivenAssignment(tempAss);
        int len = test.getGivenAssignment().size();

        assertTrue(test.getGivenAssignment().get(len- 1).equals(tempAss));
    }

    @Test
    public void testGetAllGrades() throws Exception {
        int tempid=0;
        School.getInstance().addUser(new Student("testStudnet"));
        for(int i=0; i < School.getInstance().getUserList().size();++i)
            if(School.getInstance().getUserList().get(i).getName().equals("testStudnet"))
                tempid = School.getInstance().getUserList().get(i).getIDNo();

        test.setGradeByID(89,tempid);

        assertTrue(test.getGradeByID(tempid) == 89);
    }

    @Test
    public void testGetGradeByID() throws Exception {
        int tempid=0;
        School.getInstance().addUser(new Student("testStudnet"));
        for(int i=0; i < School.getInstance().getUserList().size();++i)
            if(School.getInstance().getUserList().get(i).getName().equals("testStudnet"))
                tempid = School.getInstance().getUserList().get(i).getIDNo();
        test.setGradeByID(65,tempid);
        assertTrue(test.getGradeByID(tempid) == 65);
    }

    @Test
    public void testGetRegisteredStudentIDs() throws Exception {
        test.addStudentIDs(88);

        assertTrue(test.getRegisteredStudentIDs().get(test.getRegisteredStudentIDs().lastIndexOf(88)) == 88);
    }

    @Test
    public void testAddStudentIDs() throws Exception {
        test.addStudentIDs(88);

        assertTrue(test.getRegisteredStudentIDs().get(test.getRegisteredStudentIDs().lastIndexOf(88)) == 88);
    }
}