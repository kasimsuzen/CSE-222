import tr.edu.gtu.bilmuh.ksuzen.Student;
import tr.edu.gtu.bilmuh.ksuzen.SubmittedAssignmentFile;

import java.net.URI;

import static org.junit.Assert.*;

/**
 * Created by siyah on 24.02.2016.
 */
public class StudentTest {

    Student test = new Student("TestStudent");


    @org.junit.Test
    public void testSubmitAssignment() throws Exception {
        SubmittedAssignmentFile tempAssignment = new SubmittedAssignmentFile(test, URI.create("tempPath"),test.getIDNo());
        assertNotNull(tempAssignment);
    }

    @org.junit.Test
    public void testGetIDNo() throws Exception {
        int tempID = -999;
        test.setIDNo(tempID);

        assertTrue(test.getIDNo() == tempID);
    }

    @org.junit.Test
    public void testSetIDNo() throws Exception {
        int tempID = -999;

        test.setIDNo(tempID);
        assertTrue(test.getIDNo() == tempID);
    }

    @org.junit.Test
    public void testGetName() throws Exception {
        String tempChangedName = "tempName";

        test.setName(tempChangedName);
        assertTrue(test.getName().equals(tempChangedName));
    }

    @org.junit.Test
    public void testSetName() throws Exception {
        String tempChangedName = "tempName";
        test.setName(tempChangedName);
        assertTrue(test.getName().equals(tempChangedName));
    }
}