package Elementals;

public class PostTransitionMetal extends Element {

    public PostTransitionMetal(String elsym, String elname, int atomnum, double atomweight, double melt, double boil) {
        super(elsym, elname, atomnum, atomweight, melt, boil);
    }

    @Override
    public String state(float temp) {
        if(temp <= getMelt()){
            return "solid";
        }else if(temp > getMelt() && temp < getBoil()){
            return "liquid";
        }else {
            return "gas";
        }
    }

    public static class Tin extends PostTransitionMetal{
        public Tin(){
            super("Sn", "Tin", 50, 118.7, 231.9, 2602);
        }
    }

    public static class Aluminum extends PostTransitionMetal implements Conductive{
        public Aluminum(){
            super("Al", "Aluminum", 13, 27, 66.3, 2470);
        }

        @Override
        public float percent_c() {
            return (float)0.61;
        }
    }
}
