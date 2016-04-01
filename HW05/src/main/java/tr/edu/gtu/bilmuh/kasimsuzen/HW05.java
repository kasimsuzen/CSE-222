package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Kasım Süzen on 01.04.2016
 * @author Kasım Süzen 111044034
 * This class implemented for to be driver for SetOperation, LinkedListRec and HanoiTower classes
 */
public class HW05 {
    public static void main(String []argv){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(5);
        list1.add(7);
        list1.add(78);
        list1.add(89);
        list1.add(859);
        list1.add(899);

        list2.add(7);
        list2.add(78);
        list2.add(89);
        list2.add(498465);

        SetOperations<Integer> op = new SetOperations<>(list1,list2);


        System.out.printf("union of list1 and list 2 %s",op.unionOfLists());
        System.out.printf("intersection of list1 and list 2 %s",op.intersectionOfLists());

        LinkedListRec<Integer> link = new LinkedListRec<>();

        link.add(6);
        link.add(69);
        link.add(7);
        link.add(7);
        link.add(75);
        link.add(87);
        link.add(7);
        link.add(57);
        link.add(7);
        link.add(7);
        link.add(75);

        link.remove(7);
        System.out.printf("\n remove 7 form link list %s",link);

        HanoiTower tot = new HanoiTower();
        LinkedList<Integer> pegA = new LinkedList<>();
        LinkedList<Integer> pegB = new LinkedList<>();
        LinkedList<Integer> pegC = new LinkedList<>();

        for (int i= 4 ; i > 0 ; --i){
            pegA.push(i);
        }
        tot.TowerOfHanoi(4,pegA,pegB,pegC);
    }

}
