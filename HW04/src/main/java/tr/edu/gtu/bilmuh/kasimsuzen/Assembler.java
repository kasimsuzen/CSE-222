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
    private ArrayList<String> assemblyCode;
    private Stack<String> tempPostFixes;
    private ArrayList<Stack<String>> postFixes;
    private ArrayList<String> opList;
    private String filePath;
    private Instruction inst = new Instruction();
    Memory mem = Memory.getInstance();

    /**
     * Constructor for this class takes a path of a file to read
     * @param file Path to input file
     */
    public Assembler(String file){
        filePath = file;
        tempPostFixes = new Stack<>();
        postFixes = new ArrayList<>();
        opList = new ArrayList<>();
    }

    /**
     * Reads file using file path that given in constructor.
     * @return True on success false on error
     */
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

    /**
     * Converts given infix expression to postfix
     * @return True on success false on error
     */
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

    /**
     * Creates assembly code using postfix expressions that taken by input file
     */
    public void makeAssemblyCode(){
        String operand1,operand2,operator;
        assemblyCode = new ArrayList<>();
        Stack<String> operandStack = new Stack<>();
        char op;
        for (int i=0; i < postFixes.size(); ++i) {
            for (int j=0; j < postFixes.get(i).size(); ++j) {
                if(postFixes.get(i).get(j).charAt(0) >= 'a' && postFixes.get(i).get(j).charAt(0) <= 'z' ){
                    mem.addElement(postFixes.get(i).get(j));
                }
            }
        }

        for (int i=0; i < postFixes.size(); ++i) {
            for (int j=0; j < postFixes.get(i).size(); ++j){
                operandStack = new Stack<>();
                if(isThereOperator(postFixes.get(i).get(j))){
                    op = postFixes.get(i).get(j).charAt(0);

                    if(op == '+')
                        assemblyCode.add(inst.add(postFixes.get(i).pop(),postFixes.get(i).pop(),mem.emptyReg()));
                    else if(op == '-') {
                        assemblyCode.add(inst.subtract(postFixes.get(i).pop(), postFixes.get(i).pop(), mem.emptyReg()));
                    }
                    else if(op == '*')
                        assemblyCode.add(inst.multiply(postFixes.get(i).pop(),postFixes.get(i).pop()));
                    else if(op == '/')
                        assemblyCode.add(inst.div(postFixes.get(i).pop(),postFixes.get(i).pop()));
                    else if(op == '=') {
                        postFixes.get(i).pop();
                        String tmp = postFixes.get(i).pop();
                        if(tmp.charAt(0) != '$')
                            assemblyCode.add(inst.loadImm(postFixes.get(i).pop(),Integer.parseInt(tmp)));
                        else
                            assemblyCode.add(inst.move(postFixes.get(i).pop(),tmp));
                    }
                }
                else if(postFixes.get(i).get(j).contains("print")){
                    assemblyCode.add(inst.print(postFixes.get(i).pop()));
                }
                else if(postFixes.get(i).get(j).charAt(0) >= 'a' && postFixes.get(i).get(j).charAt(0) <= 'z' ){
                    operandStack.push(postFixes.get(i).get(j));
                }
                else if(Integer.parseInt(postFixes.get(i).get(j)) >= 0 && Integer.parseInt(postFixes.get(i).get(j)) <= 0){
                    operandStack.push(postFixes.get(i).get(j));
                }
            }
        }

        try {
            Files.write(Paths.get("output.txt"), assemblyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * To check is there operator in string
     * @param str String to be searched
     * @return True if * - / + were there in string false when not
     */
    public boolean isThereOperator(String str){
        return str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/") || str.contains("=");
    }
}
