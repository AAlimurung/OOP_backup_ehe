null
package Elementals;

public abstract class Element implements Comparable<Element>{
    private String elsym;
    private String elname;
    private int atomnum;
    private double atomweight;

    private double melt;
    private double boil;
    public Element(String  elsym, String elname, int atomnum, double atomweight, double melt, double boil) {
        this.elsym = elsym;
        this.elname = elname;
        this.atomnum = atomnum;
        this.atomweight = atomweight;
        this.melt = melt;
        this.boil = boil;
    }

    public String getElsym() {
        return elsym;
    }

    public String getElname() {
        return elname;
    }

    public int getAtomnum() {
        return atomnum;
    }

    public double getAtomweight() {
        return atomweight;
    }

    public double getMelt() {
        return melt;
    }

    public double getBoil() {
        return boil;
    }

    public abstract String state(float temp);

    @Override
    public String toString() {
        return getAtomnum() + " " + getElname() + " (" + getElsym() + ")";
    }

    public int compareTo(Element other){
        if(this.atomweight > other.atomweight){
            return 1;
        }else {
            return -1;
        }
    }
}