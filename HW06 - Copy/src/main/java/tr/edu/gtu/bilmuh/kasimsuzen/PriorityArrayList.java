package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.*;

/**
 * Created by siyah on 10.04.2016.
 */
public class PriorityArrayList<E extends Comparable<? super E>> implements PriorityQueueInterface {
    public PriorityArrayList() {

    }

    public PriorityArrayList(int initialCapacity) {

    }

    public PriorityArrayList(Comparator<? super E> comparator) {

    }

    public PriorityArrayList(int initialCapacity, Comparator<? super E> comparator) {
    }

    public PriorityArrayList(Collection<? extends E> c) {

    }

    public PriorityArrayList(PriorityQueue<? extends E> c) {

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
