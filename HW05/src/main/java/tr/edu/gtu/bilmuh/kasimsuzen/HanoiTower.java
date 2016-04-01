package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Kasım Süzen on 01.04.2016.
 * @author Kasım Süzen
 * This class implemented for iterativ solution of tower of hanoi
 */
public class HanoiTower {
    private int numOfDisks;

    /**
     * Constructor for Tower of hanoi class takes number of disk in game
     */
    public HanoiTower(){

    }

    /**
     * Plays game as rules order does this iteratively
     * @param diskSize number of disk
     * @param src Source of all disks
     * @param dst Destination peg
     * @param aux auxiliary peg
     */
    public void TowerOfHanoi(int diskSize, LinkedList<Integer> src, LinkedList<Integer> dst, LinkedList<Integer> aux){
        numOfDisks = diskSize;
        // even number of disks
        System.out.printf("Pegs at start \n");
        printStacks(4,src,dst,aux);
        if(numOfDisks % 2 == 0){
            do{
                if( src.peek() != null && (dst.peek() == null || dst.peek().compareTo(src.peek()) > 0) )
                    dst.push(src.pop());
                else if(dst.peek() != null && (src.peek() == null || src.peek().compareTo(dst.peek()) > 0))
                    src.push(dst.pop());

                if (aux.peek() != null && (src.peek() == null || src.peek().compareTo(aux.peek()) > 0))
                    src.push(aux.pop());
                else if(src.peek() != null && ( aux.peek() == null || aux.peek().compareTo(src.peek()) > 0))
                    aux.push(src.pop());

                if(aux.peek() != null && (dst.peek() == null || dst.peek().compareTo(aux.peek()) > 0))
                    dst.push(aux.pop());
                else if(dst.peek() != null &&(aux.peek() == null || aux.peek().compareTo(dst.peek()) > 0))
                        aux.push(dst.pop());

                System.out.printf("After move \n");
                printStacks(4,src,dst,aux);
            }while (!isEnded(4,src,dst,aux));
        }
        // odd number of disks
        if(numOfDisks % 2 != 0){
            do {
                numOfDisks = numOfDisks;
                if (aux.peek() != null && (src.peek() == null || src.peek().compareTo(aux.peek()) > 0))
                    src.push(aux.pop());
                else if (src.peek() != null && (aux.peek() == null || aux.peek().compareTo(src.peek()) > 0))
                    aux.push(src.pop());

                if (src.peek() != null && (dst.peek() == null || dst.peek().compareTo(src.peek()) > 0))
                    dst.push(src.pop());
                else if (dst.peek() != null && (src.peek() == null || src.peek().compareTo(dst.peek()) > 0))
                    src.push(dst.pop());

                if (aux.peek() != null && (dst.peek() == null || dst.peek().compareTo(aux.peek()) > 0))
                    dst.push(aux.pop());
                else if (dst.peek() != null && (aux.peek() == null || aux.peek().compareTo(dst.peek()) > 0))
                    aux.push(dst.pop());

                System.out.printf("After move \n");
                printStacks(4,src,dst,aux);
            } while (!isEnded(4,src,dst,aux));
        }
        System.out.printf("Last status");
        printStacks(4,src,dst,aux);
    }

    /**
     * Checks that is the game finished or not
     * @param diskSize number of disk
     * @param src Source of all disks
     * @param dst Destination peg
     * @param aux auxiliary peg
     * @return true if game is finished false on continous game
     */
    public boolean isEnded(int diskSize, LinkedList<Integer> src, LinkedList<Integer> dst, LinkedList<Integer> aux) {
        numOfDisks = diskSize;
        return src.size() == numOfDisks || dst.size() == numOfDisks || aux.size() == numOfDisks;
    }

    /**
     * Prints pegs status nicely
     * @param diskSize number of disk
     * @param src Source of all disks
     * @param dst Destination peg
     * @param aux auxiliary peg
     */
    public void printStacks (int diskSize, LinkedList<Integer> src, LinkedList<Integer> dst, LinkedList<Integer> aux){
        numOfDisks = diskSize;
        Iterator itA = src.iterator();
        Iterator itB = dst.iterator();
        Iterator itC = aux.iterator();
        for (int i=numOfDisks ; i >= 0; --i) {
            if (src.size() > i) {
                System.out.printf("%s\t", itA.next());
            } else
                System.out.printf("\t");
            if(dst.size() > i)
                System.out.printf("%s\t",itB.next());
            else
                System.out.printf("\t");
            if (aux.size() > i)
                System.out.printf("%s\n",itC.next());
            else
                System.out.printf("\n");
        }
        System.out.printf("\n");
    }
}
