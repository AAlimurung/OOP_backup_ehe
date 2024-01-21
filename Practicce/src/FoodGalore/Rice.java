package FoodGalore;

public class Rice extends Human implements FoodInterface{
    private int satietyPoints;
    public Rice() {
        this.satietyPoints = 20;
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
