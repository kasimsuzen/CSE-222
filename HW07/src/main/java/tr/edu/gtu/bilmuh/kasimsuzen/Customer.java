package tr.edu.gtu.bilmuh.kasimsuzen;

import java.util.Comparator;

/**
 * Created by kasim on 27.04.2016
 *
 */
public class Customer{
    private int type;
    private int arrivalTimeHour;
    private int arrivalTimeMinute;
    private int transactionTime;

    public Customer(int type, int arrivalTimeHour, int arrivalTimeMinute, int transactionTime) {
        this.type = type;
        this.arrivalTimeHour = arrivalTimeHour;
        this.arrivalTimeMinute = arrivalTimeMinute;
        this.transactionTime = transactionTime;
    }

    public Customer() {
        type = -1;
        arrivalTimeHour = -1;
        arrivalTimeMinute = -1;
        transactionTime = -1;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getArrivalTimeHour() {
        return arrivalTimeHour;
    }

    public void setArrivalTimeHour(int arrivalTimeHour) {
        this.arrivalTimeHour = arrivalTimeHour;
    }

    public int getArrivalTimeMinute() {
        return arrivalTimeMinute;
    }

    public void setArrivalTimeMinute(int arrivalTimeMinute) {
        this.arrivalTimeMinute = arrivalTimeMinute;
    }

    public int getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(int transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Override
    public String toString(){
        String temp = new String();
        temp = String.format("Customer%d arrival time %d:%d transaction time %d",type,arrivalTimeHour,arrivalTimeMinute,transactionTime );
        return temp;
    }

    public static Comparator<Customer> CustomerComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
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
        }
    };

}
