package tr.edu.gtu.bilmuh.ksuzen;

import java.net.URI;

/**
 * This file created for assignment submission data holding
 * @author Kasım Süzen
 * Created by siyah on 24.02.2016.
 */
public class SubmittedAssignmentFile {
    private Student owner;
    private URI filePath;
    private int assignmentID;

    /**
     * This method returns this assignments id which was given by teacher
     * @return assignment ID given by teacher of this class
     */
    public int getAssignmentID() {
        return assignmentID;
    }

    /**
     * This method sets assignment id before submitting assignment
     * @param assignmentID id to assign as int
     */
    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    /**
     * This constructor create object of this class using given parameters
     * @param owner Owner of this assignment as Student object
     * @param filePath File path to digital copy of assignment as URI of java.net.URI
     * @param assignmentID Assignment ID of this assignment given by teacher as int
     */
    public SubmittedAssignmentFile(Student owner, URI filePath, int assignmentID) {
        this.owner = owner;
        this.filePath = filePath;
        this.assignmentID = assignmentID;
    }

    /**
     * This method returns owner of this assignment as Student
     * @return Owner of this assignment as Student
     */
    public Student getOwner() {
        return owner;
    }

    /**
     * This method set ownership of this assignment "THIS METHOD IS DANGEROUS SHOULD NOT BE USE IF YOU DO NOT WHAT ARE YOU DOING"
     * @param owner New owner this asignment as Student object
     */
    public void setOwner(Student owner) {
        this.owner = owner;
    }

    /**
     * This method returns path of digital copy assignment
     * @return Path to digital copy of assignment as URI
     */
    public URI getFilePath() {
        return filePath;
    }

    /**
     * This method sets path of this assignment "THIS METHOD IS DANGEROUS SHOULD NOT BE USE IF YOU DO NOT WHAT ARE YOU DOING"
     * @param filePath New path to assignment
     */
    public void setFilePath(URI filePath) {
        this.filePath = filePath;
    }
}
