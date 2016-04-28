package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * This class Created by Kasım süzen 111044034 on 28.04.2016
 * This class is ann implementation of priority queue using sorted array list,
 * Array list will be sort added at each element addition
 */
public class PriorityArrayList<Customer> implements PriorityQueueInterface<Customer> {

    private ArrayList<Customer> data;
    private Comparator<Customer> myComp;

    /**
     * Creates a new empty Priority array list
     */
    public PriorityArrayList() {
        this.data = new ArrayList<>();
        myComp = null;
    }

    /**
     * Creates a new empty empty Priority array list using custom comparator
     * @param myComp Custom comparator given from user
     */
    public PriorityArrayList(Comparator<Customer> myComp) {
        this.data = new ArrayList<>();
        this.myComp = myComp;
    }

    /** Adds new element to end of the vector
     * @param customer Element to add to vector without sort
     * @return true on success false on fail
     */
    public boolean add(Customer customer) {
        boolean result = this.data.add(customer);
            Collections.sort(this.data,myComp);
        return result;
    }

    /**
     * Adds element to list
     * @param customer Element to remove
     * @return true on success false on fail
     */
    public boolean offer(Customer customer) {
        return this.add(customer);
    }

    /**
     * Removes highest prioritized element from list if there is no element at list then throws exception
     * @return Removed element from list
     * @throws NoSuchElementException
     */
    public Customer remove() {
        Customer elem = this.poll();
        if (elem == null)
            throw new NoSuchElementException();
        return elem;
    }

    /**
     * Removes highest prioritized element form list without exception throwing
     * @return Removed element from list if there is no element then null returned
     */
    public Customer poll() {
        if (this.isEmpty())
            return null;
        return this.data.remove(0);
    }

    /**
     * Peeks highest prioritized element list if there is no element throws exception
     * @return Highest prioritized element at list
     * @throws NoSuchElementException
     */
    public Customer element() {
        if (data == null) {
            throw new NoSuchElementException();
        }
        return this.data.get(0);
    }

    /**
     * Peeks highest prioritized element at listif there is no returns null
     * @return Highest prioritized element at list
     */
    public Customer peek() {
        if (this.isEmpty())
            return null;
        return this.data.get(0);
    }

    /**
     * Returns size of vector
     * @return Size of vector
     */
    public int size() {
        return this.data.size();
    }

    /**
     * Checks that if vector is empty is empty returns true else returns false
     * @return True on success false on fail
     */
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
