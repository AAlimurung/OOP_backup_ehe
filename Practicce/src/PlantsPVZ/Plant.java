package PlantsPVZ;

import java.util.Comparator;

public abstract class Plant{
    public static final int INFINITE = Integer.MAX_VALUE;

    String name;
    int hp;
    int sun_cost;

    public Plant(String name, int sun_cost) {
        this.name = name;
        this.hp = 6;
        this.sun_cost = sun_cost;
    }

    public Plant(String name, int hp, int sun_cost) {
        this.name = name;
        this.hp = hp;
        this.sun_cost = sun_cost;
    }

    public boolean isAlive() {
        // TODO implementation
        return hp > 0;
        //return true;
    }

    public String die() {
        // TODO implementation
        hp = 0;
        return this.name + " dies";
    }

    @Override
    public String toString() {
        // TODO implementation
        if(hp == INFINITE){
            return name + " (∞) - cost: " + sun_cost;
        }
        return name + " (" + hp + ") " + "- cost: " + sun_cost;
    }

    // Add Plant subclasses here, and
    // Hint: You can also add Comparator inner classes here
    // WallNut and CoffeeBean given for free
    public static class WallNut extends Plant{
        public WallNut() {
            super("Wall Nut", 25, 50);
        }
    }

    public static class CoffeeBean extends Plant{
        public CoffeeBean() {
            super("Coffee Bean", INFINITE, 75);
        }
    }

    public static class Sunflower extends Plant implements SunProducer, Upgradable{
        public Sunflower(){
            super("Sunflower", 50);
        }

        public int produce_sun(){
            System.out.println(name + " produces 25 suns");
            return 25;
        }

        @Override
        public PlantUpgrade upgrade() {
            return new TwinSunflower();
        }
    }

    public static class TwinSunflower extends Plant implements SunProducer, PlantUpgrade{
        public TwinSunflower() {
            super("Twin Sunflower", 250);
        }

        @Override
        public int produce_sun() {
            System.out.println(name + " produces 50 suns");
            return 50;
        }

        @Override
        public int concurrentSunCost() {
            return 50;
        }
    }
    public static class Peashooter extends Plant implements Attacker{
        public Peashooter(){
            super("Peashooter", 100);
        }

        public int attack(){
            System.out.println(name + " attacks");
            return 1;
        }

        public RangeType rangeType(){
            return RangeType.SINGLE_LINE;
        }
    }

    public static class Squash extends Plant implements InstantKiller, Attacker{
        public Squash(){
            super("Squash", INFINITE, 50);
        }

        public KillType killType(){
            return KillType.CLOSE_ON;
        }

        public int attack(){
            System.out.println(name + " attacks");
            System.out.println(die());
            return 3;
        }

        public RangeType rangeType(){
            return RangeType.LIMITED;
        }

        public String die(){
            return super.die() + " while squashing zombies";
        }
    }

    public static class Jalapeno extends Plant implements InstantKiller, Attacker{
        public Jalapeno(){
            super("Jalapeno", INFINITE, 125);
        }

        public String die(){
            return super.die() + " while exploding";
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            System.out.println(die());
            return 5;
        }

        @Override
        public RangeType rangeType() {
            return RangeType.SINGLE_LINE;
        }

        public KillType killType(){
            return KillType.INSTANT;
        }
    }

    public static class LilyPad extends Plant implements Upgradable{
        public LilyPad(){
            super("Lily Pad", 25);
        }

        @Override
        public PlantUpgrade upgrade() {
            return new Cattail();
        }
    }

    public static class Cattail extends Plant implements PlantUpgrade, Attacker{

        public Cattail() {
            super("Cattail", 225);
        }

        @Override
        public int concurrentSunCost() {
            return 150;
        }

        @Override
        public int attack() {
            System.out.println(name + " attacks");
            return 1;
        }

        @Override
        public RangeType rangeType() {
            return RangeType.FREE_RANGE;
        }
    }
    public static class sortbyHP implements Comparator<Plant>{
        @Override
        public int compare(Plant o1, Plant o2){
            if(o1.hp < o2.hp)
                return 1;
            else if(o1.hp == o2.hp){
                NameComparator halo = new NameComparator();
                return halo.compare(o1, o2);
            }
            return -1;
        }
    }

    public static class NameComparator implements Comparator<Plant>{
        @Override
        public int compare(Plant o1, Plant o2){

            return o1.name.compareTo(o2.name);
        }
    }

    public static class sortbySunCost implements Comparator<Plant>{
        @Override
        public int compare(Plant o1, Plant o2){
            if(o1.sun_cost < o2.sun_cost){
                return 1;
            } else if (o1.sun_cost == o2.sun_cost) {
                NameComparator halo = new NameComparator();
                return halo.compare(o1, o2);
            }
            return -1;
        }
    }
}