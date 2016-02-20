package tr.edu.gtu.bilmuh.ksuzen;

/**
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class Admin extends abstractUser {

    public void listAllUsers(){
        // TODO print all users from school
    }

    public boolean addUser(abstractUser newUser){
        try{
            // TODO add School class and store all user info at that class
            return true;
        }

        catch (Exception e){
            return false;
        }

    }

    public boolean removeUser(abstractUser obsoloteUser){
        try {
            // TODO add School class and store all user info at that class
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /*
    public boolean addCourse(Course newCourse){
        try{
            // TODO add Course class
            return true;
        }
        catch (Exception e){
            return false;
        }
    }*/

    /*
    public boolean removeCourse(Course obsoloteCourse){
        try{
            // TODO add Course class
            return true;
        }
        catch (Exception e){
            return false;
        }
    }*/
}
