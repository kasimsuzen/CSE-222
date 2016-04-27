package tr.edu.gtu.bilmuh.kasimsuzen;


import java.util.NoSuchElementException;

/**
 * Created by kasim on 14/04/16.
 */
public interface PriorityQueueInterface<E> {
    boolean add(E e);

    boolean offer(E e);

    E remove() throws NoSuchElementException;

    E poll();

    E element() throws NoSuchElementException;

    E peek();

    int size();

    boolean isEmpty();
}
