package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by oguzhan on 14/04/16.
 */
public class PriorityLinkedList<E extends Comparable<E>> implements PriorityQueueInterface<E> {

    private LinkedList<E> data;

    public PriorityLinkedList() {
        this.data = new LinkedList<>();
    }

    @Override
    public boolean add(E e) {
        boolean result = this.data.add(e);
        Collections.sort(this.data,Collections.reverseOrder());
        return result;
    }

    @Override
    public boolean offer(E e) {
        return this.add(e);
    }

    @Override
    public E remove() {
        E elem = this.poll();
        if (elem == null)
            throw new NoSuchElementException();
        return elem;
    }

    @Override
    public E poll() {
        if (this.isEmpty())
            return null;
        return this.data.remove(0);
    }

    @Override
    public E element() {
        E elem = this.peek();
        if (elem == null)
            throw new NoSuchElementException();
        return elem;
    }

    @Override
    public E peek() {
        if (this.isEmpty())
            return null;
        return this.data.get(0);
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
