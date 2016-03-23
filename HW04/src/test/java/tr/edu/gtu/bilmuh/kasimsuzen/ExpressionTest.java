package tr.edu.gtu.bilmuh.kasimsuzen;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siyah on 23.03.2016.
 */
public class ExpressionTest {
    Expression exp = new Expression();
    @Test
    public void testAddExp() throws Exception {
        String temp ="5 + 8";
        exp.addExp(temp);
        assertTrue(exp.getExp(0).compareTo(temp) == 0);
    }

    @Test
    public void testGetExp() throws Exception {
        String temp ="5 + 8";
        exp.addExp(temp);
        assertTrue(exp.getExp(0).compareTo(temp) == 0);
    }

    @Test
    public void testGetSize() throws Exception {
        String temp ="5 + 8";
        exp.addExp(temp);
        assertTrue(exp.getSize() >= 1);
    }

    @Test
    public void testClear() throws Exception {
        String temp ="5 + 8";
        exp.addExp(temp);
        exp.clear();
        assertTrue(exp.getSize() == 0);
    }
}