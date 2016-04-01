package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Kasım Süzen on 01.04.2016.
 */
public class HanoiTowerTest {
    @org.junit.Test
    public void towerOfHanoi() throws Exception {
        HanoiTower hanoiTowerTest = new HanoiTower();
        LinkedList<Integer> pegA = new LinkedList<>();
        LinkedList<Integer> pegB = new LinkedList<>();
        LinkedList<Integer> pegC = new LinkedList<>();

        for (int i= 4 ; i > 0 ; --i){
            pegA.push(i);
        }
        hanoiTowerTest.TowerOfHanoi(4,pegA,pegB,pegC);
        assertTrue(hanoiTowerTest.isEnded(4,pegA,pegB,pegC));
    }

}