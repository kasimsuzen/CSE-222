package tr.edu.gtu.bilmuh.ksuzen;

/**
 * Every user of this program must be extend this interface
 * @author Kasım Süzen
 * Created by kasim on 19.02.2016.
 */
public interface userInterface {
    /**
     * Returns name of the user as String
     * @return name of the user as String
     */
    public String getName();

    /**
     * Returns id of user
     * @return id of user as int
     */
    public int getIDNo();

    /**
     * Sets name of user
     * @param newName new name of user as String
     */
    public void setName(String newName);

    /**
     * Sets id of user
     * @param newNo new id as int
     */
    public void setIDNo(int newNo);
}
