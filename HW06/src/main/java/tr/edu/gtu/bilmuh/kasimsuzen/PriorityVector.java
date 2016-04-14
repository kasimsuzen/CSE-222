package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.NoSuchElementException;
import java.util.Vector;


/**
 * Created by oguzhan on 14/04/16.
 */
public class PriorityVector<E extends Comparable<E>> implements PriorityQueueInterface<E> {

    private Vector<E> data;

    public PriorityVector() {
        this.data = new Vector<>();
    }


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

    @Override
    public boolean add(E e) {
        return this.data.add(e);
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
        E max = this.getMax();
        this.data.remove(max);
        return max;
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
        return this.getMax();
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
