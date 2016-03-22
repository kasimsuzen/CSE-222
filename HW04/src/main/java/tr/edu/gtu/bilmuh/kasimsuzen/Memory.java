package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Kasım Süzen on 22.03.2016.
 *
 */
public class Memory<E> extends ArrayList<E> {
    private ArrayList<String> memData;
    private static Memory<String> data;
    private int nextIndex;

    private Memory(){
        nextIndex = -1;
        memData = new ArrayList<String>();
    }

    public static Memory getInstance(){
        if(data == null)
            data = new Memory<String>();
        return data;
    }

    public String getElement(String variableName){
        for(int i=0; i < memData.size(); ++i){
            if(memData.get(i).equals(variableName))
                return "$t"+i;
        }
        String temp = "There is no element as ";
        temp += variableName;

        throw new NoSuchElementException(temp);
    }

    public boolean addElement(String variableName){
        if(nextIndex == 9)
            throw new IllegalStateException("Variable number can not be more than 9");

        memData.add(variableName);
        ++nextIndex;

        return true;
    }
}
