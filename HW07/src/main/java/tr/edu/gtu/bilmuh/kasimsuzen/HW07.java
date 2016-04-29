package tr.edu.gtu.bilmuh.kasimsuzen;

/**
 * This class Created by Kasım süzen 111044034 on 28.04.2016
 * Purpose of this class is making integration test of part1 and part2 of this homework
 */
public class HW07 {
    /**
     * Main method to run and test
     * @param args Irrelevant argument string
     */
    public static void main(String[] args){
        boolean flag;
        Person person1,person2;
        System.out.printf("PART1 TEST FOR DATA1.TXT \n");
        Simulator Part1Simulator1 = new Simulator("data1.txt");
        Part1Simulator1.fileReader();
        Part1Simulator1.run();
        System.out.printf("END OF PART1 TEST FOR DATA1.TXT \n\n\n");

        System.out.printf("PART1 TEST FOR DATA2.TXT \n");
        Simulator Part1Simulator2 = new Simulator("data2.txt");
        Part1Simulator2.fileReader();
        Part1Simulator2.run();
        System.out.printf("END OF PART1 TEST FOR DATA2.TXT \n\n\n");

        System.out.printf("PART2 TEST \n");
        University uni = new University("part2.txt");
        flag = uni.fileReader();
        if(flag)
            System.out.printf("There was at least one collision in part2 test\n");
        else
            System.out.printf("There is no collision in part2 test\n");

        person1 = new Person(6525-5000,6525,"Francis Pope");
        person2 = new Person(1529,6529,"Irving Blake");

        if(uni.isSamePerson(person1.getStudentBarcode(), person1.getAcademicBarcode()))
            System.out.printf("Person1 is research assistant \n");
        else
            System.out.printf("Given values to isSameMethod are same person but method returns false there is error\n");

        if(uni.isSamePerson(person1.getStudentBarcode(), person2.getAcademicBarcode()))
            System.out.printf("Person1 and Person2 is not same person \n");
        else
            System.out.printf("Given values to isSameMethod are not same person but method return true there is error\n");

    }
}
