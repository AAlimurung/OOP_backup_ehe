package FoodGalore;

public class Human {
    public int satietyLevel;
    public void getSatiety(){
        if(satietyLevel < 50){
            System.out.println("Hungry");
        } else if (satietyLevel <= 90 && satietyLevel >= 50) {
            System.out.println("Satiated");
        }else {
            System.out.println("Full");
        }
    }

    public void feed(FoodInterface food){
        int satietyPoints = food.eat();
        this.satietyLevel += satietyPoints;
        if(satietyLevel>=100){
            satietyLevel = 100;
        }
    }
}
