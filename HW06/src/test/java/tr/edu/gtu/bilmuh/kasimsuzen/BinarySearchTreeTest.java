package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by siyah on 14.04.2016.
 */
public class BinarySearchTreeTest extends BinaryTree {
    @org.junit.Test
    public void iterator() throws Exception {
        BinarySearchTree<Integer> bsttree = new BinarySearchTree<Integer>();

        bsttree.add(5);
        bsttree.add(56);
        bsttree.add(45);

        Iterator it = bsttree.iterator();
        assertTrue(it.next().toString().compareTo("5") == 0);
        assertTrue(it.hasNext());
        assertTrue(it.next().toString().compareTo("56") == 0);
        assertTrue(it.hasNext());
        assertTrue(it.next().toString().compareTo("45") == 0);
        //assertFalse(it.hasNext());

    }

}