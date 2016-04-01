package tr.edu.gtu.bilmuh.kasimsuzen;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kasım Süzen on 01.04.2016.
 */
public class LinkedListRecTest {
    @Test
    public void remove() throws Exception {
        LinkedListRec<Integer> linkedListRecRemoveTest = new LinkedListRec<>();

        linkedListRecRemoveTest.add(66);
        linkedListRecRemoveTest.add(69);
        linkedListRecRemoveTest.add(65);
        linkedListRecRemoveTest.add(65);
        linkedListRecRemoveTest.add(75);

        assertTrue(linkedListRecRemoveTest.remove(65));
    }

}