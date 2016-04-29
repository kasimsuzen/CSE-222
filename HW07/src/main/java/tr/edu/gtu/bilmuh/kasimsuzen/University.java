package tr.edu.gtu.bilmuh.kasimsuzen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 * This class Created by Kasım süzen 111044034 on 28.04.2016
 *  This class holds needed methods and data for required university
 */
public class University {
    String filename;
    Hashtable<Integer,Person> hashtable = new Hashtable<>();

    /**
     * No parameter constructor, this constructor only creates an empty hash table of person's
     */
    public University(){
        hashtable = new Hashtable<>();
    }

    /**
     * Constructor for this class only takes file name to read
     * @param filename Name of the file which holds student and academician's data
     */
    public University(String filename) {
        this.filename = filename;
        this.hashtable = new Hashtable<>();
    }

    /**
     * Reads student and academician data from file and store them to a hash table
     * returns true if there is a collision in data
     * @return true if there is a collision false if not
     */
    public boolean fileReader(){
        // This will reference one line at a time
        boolean flag= false;
        String line,name;
        String tempString[] = new String[50];
        int counter=0,studentCode,academicCode;
        Person temp,prev = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = -1;(line = bufferedReader.readLine()) != null; ++i) {
                //System.out.println(line);
                tempString = line.split("\\s");
                if(i != -1){
                    name = tempString[counter] + " " + tempString[counter+1];
                    counter += 3;

                    // skips all blanks
                    while(tempString[counter].compareTo("") == 0)
                        ++counter;

                    if(tempString[counter].charAt(0) == 'y'){
                        studentCode = -1;
                        ++counter;
                    }
                    else{
                        studentCode = Integer.parseInt(tempString[counter]);
                        ++counter;
                    }

                    //skips all blanks
                    while(tempString[counter].compareTo("") == 0)
                        ++counter;
                    academicCode = Integer.parseInt(tempString[counter]);
                    temp = new Person(studentCode,academicCode,name);
                    prev = hashtable.put(temp.hashCode(),temp);
                    if(prev != null)
                        flag = true;
                    prev = null;
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
        return flag;
    }

    /**
     * Checks if the given barcodes are same persons
     * @param barcode1 Student code as integer should be 1500 and 5000
     * @param barcode2 Academic code as integer should be 5000 and 15000
     * @return true is barcode is owned by the same person false if not or barcode number limits are not properly adjusted
     */
    public boolean isSamePerson(int barcode1,int barcode2) {
        return !(!(barcode1 < 1500 || barcode1 > 5000 || barcode2 < 5000 || barcode2 > 15000) && barcode1 == barcode2 + 5000);
    }
}
