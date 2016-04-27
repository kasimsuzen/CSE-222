package tr.edu.gtu.bilmuh.kasimsuzen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kasim on 27.04.2016
 *
 */
public class Simulater {
    private String filename;
    private ArrayList<Customer> customers;
    private int goldCounter,bronzeCounter,silverCounter;

    public Simulater(String filename) {
        this.filename = filename;
        goldCounter = 0;
        bronzeCounter =0;
        silverCounter=0;
        customers = new ArrayList<>();
    }

    public Simulater(){
        customers = new ArrayList<>();
    }

    public void readFile(){
        // The name of the file to open.

        // This will reference one line at a time
        String line;
        String tempString[] = new String[50];
        int counter=0,hour,minute,transaction,customerType;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = -1;(line = bufferedReader.readLine()) != null; ++i) {
                //System.out.println(line);
                tempString = line.split("\\s");
                if(i != -1){
                    hour = Integer.parseInt(tempString[counter].substring(0,2));
                    minute = Integer.parseInt(tempString[counter].substring(3,5));
                    ++counter;

                    // skips all blanks
                    while(tempString[counter].compareTo("") == 0)
                        ++counter;

                    transaction = Integer.parseInt(tempString[counter]);
                    ++counter;

                    //skips all blanks
                    while(tempString[counter].compareTo("") == 0)
                        ++counter;
                    counter += 1;
                    customerType = Integer.parseInt(tempString[counter]);
                    customers.add(new Customer(customerType,hour,minute,transaction));
                }
                counter =0;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file " +filename);
        }
        catch(IOException ex) {
            System.out.println("Error reading file "+ filename);
        }
    }

    public static void main(String[] args){
        Simulater a = new Simulater("data1.txt");
        a.readFile();
    }

}
