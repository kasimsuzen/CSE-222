import org.junit.Test;
import tr.edu.gtu.bilmuh.ksuzen.Tutor;

import static org.junit.Assert.*;

/**
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class TutorTest {

    Tutor test = new Tutor("Tutor Test");

    @Test
    public void testGetIDNo() throws Exception {
        int tempID = -999;
        test.setIDNo(tempID);

        assertTrue(test.getIDNo() == tempID);
    }

    @Test
    public void testSetIDNo() throws Exception {
        int tempID = -999;

        test.setIDNo(tempID);
        assertTrue(test.getIDNo() == tempID);
    }

    @Test
    public void testGetName() throws Exception {
        String tempChangedName = "tempName";

        test.setName(tempChangedName);
        assertTrue(test.getName().equals(tempChangedName));
    }

    @Test
    public void testSetName() throws Exception {
        String tempChangedName = "tempName";
        test.setName(tempChangedName);
        assertTrue(test.getName().equals(tempChangedName));
    }
}