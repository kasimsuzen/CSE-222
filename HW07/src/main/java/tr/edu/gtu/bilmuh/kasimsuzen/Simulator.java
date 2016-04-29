package tr.edu.gtu.bilmuh.kasimsuzen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class Created by Kasım süzen 111044034 on 28.04.2016
 * This classed holds needed methods and data structure for simulation of customer queue using priority as
 * Customer 1> Customer 2 > Customer 3
 */
public class Simulator {
    private String filename;
    private ArrayList<Customer> customers;
    private PriorityArrayList<Customer> customerQueue;
    private int goldCounter,bronzeCounter,silverCounter,currentHour,currentMinute,lastLoggedHour;

    /**
     * Constructor of this class takes only filename as String
     * @param filename Name of file to run simulation
     */
    public Simulator(String filename) {
        this.filename = filename;
        goldCounter = 0;
        bronzeCounter =0;
        silverCounter=0;
        customers = new ArrayList<>();
        customerQueue = new PriorityArrayList<>(Customer.CustomerComparator);
    }

    /**
     * No parameter constructor only creates empty Arraylist for customers
     */
    public Simulator(){
        customers = new ArrayList<>();
    }

    /**
     * This function reads customer datas from file and store them to Arraylist for customers if file can not be found or
     * file can not be read for any reason there will be error message show
     */
    public void fileReader(){

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
/*        for (Customer customer : customers){
            System.out.printf("%s\n", customer);
        }*/
    }

    /**
     *
     */
    public void run(){
        Customer currentCustomer;
        goldCounter = 0;
        silverCounter = 0;
        bronzeCounter = 0;
        lastLoggedHour =0;
        customerQueue.add(customers.remove(0));
        currentHour = customerQueue.peek().getArrivalTimeHour();
        currentMinute = customerQueue.peek().getArrivalTimeMinute();

        while(customerQueue.peek() != null || !customers.isEmpty()){

            currentCustomer = customerQueue.poll();

            incrementTime(0,currentCustomer.getTransactionTime());
            if(currentCustomer.getType() == 1)
                ++goldCounter;
            else if(currentCustomer.getType() == 2)
                ++silverCounter;
            else
                ++bronzeCounter;

            System.out.printf("Current customer is %s current time is %d:%d\n",currentCustomer,currentHour,currentMinute);

            if(currentHour % 20 == 0 && lastLoggedHour != currentHour && currentHour != 0){
                logger();
                lastLoggedHour = currentHour;
            }

            updateQueue();
            if(customerQueue.peek() == null && customers.isEmpty())
                break;
        }
        System.out.printf("All customers served as time %d:%d\nNumber gold customer is %d\n",currentHour,currentMinute,goldCounter);
        System.out.printf("Number of silver customer is %d\nNumber of bronze customer is %d\n",bronzeCounter,silverCounter);

    }

    /**
     * In every 20 hour system will log all transaction that been made since the beginning of the program to a log file as
     * log_for_"inputfilename.extension".log
     */
    private void logger(){
        String temp,logfile;
        temp = String.format("Number of gold customer is %d\nNumber of silver customer is %d\n" +
                "Number of bronze customer is %d\nAs hour %d:%d\n",goldCounter,silverCounter,bronzeCounter,currentHour,currentMinute);
        logfile = String.format("./log_for_%s.log",filename);
        Path path = Paths.get(logfile);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Updates customerQueue using data from customers Array list.
     * If current time is bigger or equal to first entries arrival time, first element will be removed from customers array list
     * will be add to customerQueue and this operation will continue until first element of Array list's is have arrival
     * time bigger than current time.
     */
    private void updateQueue(){
        boolean flag = true;
        while (flag && !customers.isEmpty()){

            if (currentHour < customers.get(0).getArrivalTimeHour())
                flag = false;
            else if( currentHour == customers.get(0).getArrivalTimeHour() && currentMinute <= customers.get(0).getArrivalTimeMinute()){
                flag = false;
            }
            else{
                customerQueue.add(customers.remove(0));
            }

            if(!flag && customerQueue.peek() == null && !customers.isEmpty()) {
                incrementTime(0, 1);
                flag = true;
            }

        }
    }

    /**
     * Increments time by given hour and minute
     * @param hour hour to add current time
     * @param minute minute to add current time
     */
    private void incrementTime(int hour,int minute){
        currentHour += hour;
        currentMinute += minute;

        if(currentMinute > 60){
            currentHour = currentHour + (currentMinute + minute)/60;
            currentMinute = currentMinute % 60;
        }

        if(currentHour > 24){
            currentHour = currentHour % 24;
        }

    }
}
