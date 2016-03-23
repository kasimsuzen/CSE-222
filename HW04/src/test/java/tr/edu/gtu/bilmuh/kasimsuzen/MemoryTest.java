package tr.edu.gtu.bilmuh.kasimsuzen;

import static org.junit.Assert.*;

/**
 * Created by siyah on 23.03.2016.
 */
public class MemoryTest {

    @org.junit.Test
    public void testGetInstance() throws Exception {
        assertTrue(Memory.getInstance() != null);
    }

    @org.junit.Test
    public void testGetElement() throws Exception {
        Memory.getInstance().addElement("test2");
        assertTrue(Memory.getInstance().getElement("test2") != null);
    }

    @org.junit.Test
    public void testAddElement() throws Exception {
        assertTrue(Memory.getInstance().addElement("test"));
    }

    @org.junit.Test
    public void testEmptyReg() throws Exception {
        assertTrue(Memory.getInstance().emptyReg() != null);
    }
}