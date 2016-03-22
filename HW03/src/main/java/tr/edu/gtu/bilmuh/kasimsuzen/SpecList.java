package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.*;

/**
 * @author Kasım Süzen 111044034
 * Created by Kasım Süzen on 05.03.2016
 *
 * This class is extender of LinkedList implemented as a part of third homework of CSE 222 course of GTU
 * This class implements three extra methods over LinkedList
 * @see SpecList#addAllAtHead(Collection)
 * @see SpecList#getIntersectList(Collection)
 * @see SpecList#sort(Comparator)
 *
 * @param <E> Extends Comparable
 */
public class SpecList<E extends Comparable<? super E>> extends LinkedList{
    /**
     * Adds all elements to the head of the linked list
     * @param c Collections of elements to add as Collection ? extends E
     * @return True if success False in case of error
     * @throws NullPointerException if parameter is empty
     */
    public Boolean addAllAtHead(Collection<? extends E> c) throws NullPointerException {
        if(c == null)
            throw new NullPointerException();

        c.forEach(this::addFirst);
        return true;
    }

    /**
     * Returns intersection of parameter and
     * @param c Second List to calculate intersect list
     * @return Intersect list of given list and invoked objects list
     * @throws NullPointerException if parameter is empty
     */
    List<E> getIntersectList (Collection<? extends E> c) throws NullPointerException{
        if(c == null)
            throw new NullPointerException();

        SpecList<E> temp = new SpecList<E>();
        boolean found = false;
        for (int i= 0 ; i < this.size(); ++i){
            for (int j=0 ;j < c.size(); ++j){
                Iterator it =  c.iterator();
                while(it.hasNext() && this.get(i).compareTo((E) it.next()) == 0){
                    for (int k=0; k < temp.size();++k){
                        if(temp.get(k).compareTo(this.get(j)) == 0)
                            found = true;
                    }
                    if(!found)
                        temp.add(this.get(j));
                    found = false;
                }
            }
        }
        return temp;
    }

    /**
     * Sorts and returns a new list using cocktail sort
     * @param mode if 0 ascending sort if 1 descending sort
     * @return sorted list
     */
    public List<E> sortList(int mode){
        boolean isToEnd = false,flag = false;
        int j;

        for (int i=0; i< size();++i){
            if(isToEnd)
                j=0;
            else
                j= size() - 2;
            while(true){

                if(mode == 1 && this.get(j).compareTo(this.get(j+1)) < 0){
                    E temp = this.get(j);
                    set(j,this.get(j+1));
                    set(j+1,temp);
                }

                if(mode == 0 && this.get(j).compareTo(this.get(j+1)) > 0){
                    E temp = this.get(j);
                    set(j,this.get(j+1));
                    set(j+1,temp);
                }

                if(isToEnd){
                    if (j == size() - 2) {
                        isToEnd = false;
                        break;
                    }
                    ++j;
                }
                else {
                    if ( j == 0) {
                        isToEnd = true;
                        break;
                    }
                    --j;
                }
            }

        }
        return this;
    }

    /**
     * Gets indexed elements and returns as E
     * @param index Index of element to get
     * @return Element at index as E
     */
    @Override
    public E get(int index) {
        return (E) super.get(index);
    }
}
