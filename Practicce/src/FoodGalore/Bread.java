package FoodGalore;

public class Bread extends Human implements FoodInterface{
    private int satietyPoints;
    public Bread() {
        this.satietyPoints = 10;
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
