package FoodGalore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Hey there, start typing your Java code here
        Scanner sc = new Scanner(System.in);
        Human human = new Human();
        System.out.print("Enter the number of times to cook Egg: ");
        int intake = sc.nextInt();
        Egg egg = new Egg();
        egg.cook(intake);

        System.out.print("Enter the number of times to cook Bread: ");
        intake = sc.nextInt();
        Bread bread = new Bread();
        bread.cook(intake);

        System.out.print("Enter the number of times to cook Rice: ");
        intake = sc.nextInt();
        Rice rice = new Rice();
        rice.cook(intake);

        System.out.print("Enter the number of times to cook Meat: ");
        intake = sc.nextInt();
        Meat meat = new Meat();
        meat.cook(intake);

        human.feed(egg);
        human.feed(bread);
        human.feed(rice);
        human.feed(meat);

        Tester.test(human, egg, bread, rice, meat);
    }
}