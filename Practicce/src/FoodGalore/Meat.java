package FoodGalore;

public class Meat extends Human implements FoodInterface{
    private int satietyPoints;
    public Meat() {
        this.satietyPoints = 40;
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
