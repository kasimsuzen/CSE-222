package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;

/**
 * Created by Kasım Süzen on 22.03.2016.
 * This class stores expressions
 */
public class Expression {
    private ArrayList<String> lines;

    /**
     * Constructor creates new object of class using empty data
     */
    public Expression(){ lines = new ArrayList<>(); }

    /**
     * Adds expression to list
     * @param expData Expression to be add
     */
    public void addExp(String expData){
        lines.add(expData.toLowerCase());
    }

    /**
     * Gets expressions by index
     * @param index Index to be access
     * @return Expression at index as String
     */
    public String getExp(int index){ return lines.get(index); }

    /**
     * Size of expressions arraylist
     * @return size as int
     */
    public int getSize(){
        return lines.size();
    }

    /**
     * Removes all content from arraylist
     */
    public void clear(){
        lines.clear();
    }

    /**
     * Prints all expressions as string
     * @return Stringifyed mode of all strings
     */
    @Override
    public String toString(){
        return lines.toString();
    }
}
