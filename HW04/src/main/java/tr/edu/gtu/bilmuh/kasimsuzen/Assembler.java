package tr.edu.gtu.bilmuh.kasimsuzen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Kasım Süzen on 23.03.2016.
 *
 */
public class Assembler {
    private Expression expList = new Expression();
    private Stack<String> tempPostFixes;
    private ArrayList<Stack<String>> postFixes;
    private ArrayList<String> opList;
    private String filePath;

    public void reserveStack(Stack<String> obj){
        Stack<String> temp = new Stack<String>();
        System.out.printf("geliş %s\n",obj);
        while(!obj.empty()){
            temp.push(obj.pop());
        }
        obj = temp;
        System.out.printf("gidiş %s\n",obj);
    }

    public Assembler(String file){
        filePath = file;
        tempPostFixes = new Stack<>();
        postFixes = new ArrayList<>();
        opList = new ArrayList<>();
    }

    public boolean readFile(){

        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(expList::addExp);
        } catch (IOException ex) {
            ex.getMessage();
            return false;
        }

        return true;
    }

    public boolean convertToPostFix(){
        ArrayList<String> expressionArray = new ArrayList<>();
        String[] stringArray;
        opList = new ArrayList<>();
        boolean isAssign = false;

        for(int i=0;i< expList.getSize();++i){
            stringArray = expList.getExp(i).split(" ");
            expressionArray = new ArrayList<>();
            tempPostFixes = new Stack<>();
            opList = new ArrayList<>();
            Collections.addAll(expressionArray, stringArray);

            for (String anExpressionArray : expressionArray) {
                if (anExpressionArray.charAt(0) == '(' || anExpressionArray.charAt(0) == '*' || anExpressionArray.charAt(0) == '/' ||
                        anExpressionArray.charAt(0) == '+' || anExpressionArray.charAt(0) == '-' || anExpressionArray.charAt(0) == '=') {

                    if (anExpressionArray.charAt(0) == '=')
                        isAssign = true;
                    else if (opList.size() == 0)
                        opList.add(anExpressionArray);
                    else if (anExpressionArray.charAt(0) == '(')
                        opList.add("(");

                        // low precedence add
                    else if ((anExpressionArray.charAt(0) == '+' || anExpressionArray.charAt(0) == '-') && opList.get(opList.size() - 1).charAt(0) != '*' && opList.get(opList.size() - 1).charAt(0) != '/')
                        opList.add(anExpressionArray);
                        // high precedence add
                    else if ((anExpressionArray.charAt(0) == '+' || anExpressionArray.charAt(0) == '-') && (opList.get(opList.size() - 1).charAt(0) == '*' || opList.get(opList.size() - 1).charAt(0) == '/')) {

                        while (opList.size() > 0) {
                            tempPostFixes.push(opList.remove(0));
                        }

                        opList.add(anExpressionArray);
                    } else
                        opList.add(anExpressionArray); // * and / addition

                } else if (anExpressionArray.charAt(0) == ')') {
                    int k = 0;
                    while (opList.size() > 0) {
                        tempPostFixes.push(opList.remove(0));
                        if (opList.get(k).contains("(")) {
                            opList.remove(k);
                            break;
                        }
                        ++k;
                    }
                } else if (anExpressionArray.compareTo("a") >= 0 && anExpressionArray.compareTo("z") <= 0) {
                    tempPostFixes.push(anExpressionArray);
                } else if (Integer.parseInt(anExpressionArray) >= 0) {
                    tempPostFixes.push(anExpressionArray);
                }
            }
            if(opList.size() > 0) {
                while (opList.size() > 0)
                    tempPostFixes.push(opList.remove(0));
            }
            if(isAssign)
                tempPostFixes.push("=");
            isAssign = false;
            postFixes.add(tempPostFixes);

        }
        System.out.printf("last \n");
        for (int k=0; k < postFixes.size(); ++k) {
            System.out.printf("%s\n", postFixes.get(k));
        }
        return true;
    }

    public static void main(String [] args){
        Assembler as = new Assembler("input.txt");
        as.readFile();
        as.convertToPostFix();
    }
}
