package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Queue;

/**
 * Created by siyah on 13.04.2016.
 */
public interface PriorityQueueInterface  {

    default int size() {
        return 0;
    }

    default boolean isEmpty() {
        return false;
    }

    default boolean add(Object o) {
        return false;
    }

    default boolean offer(Object o) {
        return false;
    }

    default Object remove() {
        return null;
    }

    default Object poll() {
        return null;
    }

    default Object element() {
        return null;
    }

    default Object peek() {
        return null;
    }
}
