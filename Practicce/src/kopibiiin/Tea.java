package kopibiiin;

//leaf class no. 1
public class Tea implements ServingSize{
    private int size;
    private int caflvl;
    private String name;

    public Tea(int size, int caflvl, String name) {
        this.size = size;
        this.caflvl = caflvl;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public int getCaflvl() {
        return caflvl;
    }

    public String getName() {
        return name;
    }

    @Override
    public void serves() {
        System.out.println(getName() + ": " + getSize() + " oz.");
    }
}
