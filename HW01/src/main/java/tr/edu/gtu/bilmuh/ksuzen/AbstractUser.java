package tr.edu.gtu.bilmuh.ksuzen;

/**
 * Every user of this program must extends this Abstract Class
 * @author Kasım Süzen
 * Created on 20.02.2016
 */
public class AbstractUser implements userInterface{
    private int IDNo;
    private String name;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIDNo() {
        return IDNo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setIDNo(int IDNo) {
        this.IDNo = IDNo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns name and id number of called user
     * @return name and id number of called user
     */
    @Override
    public String toString() {
        String temp = "";

        temp += getName();
        temp += Integer.toString(getIDNo());
        return temp;
    }
}
