package kopibiiin;

import java.util.ArrayList;
import java.util.List;

//composite class 2
public class Soda implements CaffeineContent, ServingSize{
    private int size;
    private int caflvl;
    private String name;

    List<Soda> sodas = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCaflvl() {
        return caflvl;
    }

    public void setCaflvl(int caflvl) {
        this.caflvl = caflvl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soda(int size, int caflvl, String name) {
        this.size = size;
        this.caflvl = caflvl;
        this.name = name;
    }

    @Override
    public void cafcont() {
        System.out.println(getName() + ": " + getCaflvl() + " (mg)");
        for(Soda s : sodas){
            s.cafcont();
        }
    }

    @Override
    public void serves() {
        System.out.println(getName() + ": " + getSize() + " oz.");
        for(Soda s : sodas){
            s.serves();
        }
    }
}
