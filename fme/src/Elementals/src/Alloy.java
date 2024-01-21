null
package Elementals;
import java.util.ArrayList;
public abstract class Alloy {
    String name;
    public ArrayList<Element> newdawn = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ArrayList<Element> getNewdawn() {
        return newdawn;
    }

    @Override
    public String toString() {
        return getName();
    }

    public static class Steel extends Alloy implements Magnetic{
        public Steel(){
            super.name = "Steel";
            newdawn.add(new TransitionMetal.Iron());
            newdawn.add(new TransitionMetal.Copper());
        }

        @Override
        public int magn_strength() {
            return 1950;
        }

        @Override
        public Type magn_type() {
            return Type.ferromagnetic;
        }
    }

    public static class Bronze extends Alloy{
        public Bronze(){
            super.name = "Bronze";
            newdawn.add(new PostTransitionMetal.Tin());
            newdawn.add(new TransitionMetal.Copper());
        }
    }

    public static class Brass extends Alloy implements Conductive{
        public Brass(){
            super.name = "Brass";
            newdawn.add(new TransitionMetal.Copper());
            newdawn.add(new TransitionMetal.Zinc());
        }


        @Override
        public float percent_c() {
            return (float) 0.28;
        }
    }
}