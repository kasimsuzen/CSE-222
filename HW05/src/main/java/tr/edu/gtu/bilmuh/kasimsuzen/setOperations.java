package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siyah on 01.04.2016.
 */
public class setOperations <E extends Comparable<? super E>>{
    private ArrayList<E> list1,list2;

    /**
     * Constructor for SetOperation class takes two ArrayList for data
     * @param arr First ArrayList
     * @param arr2 Second ArrayList
     */
    public setOperations(ArrayList<E> arr, ArrayList<E> arr2){
        list1 = arr;
        list2 = arr2;
    }

    /**
     * Returns Intersect of two list that array keep as class member does this operation recursively
     * @return Intersect list as List<E> empty list if any list is empty
     */
    public List<E> intersectionOfLists(){
        return interSectRec(list1,list2);
    }

    /**
     * Main recursive intersect function
     * @param data1 First ArrayList
     * @param data2 Second ArrayList
     * @return Intersected list as List<E> empty list if any list is empty
     */
    private List<E> interSectRec(List<E> data1,List<E> data2){
        ArrayList<E> temp = new ArrayList<>();
        if(data1 == null || data2 == null || data1.size() == 0)
            return temp;

        if(data1.size() != 0)
            temp = (ArrayList<E>) interSectRec(data1.subList(1,data1.size()),data2);

        if(isElement(data2,data1.get(0)))
            temp.add(data1.get(0));
        return temp;
    }

    /**
     * Returns union of two list which is class member of this class does this operation recursively
     * @return Union of two list as List<E> empty list if both list is empty
     */
    public List<E> unionOfLists(){
        return unionRecursive(list1,list2);
    }

    /**
     * Main recursive function for union operation
     * @param data1 First List
     * @param data2 Second List
     * @return Union of two list as List<E> empty list if both list is empty
     */
    private List<E> unionRecursive(List<E> data1,List<E> data2){
        ArrayList<E> temp = new ArrayList<>();
        if(data1 == null || data1.size() == 0)
            return new ArrayList<E>(list2);
        if(data1.size() != 0)
            temp = (ArrayList<E>) unionRecursive(data1.subList(1,data1.size()),data2);
        if (!isElement(data2,data1.get(0)))
            temp.add(data1.get(0));

        return temp;
    }

    /**
     * Controls if given element is element of given List<E> does this recursively
     * @param lock List<E> to search
     * @param key Element to search
     * @return true if element if not returns false
     */
    private boolean isElement(List<E> lock, E key){
        boolean isFound= false;
        if(lock == null || key == null)
            return false;
        if(lock.size() == 0)
            return false;
        if(lock.get(0).compareTo(key) == 0)
            return true;

        isFound = isElement(lock.subList(1,lock.size()),key);
        return isFound;
    }

    /**
     * Controls if list2 is list1's subset does this recursively
     * @return true if list2 subset of list1 otherwise false
     */
    public boolean isSubset(){
        return isSubsetHelper(list1,list2);
    }

    /**
     * Actual recursive function for isSubset
     * @param data1 First List
     * @param data2 Second List
     * @return true if list2 subset of list1 otherwise false
     */
    private boolean isSubsetHelper(List<E> data1,List<E> data2){
        boolean isSub;
        if(data1.size() == 0 && data2.size() != 0)
            return false;
        if(data2.size() == 0)
            return true;
        if(data1.get(0).compareTo(data2.get(0)) > 0)
            return false;
        if(data1.get(0).compareTo(data2.get(0)) == 0)
            isSub = isSubsetHelper(data1.subList(1,data1.size()),data2.subList(1,data2.size()));
        else
            isSub = isSubsetHelper(data1.subList(1,data1.size()),data2);
        return isSub;
    }
}
