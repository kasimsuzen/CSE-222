package tr.edu.gtu.bilmuh.kasimsuzen;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by siyah on 23.03.2016.
 */
public class AssemblerTest {
    Assembler asm = new Assembler("wer");

    @Test
    public void testIsThereOperator() throws Exception {
        String temp = "5 8 + 87";
        assertTrue(asm.isThereOperator(temp));
    }
}