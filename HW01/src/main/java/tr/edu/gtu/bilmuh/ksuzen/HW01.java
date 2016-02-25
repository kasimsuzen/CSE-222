package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;
import java.util.ArrayList;

/**
 * This file created for testing test cases
 * @author Kasım Süzen 111044034
 * Created by siyah on 20.02.2016.
 */


public class HW01 {
    public static void main(String[] args){
        School.getInstance().addUser(new Admin("admin1"));
        Admin admin1 = (Admin) School.getInstance().getUserList().get(0);

        System.out.printf("STARTING ADMIN TEST CASES\n\n");
        // TEST CASES OF ADMIN
        // admin add user
        admin1.addUser(new Admin("admin2"));
        Student tempStudent = new Student("tempStudent1");
        admin1.addUser(tempStudent);

        ArrayList<AbstractUser> tempUserList = School.getInstance().getUserList();
        System.out.printf("\nUser list after admin added user %s\n",tempStudent);
        for (AbstractUser aUser: tempUserList) {
            if(tempUserList.size() != 0)
                System.out.printf("%s\n",aUser);
            else
                System.out.printf("Returned user list is empty\n");
        }

        // Admin user remove
        admin1.removeUser(tempStudent);
        System.out.printf("\nUser list after admin removed user %s\n",tempStudent);

        for (AbstractUser aUser: tempUserList) {
            if(tempUserList.size() != 0)
                System.out.printf("%s\n",aUser);
            else
                System.out.printf("Returned user list is empty\n");
        }

        // Admin add Course
        Teacher tempTeacher = new Teacher("tempTeacher1");
        admin1.addUser(tempTeacher);
        Course tempCourse = new Course("tempCourseName",tempTeacher,false);
        admin1.addCourse(tempCourse);
        ArrayList<Course> tempCourseList = School.getInstance().getCourseList();

        System.out.printf("\nCourse List after admin add course %s\n",tempCourse);

        if(tempCourseList.size() != 0)
            tempCourseList.stream().filter(aCourse -> tempUserList.size() != 0).forEach(aCourse -> System.out.printf("%s\n", aCourse));
        else
            System.out.printf("\nReturned course list is empty\n");

        admin1.removeCourse(tempCourse);

        System.out.printf("\nCourse list after admin removed course %s\n",tempCourse);

        if(tempCourseList.size() != 0)
            tempCourseList.stream().filter(aCourse -> tempUserList.size() != 0).forEach(aCourse -> System.out.printf("%s\n", aCourse));
        else
            System.out.printf("Returned course list is empty\n");

        System.out.printf("END OF ADMIN TEST CASES\n\n");

        // TEACHER TEST CASE
        System.out.printf("START OF TEACHER TEST CASES\n\n");

        // Teacher adds user
        tempTeacher.addUser(tempStudent);

        ArrayList<AbstractUser> tempUserList2 = School.getInstance().getUserList();
        System.out.printf("\nUser list after teacher added user %s\n",tempStudent);
        for (AbstractUser aUser: tempUserList2) {
            if(tempUserList2.size() != 0)
                System.out.printf("%s\n",aUser);
            else
                System.out.printf("Returned user list is empty\n");
        }

        // Teacher user remove
        tempTeacher.removeUser(tempStudent);
        System.out.printf("\nUser list after teacher removed user %s\n",tempStudent);

        for (AbstractUser aUser: tempUserList2) {
            if(tempUserList2.size() != 0)
                System.out.printf("%s\n",aUser);
            else
                System.out.printf("Returned user list is empty\n");
        }

        // Teacher adds assignment
        admin1.addCourse(tempCourse);
        tempTeacher.addAssignment("tempCourseName","25/02/2016","24/05/2016","pathToAssignmentTest",5);

        ArrayList<Assignment>  tempAssignmentList = School.getInstance().getCourseList().get(0).getGivenAssignment();

        System.out.printf("\nAssignment list after teacher add assignment\n");

        if(tempAssignmentList.size() != 0) {
            for (Assignment anAssign : tempAssignmentList) {
                System.out.printf("%s %s %s %d\n", anAssign.getAssignmentFilePath(), anAssign.getDueDate(), anAssign.getLateDate(), anAssign.getAssignmentID());
            }
        }
        else
            System.out.printf("Assignment list returned empty something went wrong\n");

        // Teacher adds documents
        tempTeacher.addDocumentToClass(tempCourse.getCourseName(),"pathToFileOfDocForTest");

        ArrayList<URI> tempURIList = School.getInstance().getCourseList().get(0).getFile();

        System.out.printf("\n Document list after teacher add assignment\n");

        if(tempAssignmentList.size() != 0){
            for (URI anURI: tempURIList) {
                System.out.printf("%s\n",anURI.toString());
            }
        }
        else
            System.out.printf("File list returned empty something gone bad\n");

        System.out.printf("\nEND OF TEACHER TEST CASES\n");

        // Tutor test cases
        System.out.printf("\nSTART OF TUTOR TEST CASES\n");
        // Adding Tutor the system
        Tutor tempTutor = new Tutor("tempTutor");
        admin1.addUser(tempTutor);

        System.out.printf("Tutor want to see all courses list to register \n");
        tempTutor.listAllCourses();

        System.out.printf("\nEND OF TUTOR TEST CASES\n");

        System.out.printf("\nSTART OF STUDENT TEST CASES\n");
        // Student register to class
        tempStudent.registerToCourse(tempCourse.getCourseName());
        ArrayList<Integer> tempUserList3 = School.getInstance().getCourseList().get(0).getRegisteredStudentIDs();

        System.out.printf("Student tries to enroll class \n");
        if (tempUserList3.size() != 0)
            tempUserList3.stream().filter(anInt -> anInt == tempStudent.getIDNo()).forEach(anInt -> System.out.printf("Registration is successful\n"));
        else
            System.out.printf("User List for this course returned empty something gone wrong\n");

        // Student submit assignment
        System.out.printf("\nStudent tries to submit assignment \n");
        tempStudent.submitAssignment(tempCourse.getCourseName(),"pathToSubmittedFile",5);

        ArrayList<SubmittedAssignmentFile> tempSubmit = School.getInstance().getCourseList().get(0).getSubmittedAssignments();

        System.out.printf("Submitted assignment list after submission\n");
        if(tempSubmit.size() != 0) {
            for (SubmittedAssignmentFile aSubmit : tempSubmit) {
                System.out.printf("%s %s %s\n", aSubmit.getOwner(), aSubmit.getFilePath(), aSubmit.getAssignmentID());
            }
        }
        else
            System.out.printf("Submitted assignment list is empty something gone wrong\n");
        System.out.printf("\nEND OF STUDENT TEST CASES\n");


    }
}
