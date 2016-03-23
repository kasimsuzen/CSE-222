package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Kasım Süzen on 22.03.2016.
 * This is a singleton class to store data all across system this class stores which variable stored at which cell
 */
public class Memory<E> extends ArrayList<E> {
    private ArrayList<String> memData;
    private static Memory<String> data;
    private int nextIndex;

    /**
     * Private constructor
     */
    private Memory(){
        nextIndex = -1;
        memData = new ArrayList<String>();
    }

    /**
     * Instance creater
     * @return Only instance of this object
     */
    public static Memory getInstance(){
        if(data == null)
            data = new Memory<String>();
        return data;
    }

    /**
     * Gets variavle by name as assembly register equivalence
     * @param variableName Name of variable
     * @return equivalence of assemly register
     */
    public String getElement(String variableName){
        int i;
        if(variableName.contains("empty")){
            for ( i=0; i < nextIndex; ++i)
                if(memData.get(i).compareTo("empty") == 0)
                    return "$t"+i;
            return emptyReg();
        }
        for(i=0; i < memData.size(); ++i){
            if(memData.get(i).equals(variableName))
                return "$t"+i;
        }
        String temp = "There is no element as " + i;
        temp += variableName;

        throw new NoSuchElementException(temp);
    }

    /**
     * Adds new variable to memory
     * @param variableName Name of new variable
     * @throws IllegalStateException for if there is more than 9 variable
     * @return true on success
     */
    public boolean addElement(String variableName){
        if(nextIndex == 9)
            throw new IllegalStateException("Variable number can not be more than 9");

        memData.add(variableName);
        ++nextIndex;

        return true;
    }

    /**
     * Gives one unused register to subcalculations
     * @return Assembly register equivalences as String
     */
    public String emptyReg(){
        if(nextIndex == 9)
            throw new ArrayStoreException("There is no space available");
        memData.add("empty");
        ++nextIndex;
        return "$t" + nextIndex;
    }
}
