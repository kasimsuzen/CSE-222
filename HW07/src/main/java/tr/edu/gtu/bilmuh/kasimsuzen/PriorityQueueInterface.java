package tr.edu.gtu.bilmuh.kasimsuzen;


import java.util.NoSuchElementException;

/**
 * This Interface Created by Kasım süzen 111044034 on 28.04.2016
 * This interface created for possible future addition to homework
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
