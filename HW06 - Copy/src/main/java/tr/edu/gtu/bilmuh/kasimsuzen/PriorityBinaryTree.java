package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;

/**
 * Created by siyah on 13.04.2016.
 */
public class PriorityBinaryTree<E extends Comparable<? super E>> implements PriorityQueueInterface {
    public PriorityBinaryTree() {

    }

    public PriorityBinaryTree(int initialCapacity) {

    }

    public PriorityBinaryTree(Comparator<? super E> comparator) {

    }

    public PriorityBinaryTree(int initialCapacity, Comparator<? super E> comparator) {
    }

    public PriorityBinaryTree(Collection<? extends E> c) {

    }

    public PriorityBinaryTree(PriorityBinaryTree<? extends E> c) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
