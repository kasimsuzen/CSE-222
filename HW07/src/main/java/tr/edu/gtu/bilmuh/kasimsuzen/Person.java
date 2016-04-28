package tr.edu.gtu.bilmuh.kasimsuzen;

/**
 * This class Created by Kasım süzen 111044034 on 28.04.2016
 * This class is implemented for basic object oriented philosophy compliance
 */
public class Person {
    private int studentBarcode,academicBarcode;
    private String name;

    /**
     * No parameter constructor assign all barcodes to -1
     */
    Person(){
        studentBarcode = -1;
        academicBarcode = -1;

    }

    /**
     * Creates a Person using given parameters
     * @param studentBarcode Student barcode number of this person can be -1 if this person is not student
     * @param academicBarcode Academic barcode number of this person
     * @param name Name and surname of this person
     */
    public Person(int studentBarcode, int academicBarcode, String name) {
        this.studentBarcode = studentBarcode;
        this.academicBarcode = academicBarcode;
        this.name = name;
    }

    /**
     * Calculates hashcode for this object
     * @return Hashcode of this class as 32 bit integer
     */
    @Override
    public int hashCode(){
        long result = 17;
        result += academicBarcode;
        return (int) (result % Math.pow(2,32)-1);
    }

    /**
     * Checks if the given Person and this object is same person
     * @param obj Object of person or a class object that extends Person class
     * @return true if two are same person, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person))
            return false;
        else {
            if (obj.hashCode() == this.hashCode())
                return true;
            else
                return true;
        }
    }

    /**
     * Returns student barcode number of this person
     * @return Student barcode number, if this person is not student then this method will return -1
     */
    public int getStudentBarcode() {
        return studentBarcode;
    }

    /**
     * Sets student barcode number
     * @param studentBarcode New number to set as student barcode number
     */
    public void setStudentBarcode(int studentBarcode) {
        this.studentBarcode = studentBarcode;
    }

    /**
     * Returns academic barcode number of this person
     * @return Academic barcode number of this person, if this person is not academician this method will return -1
     */
    public int getAcademicBarcode() {
        return academicBarcode;
    }

    /**
     * Sets a new academic barcode number to this person
     * @param academicBarcode New academic barcode number to set to this person
     */
    public void setAcademicBarcode(int academicBarcode) {
        this.academicBarcode = academicBarcode;
    }

    /**
     * Returns name of this person
     * @return Name and surname of this person splinted by one white space
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of this person
     * @param name New name for this person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Print ready string of this object
     * @return String to be print
     */
    @Override
    public String toString() {
        String temp = "";
        if(studentBarcode == -1)
            temp = String.format("Name %s academic barcode %d",name,academicBarcode);
        else
            temp = String.format("Name %s academic barcode %d student barcode %d hashcode %d",name,academicBarcode,studentBarcode,hashCode());
        return temp;
    }
}
