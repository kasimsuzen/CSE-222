package tr.edu.gtu.bilmuh.ksuzen;

/**
 * @author Kasım Süzen
 * Created by siyah on 20.02.2016.
 */
public class abstractUser implements userInterface{
    private int IDNo;
    private String name;

    @Override
    public int getIDNo() {
        return IDNo;
    }

    @Override
    public void setIDNo(int IDNo) {
        this.IDNo = IDNo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
