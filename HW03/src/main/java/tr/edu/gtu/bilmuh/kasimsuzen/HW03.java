package tr.edu.gtu.bilmuh.kasimsuzen;

/**
 * @author Kasım Süzen 111044034
 * Created by siyah on 07.03.2016
 */
class HW03 {
    public static void main(String[] args){
        SpecList<Integer> test1 = new SpecList<>();
        SpecList<Integer> test2 = new SpecList<>();
        SpecList<Integer> test3 = new SpecList<>();
        SpecList<Integer> testArrayList = new SpecList<>();
        for (int i=0; i < 50; ++i){
            test1.add(i);
            testArrayList.add(i);
            if(i%2 == 0)
                test3.add(i);
        }

        System.out.printf("\nBEGINNING OF INHERITED ADD METHOD \n");

        test2.addAllAtHead(testArrayList);
        for (int i =0; i< test1.size(); ++i){
            System.out.printf("%d %d\n",i,test1.get(i));
        }
        System.out.printf("\nEND OF INHERITED ADD METHOD");

        System.out.printf("\n\nBEGINNING OF ADD ALL AT HEAD\n");
        for (int i =0; i< test2.size(); ++i){
            System.out.printf("%d %d\n",i,test2.get(i));
        }

        System.out.printf("\nEND OF ADD ALL AT HEAD %d\n",test1.size());

        System.out.printf("\n\nBEGINNING OF GET INTERSECT LIST \n");

        SpecList<Integer> intersectList = new SpecList<>();
        intersectList = (SpecList<Integer>) test1.getIntersectList(test3);

        for (int i=0; i < intersectList.size(); ++i)
            System.out.printf("%d %d\n",i,intersectList.get(i));

        System.out.printf("\nEND OF GET INTERSECT LIST\n");

        System.out.printf("\n\nBEGINNING OF DESCENDING SORT\n");

        test1.sortList(1);
        for (int i=0; i < test1.size(); ++i)
            System.out.printf("%d %d\n",i,test1.get(i));
        System.out.printf("\nEND OF DESCENDING SORT\n");

        System.out.printf("\n\nBEGINNING OF ASCENDING SORT\n");

        test1.sortList(0);
        for (int i=0; i < test1.size(); ++i)
            System.out.printf("%d %d\n",i,test1.get(i));
        System.out.printf("\nEND OF ASCENDING SORT\n");

    }
}
