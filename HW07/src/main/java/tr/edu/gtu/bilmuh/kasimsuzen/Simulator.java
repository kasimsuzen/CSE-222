package tr.edu.gtu.bilmuh.kasimsuzen;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by kasim on 27.04.2016
 *
 */
public class Simulator {
    private String filename;
    private ArrayList<Customer> customers;
    private PriorityArrayList<Customer> customerQueue;
    private int goldCounter,bronzeCounter,silverCounter,currentHour,currentMinute,lastLoggedHour;

    public Simulator(String filename) {
        this.filename = filename;
        goldCounter = 0;
        bronzeCounter =0;
        silverCounter=0;
        customers = new ArrayList<>();
        customerQueue = new PriorityArrayList<>(Customer.CustomerComparator);
    }

    public Simulator(){
        customers = new ArrayList<>();
    }

    public void readFile(){

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

    private void logger(){
        String temp;
        temp = String.format("Number of gold customer is %d\nNumber of silver customer is %d\n" +
                "Number of bronze customer is %d\nAs hour %d:%d\n",goldCounter,silverCounter,bronzeCounter,currentHour,currentMinute);

        Path path = Paths.get("./part1.log");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(temp);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateQueue(){
        boolean flag = true;
        while (flag && !customers.isEmpty()){

            if (currentHour < customers.get(0).getArrivalTimeHour() && currentMinute <= customers.get(0).getArrivalTimeMinute())
                flag = false;
            else{
//                currentHour = customers.get(0).getArrivalTimeHour();
//                currentMinute = customers.get(0).getArrivalTimeMinute();
                customerQueue.add(customers.remove(0));
                System.out.printf("");
            }

        }
    }

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

    public static void main(String[] args){
        Simulator a = new Simulator("data2.txt");
        a.readFile();
        a.run();
    }

}
