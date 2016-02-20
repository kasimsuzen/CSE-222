package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class Course {
    private String courseName;
    private String courseTeacher;
    private ArrayList<URI> file;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public ArrayList<URI> getFile() {
        return file;
    }

    public void setFile(ArrayList<URI> file) {
        this.file = file;
    }

    public boolean addFile(String newFile){
        try {
            if(file == null) {

                file = new ArrayList<URI>();
                file.add(new URI(newFile));
            }
            else{
                file.add(new URI(newFile));
            }
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
