package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.*;

/**
 * Created by siyah on 10.04.2016.
 */
public class PriorityVector <E extends Comparable<? super E>> implements PriorityQueueInterface {

    private Comparator comparer;
    private Vector<E> data;

    //Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
    PriorityVector(){
        data = new Vector<E>();
    }

    //Creates a PriorityQueue containing the elements in the specified collection.
    PriorityVector(Collection<? extends E> c){

    }

    //Creates a PriorityQueue with the specified initial capacity that orders its elements according to their natural ordering.
    PriorityVector(int initialCapacity){

    }

    //Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
    PriorityVector(int initialCapacity, Comparator<? super E> comparator){

    }

    //Creates a PriorityQueue containing the elements in the specified priority queue.
    PriorityVector(PriorityVector <? extends E> c){

    }


    E getMsElement(){
        return data.get(0);
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
