package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;

/**
 * This class created to hold assignment data
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class Assignment {
    private String dueDate;
    private String lateDate;
    private URI assignmentFilePath;
    private int assignmentID;

    /**
     * This method returns id of this assignments
     * @return assignment id as int
     */
    public int getAssignmentID() {
        return assignmentID;
    }

    /**
     * This method sets assignment id of this file
     * @param assignmentID New id to assign
     */
    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    /**
     * This construct create a new object of this class using the given parameters
     * @param dueDate Deadline of this assignment as String
     * @param lateDate Late date of this assignment as String
     * @param assignmentFilePath Path to digital copy of this assignment as URI
     * @param assignmentID Id of this assignment as int
     */
    public Assignment(String dueDate, String lateDate, URI assignmentFilePath,int assignmentID) {
        this.dueDate = dueDate;
        this.lateDate = lateDate;
        this.assignmentFilePath = assignmentFilePath;
        this.assignmentID = assignmentID;
    }

    /**
     * Gets due date of assignment
     * @return due date as String
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets due date of this assignments
     * @param dueDate Due Date to assign as String
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets late date of this assignment
     * @return Late date ıf this assignment
     */
    public String getLateDate() {
        return lateDate;
    }

    /**
     * Sets late date of this assignment
     * @param lateDate Late date of assignment as String
     */
    public void setLateDate(String lateDate) {
        this.lateDate = lateDate;
    }

    /**
     * Gets path of assigned file
     * @return path of assignment as URI
     */
    public URI getAssignmentFilePath() {
        return assignmentFilePath;
    }

    /**
     * Sets assignment path
     * @param assignmentFilePath New path to assignment as URI
     */
    public void setAssignmentFilePath(URI assignmentFilePath) {
        this.assignmentFilePath = assignmentFilePath;
    }
}
