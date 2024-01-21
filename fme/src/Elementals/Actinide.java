package Elementals;

public class Actinide extends Element{
    public Actinide(String elsym, String elname, int atomnum, double atomweight, double melt, double boil) {
        super(elsym, elname, atomnum, atomweight, melt, boil);
    }

    public String state(float temp){
        if(temp <= getMelt()){
            return "solid";
        }else if(temp > getMelt() && temp < getBoil()){
            return "liquid";
        }else {
            return "gas";
        }
    }

    public static class Uranium extends Actinide implements Radioactive {
        public Uranium(){
            super("U", "Uranium", 92, 238, 1132.2, 4131);
        }

            public void hanyo(){
                System.out.println(toString() + " emitting radiation");
                System.out.println(toString() + "'s half-life: 25166");
            }
    }
}
