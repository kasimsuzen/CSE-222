package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Vector;


/**
 * Created by Kasım Süzen 111044034 on 14/04/16.
 * @author Kasım Süzen
 */
public class PriorityVector<E extends Comparable<E>> implements PriorityQueueInterface<E> {

    private Vector<E> data;
    private Comparator<E> myComp;

    /**
     * Creates a new PriorityVector object which is empty
     */
    public PriorityVector() {
        this.data = new Vector<>();
    }

    /**
     * Creates a new Priority vector using custom comparator
     * @param comp Custom Comparator Given from user
     */
    public PriorityVector(Comparator<E> comp){
        this.data = new Vector<>();
        myComp = comp;
    }

    /** Searchs and gets Highest priority element from vector
     * @return Highest prioritized element
     */
    private E getMax() {

        if (this.isEmpty())
            return null;

        E max = this.data.get(0);

        for (E elem : this.data) {
            if (elem.compareTo(max) > 0)
                max = elem;
        }

        return max;
    }

    /** Adds new element to end of the vector
     * @param e Element to add to vector without sort
     * @return true on success false on fail
     */
    @Override
    public boolean add(E e) {
        return this.data.add(e);
    }

    /**
     * Adds element to list
     * @param e Element to remove
     * @return true on success false on fail
     */
    @Override
    public boolean offer(E e) {
        return this.add(e);
    }

    /**
     * Removes highest prioritized element from list if there is no element at list then throws exception
     * @return Removed element from list
     * @throws NoSuchElementException
     */
    @Override
    public E remove() throws NoSuchElementException {
        E elem = this.poll();
        if (elem == null)
            throw new NoSuchElementException();
        return elem;
    }

    /**
     * Removes highest prioritized element form list without exception throwing
     * @return Removed element from list if there is no element then null returned
     */
    @Override
    public E poll() {
        E max = this.getMax();
        this.data.remove(max);
        return max;
    }

    /**
     * Peeks highest prioritized element list if there is no element throws exception
     * @return Highest prioritized element at list
     * @throws NoSuchElementException
     */
    @Override
    public E element() throws NoSuchElementException {
        E elem = this.peek();
        if (elem == null)
            throw new NoSuchElementException();
        return elem;
    }

    /**
     * Peeks highest prioritized element at listif there is no returns null
     * @return Highest prioritized element at list
     */
    @Override
    public E peek() {
        return this.getMax();
    }

    /**
     * Returns size of vector
     * @return Size of vector
     */
    @Override
    public int size() {
        return this.data.size();
    }

    /**
     * Checks that if vector is empty is empty returns true else returns false
     * @return True on success false on fail
     */
    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
