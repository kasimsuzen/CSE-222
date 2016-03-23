package tr.edu.gtu.bilmuh.kasimsuzen;

/**
 * Created by Kasım Süzen on 23.03.2016.
 * @author Kasım Süzen 111044034
 * This class implemented for driver and test purposes
 */
public class HW04
{
    public static void main(String [] args){
        Assembler as = new Assembler("input.txt");
        as.readFile();
        as.convertToPostFix();
        as.makeAssemblyCode();
    }
}
