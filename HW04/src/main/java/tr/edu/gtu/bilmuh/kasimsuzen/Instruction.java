package tr.edu.gtu.bilmuh.kasimsuzen;

/**
 * Created by Kasım Süzen on 23.03.2016.
 * @author Kasım Süzen
 * This class implemented for instruction simulation purposes
 */
public class Instruction {
    Memory mem = Memory.getInstance();

    /**
     * No parameter constructor does nothing
     */
    public Instruction() {

    }

    /**
     * Load immediate load a number to memory
     * @param op1 Memory address
     * @param op2 Number to be loaded
     * @return Assembly code as String
     */
    public String loadImm(String op1,int op2){
        return "li " + mem.getElement(op1) + "," + op2;
    }

    /**
     * Move one memory locations data to another location
     * @param op1 Source Register
     * @param op2 Destination register
     * @return Assembly code as String
     */
    public String move(String op1,String op2){
        return "move " + mem.getElement(op1) + "," + mem.getElement(op2);
    }

    /**
     * Divides two given number
     * @param op1 Number to be divide
     * @param op2 Number to be divider
     * @return Assembly code as String
     */
    public String div(String op1,String op2){
        return "div " + op1 + ","+op2 + "\n" + "mfhi " + op1;
    }

    /**
     * Adds two number
     * @param op1 First number
     * @param op2 Second number
     * @param op3 Operation result register
     * @return Assembly code as String
     */
    public String add(String op1,String op2,String op3){
        return  "add "+ op1 + "," + op2 + "," + op3;
    }

    /**
     * Subtracts two number
     * @param op1 First number
     * @param op2 Second number
     * @param op3 Result of operation
     * @return Assembly code as String
     */
    public String subtract(String op1,String op2,String op3){
        return "sub " + op1 + "," + op2 + ","+ op3;
    }

    /**
     * Multiply given two number
     * @param op1 First number
     * @param op2 second number
     * @return Assembly code as String
     */
    public String multiply(String op1,String op2){
        return "mult " + op1 + "," + op2 + "\n" + "mflo " + op1;
    }

    /**
     * Make a system call to print registers content to screen
     * @param op1 Register to print
     * @return Assembly code as String
     */
    public String print(String op1){
        String temp;
        temp = "move " + "$a0"+ "," + op1 + "\n";
        temp += "li " + "$v0" + "," + "1" + "\n";
        temp += "syscall";
        return temp;
    }
}
