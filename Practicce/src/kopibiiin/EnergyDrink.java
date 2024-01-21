package kopibiiin;

//leaf class no. 2
public class EnergyDrink implements CaffeineContent, ServingSize{
    private int size;
    private int caflvl;
    private String name;

    public EnergyDrink(int size, int caflvl, String name) {
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
    public void cafcont() {
        System.out.println(getName() + ": " + getCaflvl() + " oz.");
    }

    @Override
    public void serves() {
        System.out.println(getName() + ": " + getSize() + " oz.");
    }
}
