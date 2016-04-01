package tr.edu.gtu.bilmuh.kasimsuzen;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Kasım süzen on 01.04.2016.
 */
public class SetOperationsTest {
    ArrayList<Integer> firstList;
    ArrayList<Integer> secondList;
    ArrayList<Integer> thirdList;
    SetOperations<Integer> test1,test2;

    @Test
    public void intersectionOfLists() throws Exception {
        assertTrue(test1.intersectionOfLists().size() == 3);
        assertTrue(test2.intersectionOfLists().size() == 2);
    }

    @Test
    public void unionOfLists() throws Exception {
        assertTrue(test1.unionOfLists().size() == 6);
        assertTrue(test2.unionOfLists().size() == 7);
    }

    @Test
    public void isSubset() throws Exception {
        assertTrue(test1.isSubset());
        assertFalse(test2.isSubset());
    }

    @Before
    public void setUp() throws Exception {
        firstList = new ArrayList<Integer>();
        secondList = new ArrayList<Integer>();
        thirdList = new ArrayList<Integer>();

        firstList.add(5);
        firstList.add(7);
        firstList.add(78);
        firstList.add(89);
        firstList.add(859);
        firstList.add(899);

        secondList.add(7);
        secondList.add(78);
        secondList.add(89);

        thirdList.add(7);
        thirdList.add(78);
        thirdList.add(468434);
        test1 = new SetOperations<Integer>(firstList,secondList);
        test2 = new SetOperations<Integer>(firstList,thirdList);
    }
}