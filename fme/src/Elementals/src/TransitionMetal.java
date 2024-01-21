null
package Elementals;

public class TransitionMetal extends Element {

    public TransitionMetal(String elsym, String elname, int atomnum, double atomweight, double melt, double boil) {
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


    public static class Titanium extends TransitionMetal{
        public Titanium(){
            super("Ti", "Titanium", 22, 47.9, 1668, 3287);
        }
    }

    public static class Gold extends TransitionMetal implements Conductive{
        public Gold(){
            super("Au", "Gold", 79, 197, 1064, 2970);
        }

        @Override
        public float percent_c() {
            return (float)0.7;
        }
    }

    public static class Zinc extends TransitionMetal implements Conductive{
        public Zinc(){
            super("Zn", "Zinc", 30, 65.4, 419.5, 907.0);
        }

        @Override
        public float percent_c() {
            return (float) 0.27;
        }
    }

    public static class Iron extends TransitionMetal implements Magnetic{
        public Iron(){
            super("Fe", "Iron", 26, 55.8, 1538, 2862);
        }

        @Override
        public int magn_strength() {
            return 1710;
        }

        public Type magn_type(){
            return Type.ferromagnetic;
        }
    }

    public static class Copper extends TransitionMetal implements Conductive{
        public Copper(){
            super("Cu", "Copper", 29, 63.5, 1085, 2562);
        }

        @Override
        public float percent_c() {
            return (float) 1.0;
        }
    }

    public static class Technetium extends TransitionMetal implements Conductive, Radioactive, Magnetic{
        public Technetium(){
            super("Tc", "Technetium", 43, 98, 2157, 4265);
        }

        @Override
        public float percent_c() {
            return (float) 0.65;
        }

        @Override
        public void hanyo() {
            System.out.println(toString() + " emitting radiation");
            System.out.println(toString() + "'s half-life: 61");
        }

        @Override
        public int magn_strength() {
            return 270;
        }

        @Override
        public Type magn_type() {
            return Type.paramagnetic;
        }
    }
}