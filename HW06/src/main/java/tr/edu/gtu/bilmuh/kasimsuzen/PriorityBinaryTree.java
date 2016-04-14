package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.NoSuchElementException;

/**
 * Created by oguzhan on 14/04/16.
 */
public class PriorityBinaryTree<E extends Comparable<E>> implements PriorityQueueInterface<E> {

    private BinarySearchTree<E> data;
    private int size;

    public PriorityBinaryTree() {
        this.data = new BinarySearchTree<>();
        this.size = 0;
    }

    @Override
    public boolean add(E e) {
        this.size += 1;
        return this.data.add(e);
    }

    @Override
    public boolean offer(E e) {
        return this.add(e);
    }

    private E findLargest() {
        BinaryTree<E> curr = this.data;
        while (curr.getRightSubtree() != null) {
            curr = curr.getRightSubtree();
        }
        return curr.getData();
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
        this.size -= 1;
        return this.data.delete(this.findLargest());
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
        return this.findLargest();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.data.getData() == null);
    }
}
