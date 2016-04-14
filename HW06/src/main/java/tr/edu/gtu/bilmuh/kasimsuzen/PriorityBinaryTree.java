package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Created by oguzhan on 14/04/16.
 */
public class PriorityBinaryTree<E extends Comparable<E>> implements PriorityQueueInterface<E> {

    private BinarySearchTree<E> data;
    private int size;
    private Comparator<E> myComp;

    /**
     * Creates a new empty Priority binary tree
     */
    public PriorityBinaryTree() {
        this.data = new BinarySearchTree<>();
        this.size = 0;
    }

    /**
     * Creates a new empty Priority binary tree using custom comparator
     * @param comp Custom comparator to use
     */
    public PriorityBinaryTree(Comparator<E> comp){
        myComp = comp;
        this.data = new BinarySearchTree<>();
        this.size = 0;
    }

    /** Adds new element to end of the vector
     * @param e Element to add to vector without sort
     * @return true on success false on fail
     */
    @Override
    public boolean add(E e) {
        this.size += 1;
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
     * Methods to find largest element on tree
     * @return Largest element in tree
     */
    private E findLargest() {
        BinaryTree<E> curr = this.data;
        while (curr.getRightSubtree() != null) {
            curr = curr.getRightSubtree();
        }
        return curr.getData();
    }

    /**
     * Removes highest prioritized element from list if there is no element at list then throws exception
     * @return Removed element from list
     * @throws NoSuchElementException
     */
    @Override
    public E remove() {
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
        this.size -= 1;
        return this.data.delete(this.findLargest());
    }

    /**
     * Peeks highest prioritized element list if there is no element throws exception
     * @return Highest prioritized element at list
     * @throws NoSuchElementException
     */
    @Override
    public E element() {
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
        return this.findLargest();
    }

    /**
     * Returns size of vector
     * @return Size of vector
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Checks that if vector is empty is empty returns true else returns false
     * @return True on success false on fail
     */
    @Override
    public boolean isEmpty() {
        return (this.data.getData() == null);
    }
}
