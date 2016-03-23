package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.ArrayList;

/**
 * Created by Kasım Süzen on 22.03.2016.
 *
 */
public class Expression {
    private ArrayList<String> lines;

    public Expression(){ lines = new ArrayList<>(); }

    public void addExp(String expData){
        lines.add(expData.toLowerCase());
    }

    public String getExp(int index){ return lines.get(index); }

    public int getSize(){
        return lines.size();
    }

    public void clear(){
        lines.clear();
    }

    @Override
    public String toString(){
        return lines.toString();
    }
}
