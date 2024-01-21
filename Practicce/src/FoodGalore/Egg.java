package FoodGalore;

public class Egg extends Human implements FoodInterface{
    private int satietyPoints;

    public Egg() {
        this.satietyPoints = 5;
    }

    @Override
    public void cook(int n) {
        satietyPoints *= n;
    }

    @Override
    public int eat() {
        return this.satietyPoints;
    }
}
