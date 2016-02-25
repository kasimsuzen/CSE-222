import org.junit.Test;
import tr.edu.gtu.bilmuh.ksuzen.Assignment;

import java.net.URI;

import static org.junit.Assert.*;

/**
 * @author Kasım Süzen
 * Created on 24.02.2016
 */
public class AssignmentTest {

    Assignment test = new Assignment("23/02/2016","24/03/2016", URI.create("testPath"),1);

    @Test
    public void testGetAssignmentID() throws Exception {
        int testID = 55;

        test.setAssignmentID(testID);

        assertTrue(test.getAssignmentID() == testID);
    }

    @Test
    public void testSetAssignmentID() throws Exception {
        int testID = 77;

        test.setAssignmentID(testID);

        assertTrue(test.getAssignmentID() == testID);
    }

    @Test
    public void testGetDueDate() throws Exception {
        String tempDue = "25/05/8526";

        test.setDueDate(tempDue);
        assertTrue(test.getDueDate().equals(tempDue));
    }

    @Test
    public void testSetDueDate() throws Exception {
        String tempDue = "25/05/8526";

        test.setDueDate(tempDue);
        assertTrue(test.getDueDate().equals(tempDue));
    }

    @Test
    public void testGetLateDate() throws Exception {
        String tempLate = "25/05/8526";

        test.setLateDate(tempLate);
        assertTrue(test.getLateDate().equals(tempLate));
    }

    @Test
    public void testSetLateDate() throws Exception {
        String tempLate = "25/05/8526";

        test.setLateDate(tempLate);
        assertTrue(test.getLateDate().equals(tempLate));
    }

    @Test
    public void testGetAssignmentFilePath() throws Exception {
        URI testURI = URI.create("testPath22");
        test.setAssignmentFilePath(testURI);
        assertTrue(test.getAssignmentFilePath().equals(testURI));
    }

    @Test
    public void testSetAssignmentFilePath() throws Exception {
        URI testURI = URI.create("testPath22");
        test.setAssignmentFilePath(testURI);
        assertTrue(test.getAssignmentFilePath().equals(testURI));
    }
}