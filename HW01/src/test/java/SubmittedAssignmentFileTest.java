import org.junit.Test;
import tr.edu.gtu.bilmuh.ksuzen.Student;
import tr.edu.gtu.bilmuh.ksuzen.SubmittedAssignmentFile;

import java.net.URI;

import static org.junit.Assert.*;

/**
 * Created by siyah on 24.02.2016.
 */
public class SubmittedAssignmentFileTest {

    Student temp = new Student("testStudent");
    SubmittedAssignmentFile test = new SubmittedAssignmentFile(temp, URI.create("testPath"),1);

    @Test
    public void testGetAssignmentID() throws Exception {
        int tempAssignmentID = -55;

        test.setAssignmentID(tempAssignmentID);
        assertTrue(test.getAssignmentID() == tempAssignmentID);
    }

    @Test
    public void testSetAssignmentID() throws Exception {
        int tempAssignmentID = -66;

        test.setAssignmentID(tempAssignmentID);
        assertTrue(test.getAssignmentID() == tempAssignmentID);
    }

    @Test
    public void testGetFilePath() throws Exception {
        URI testURI = URI.create("testPath22");
        test.setFilePath(testURI);
        assertTrue(test.getFilePath().equals(testURI));
    }

    @Test
    public void testSetFilePath() throws Exception {
        URI testURI = URI.create("testPath22");
        test.setFilePath(testURI);
        assertTrue(test.getFilePath().equals(testURI));
    }
}