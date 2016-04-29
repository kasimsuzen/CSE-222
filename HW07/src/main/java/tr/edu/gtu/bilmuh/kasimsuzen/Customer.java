package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Comparator;

/**
 * This class Created by Kasım süzen 111044034 on 28.04.2016
 * This class implemented for basic data storage of customers
 */
public class Customer{
    private int type;
    private int arrivalTimeHour;
    private int arrivalTimeMinute;
    private int transactionTime;

    /**
     * Creates Customer using given parameter
     * @param type Type of customer this value can't be bigger than 3 and lesser than 1
     * @param arrivalTimeHour Arrival hour of Customer this value can't be bigger than 24 or lesser than 0
     * @param arrivalTimeMinute Arrival minute of Customer this value can't be bigger than 60 or lesser than 0
     * @param transactionTime Transaction time of customer this value have to be bigger than 0. and this value is minute type
     */
    public Customer(int type, int arrivalTimeHour, int arrivalTimeMinute, int transactionTime) {
        this.type = type;
        this.arrivalTimeHour = arrivalTimeHour;
        this.arrivalTimeMinute = arrivalTimeMinute;
        this.transactionTime = transactionTime;
    }

    /**
     * No parameter constructor
     * Assigns all values to -1
     */
    public Customer() {
        type = -1;
        arrivalTimeHour = -1;
        arrivalTimeMinute = -1;
        transactionTime = -1;
    }

    /**
     * Returns type of customer
     * @return Type of customer
     */
    public int getType() {
        return type;
    }

    /**
     * Sets type of customer
     * @param type type of customer, this value can't be bigger than 3 and lesser than 1
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Gets hour of arrival time of customer
     * @return Arrival time of customer as hour
     */
    public int getArrivalTimeHour() {
        return arrivalTimeHour;
    }

    /**
     * Sets minute of arrival for this customer
     * @param arrivalTimeHour Arrival hour of Customer this value can't be bigger than 24 or lesser than 0
     */
    public void setArrivalTimeHour(int arrivalTimeHour) {
        this.arrivalTimeHour = arrivalTimeHour;
    }

    /**
     * Gets arrival time of customer
     * @return Arrival time of customer as minutes
     */
    public int getArrivalTimeMinute() {
        return arrivalTimeMinute;
    }

    /**
     * Sets arrival minute of this customer
     * @param arrivalTimeMinute Arrival minute of Customer this value can't be bigger than 60 or lesser than 0
     */
    public void setArrivalTimeMinute(int arrivalTimeMinute) {
        this.arrivalTimeMinute = arrivalTimeMinute;
    }

    /**
     * Gets transaction time of this customer
     * @return Transaction time as minute
     */
    public int getTransactionTime() {
        return transactionTime;
    }

    /**
     * Sets transaction time of this costumer
     * @param transactionTime Transaction time of customer this value have to be bigger than 0. and this value is minute type
     */
    public void setTransactionTime(int transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     * String equivalent of this object
     * @return String equivalent of this object
     */
    @Override
    public String toString(){
        String temp = new String();
        temp = String.format("Customer%d arrival time %d:%d transaction time %d",type,arrivalTimeHour,arrivalTimeMinute,transactionTime );
        return temp;
    }

    /**
     * Lambda expression as overridden comparator for Customer class
     */
    public static Comparator<Customer> CustomerComparator = (o1, o2) -> {
        if(o1.getType() < o2.getType())
            return -1;
        if(o1.getType() > o2.getType())
            return 1;
        if(o1.getType() == o2.getType()) {
            if (o1.getArrivalTimeHour() < o2.getArrivalTimeHour())
                return -1;
            if (o1.getArrivalTimeHour() > o2.getArrivalTimeHour())
                return 1;
            if(o1.getArrivalTimeHour() == o2.getArrivalTimeHour()){
                if(o1.getArrivalTimeMinute() < o2.getArrivalTimeMinute())
                    return -1;
                if(o1.getArrivalTimeMinute() > o2.getArrivalTimeMinute())
                    return 1;
                else
                    return 0;
            }
        }
        return 0;
    };

}
